package com.ychhh.edu_management_system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.ychhh.edu_management_system.entity.AuthorizationUserEntity;
import com.ychhh.edu_management_system.utils.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 统一授权公用服务类
 *
 * @email yongde446@163.com
 * @author:yanyd
 * @date: 2020.03.04
 * @time: 10:06
 */
@Service
@ConfigurationProperties(prefix = "guarder")
public class SingleStandardService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final String SSO_ACCOUNT = "sso_account";

    public static final String SSO_TICKET = "sso_ticket";

    public static final Integer time_out_redis = 1;

    private String host;

    private String port;
    private String redirect_port;

    private String appCode;
    //当前项目的初始页
    private String indexUrl;

    private String receptionistIndex;


    @Autowired
    private RedisUtils<String> redisUtils;
    @Autowired
    private TicketService ticketService;

    /**
     * 获取重定向URL
     *
     * @param request
     * @param illegalTicket
     * @return
     */
    public String getRedirectUrl(HttpServletRequest request, String illegalTicket) {
        String host = this.host;
        String redirect_port = this.redirect_port;

        String loginUrl = "http://" + host + ":" + redirect_port + "/sso/sso/ticketCheck.do?illegalTicket=" + illegalTicket;
        return addParam(request, loginUrl);
    }




    /**
     * 参数处理
     *
     * @param request
     * @param ssoLoginUrl
     * @return
     */
    public String addParam(HttpServletRequest request, String ssoLoginUrl) {
        ssoLoginUrl = ssoLoginUrl + "&appCode=" + this.appCode;
        //系统编号 也可以增加一个系统跳转的拼装url参数
        String isLogin = this.getLoginIs(request);
        logger.debug("isLogin===" + isLogin);
        StringBuffer targetUrlsb = new StringBuffer();
        //返回到项目的初始页
        if ("1".equals(isLogin)) {
            targetUrlsb.append(this.receptionistIndex);
        } else {
            targetUrlsb.append(this.indexUrl);
        }
        Enumeration<String> pnames = request.getParameterNames();
        targetUrlsb.append("?");
        while (pnames.hasMoreElements()) {
            String paramName = (String) pnames.nextElement();
            String value = request.getParameter(paramName);
            targetUrlsb.append(paramName + "=" + value + "&");
        }

        try {
            String targetUrlstr = URLEncoder.encode(targetUrlsb.toString(), "utf-8");
            ssoLoginUrl = ssoLoginUrl + "&targetUrl=" + targetUrlstr;
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return ssoLoginUrl;
    }

    public String getLoginIs(HttpServletRequest request) {
        //从header中获取token
        String isLogin = request.getHeader("isLogin");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(isLogin)) {
            isLogin = request.getParameter("isLogin");
        }
        return isLogin;
    }

    /**
     * 获取cookies
     *
     * @param req
     * @return
     */
    public String getCookieStr(HttpServletRequest req) {
        Cookie[] cs = req.getCookies();
        if (cs == null) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            int cookies_length = cs.length;
            for (int i = 0; i < cookies_length; ++i) {
                Cookie c = cs[i];
                sb.append(c.getName()).append("=").append(c.getValue()).append("; ");
            }

            String str = sb.toString();
            if (str.endsWith("; ")) {
                str = str.substring(0, str.length() - 2);
            }

            return str;
        }
    }


    /**
     * 检索帐号 根据ticket和cookies
     *
     * @param cookieStr
     * @param ticket
     * @return
     */
    public String retrieveAccount(String cookieStr, String ticket) {
        //获取到 地址，端口 授权项目号
        String host = this.host;
        String port = this.redirect_port;
        String appCode = this.appCode;
        OutputStream os = null;
        try {
            if (StringUtils.isEmpty(ticket)) {
                return "";
            }

            //验证账号
            String apiUrl = "http://" + host + ":" + port + "/sso/retrieveAccount.do?sso_ticket=" + ticket;
            URL url = new URL(apiUrl);

            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setRequestMethod("POST");
            uc.setDoOutput(true);
            uc.connect();
            os = uc.getOutputStream();
            String param = "appCode=" + appCode + "&cookieStr=" + cookieStr;
            os.write(param.getBytes());
            os.flush();


            InputStream is = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.readLine();
        } catch (Exception ex) {
//            次数调用经常会出现异常，暂时忽略异常信息
//            logger.error("retrieveAccount -fail");

        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public String getTicket(HttpServletRequest req) {
        String ticket = req.getParameter(SSO_TICKET);
        //如果header中不存在 SSO_TICKET，则从参数中获取SSO_TICKET
        if (StringUtils.isBlank(ticket)) {
            ticket = req.getHeader(SSO_TICKET);
        }
        return ticket;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }


    public String getRedirect_port() {
        return redirect_port;
    }

    public void setRedirect_port(String redirect_port) {
        this.redirect_port = redirect_port;
    }

    public String getReceptionistIndex() {
        return receptionistIndex;
    }

    public void setReceptionistIndex(String receptionistIndex) {
        this.receptionistIndex = receptionistIndex;
    }
}
