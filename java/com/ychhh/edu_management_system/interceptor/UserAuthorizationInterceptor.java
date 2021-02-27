package com.ychhh.edu_management_system.interceptor;

import com.ychhh.edu_management_system.annotation.Login;
import com.ychhh.edu_management_system.entity.SysUser;
import com.ychhh.edu_management_system.enums.ResultCodeEnum;
import com.ychhh.edu_management_system.service.SysUserTokenService;
import com.ychhh.edu_management_system.utils.ResponseException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证-sysuser系统
 */

@Log4j2
@Component
public class UserAuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysUserTokenService sysUserTokenService;

    public static final String SYS_USER_KEY = "sysLoginUser";


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清理threadlocal
        sysUserTokenService.clearTokenFromThread();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }
        //token为空
        if(StringUtils.isBlank(token)){
            throw new ResponseException(ResultCodeEnum.PARAM_ERROR.getCode(),  ResultCodeEnum.PARAM_ERROR.getDesc());
        }

        //查询token信息
        SysUser user = sysUserTokenService.getUserByToken(token);
        if(user == null){
            //登陆失效
            throw new ResponseException(ResultCodeEnum.USER_TOKEN_EXPIRED.getCode(),ResultCodeEnum.USER_TOKEN_EXPIRED.getDesc());
        }

        //当前用户token放入threadlocal
        sysUserTokenService.setTokenToThread(token);

        //刷新登陆过期时间
        sysUserTokenService.refreshLoginExpire(token);
        request.setAttribute(SYS_USER_KEY,user);

        return true;
    }



}
