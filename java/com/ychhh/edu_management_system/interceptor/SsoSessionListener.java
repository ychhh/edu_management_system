//package com.ychhh.edu_management_system.interceptor;
//
//import com.ychhh.edu_management_system.config.TicketManage;
//import com.ychhh.edu_management_system.service.SingleStandardService;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Map;
//
//public class SsoSessionListener  implements HttpSessionListener
//{
//
//    public void sessionCreated(HttpSessionEvent se) {}
//
//    public void sessionDestroyed(HttpSessionEvent se)
//    {
//        WebApplicationContext ac =
//                WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
//
//        String ticket = (String)se.getSession().getAttribute(SingleStandardService.SSO_TICKET);
//        int i = ((Integer)se.getSession().getAttribute("login_id")).intValue();
//        if (!StringUtils.isEmpty(ticket))
//        {
//            Map<String, String> map = TicketManage.getClientCookie(ticket);
//            logoutClient(map);
//            TicketManage.destoryTicket(ticket);
//            int id = i;
//        }
//    }
//
//    private void logoutClient(Map<String, String> map)
//    {
//        if (map == null) {
//            return;
//        }
//     }
//
//    private void executeLogout(String surl, String cookies)
//            throws Exception
//    {
//        URL url = new URL(surl);
//        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
//        uc.setRequestMethod("GET");
//        uc.setDoOutput(true);
//        uc.addRequestProperty("Cookie", cookies);
//        uc.connect();
//        uc.getInputStream();
//    }
//}
