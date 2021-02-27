package com.ychhh.edu_management_system.controller;

import com.ychhh.edu_management_system.dto.SysDeptDTO;
import com.ychhh.edu_management_system.entity.SysDept;
import com.ychhh.edu_management_system.entity.SysUser;
import com.ychhh.edu_management_system.form.SysLoginForm;
import com.ychhh.edu_management_system.service.SysDeptService;
import com.ychhh.edu_management_system.service.SysUserService;
import com.ychhh.edu_management_system.service.SysUserTokenService;
import com.ychhh.edu_management_system.utils.ResponseException;
import com.ychhh.edu_management_system.utils.ResponseMessage;
import com.ychhh.edu_management_system.vo.LoginVO;
import com.ychhh.edu_management_system.vo.SysDeptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/sys/user")
@Api(value = "系统管理员")
public class SysUserController implements Serializable {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysUserTokenService sysUserTokenService;

    @GetMapping("/select")

    public ResponseMessage select(@PathVariable("id") Long id){
        SysUser sysUser =sysUserService.selectByPrimaryKey(id);
        return ResponseMessage.success(sysUser);
    }
    @GetMapping("/selectAll")
    public ResponseMessage selectAll(){
        List<SysUser> list =sysUserService.selectAll();
        return ResponseMessage.success(list);
    }

    @GetMapping("/delete")
    public ResponseMessage delete(Long id){
        sysUserService.deleteByPrimaryKey(id);
        return ResponseMessage.success();
    }
    @PostMapping("/save")
    public ResponseMessage save(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return ResponseMessage.success();
    }
    @PostMapping("/update")
    public ResponseMessage update(@RequestBody SysUser sysUser) {
        sysUserService.updateByPrimaryKey(sysUser);
        return ResponseMessage.success();
    }


    @PostMapping("/login")
    public ResponseMessage login(@RequestBody SysLoginForm  sysLoginForm, HttpServletRequest request) {
//        sysUserService.;
        System.out.println("调用成功");
        System.out.println(sysLoginForm);
        boolean b=false;
        Object token=null;
        SysUser sysUser=sysUserService.selectByName(sysLoginForm.getUsername());
        if (sysUser==null){
            throw new ResponseException("该账户没有注册,请联系管理员添加");
        }
        if (sysUser.getPassword().equals(sysLoginForm.getPassword())&&sysUser.getUsername().equals(sysLoginForm.getUsername())){
            token=sysUserTokenService.createToken(sysUser);
        }else {
            throw new ResponseException("用户名或密码错误，请重新输入");
        }
//        System.out.println(request.getHeader("token"));
        return ResponseMessage.success(token);
    }
//@GetMapping("/login")
//public ResponseMessage login() {
////        sysUserService.;
//    System.out.println("调用成功");
//    return ResponseMessage.success(true);
//}
}
