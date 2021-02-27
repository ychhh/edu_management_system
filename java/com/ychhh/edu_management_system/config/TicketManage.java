package com.ychhh.edu_management_system.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TicketManage {
    public static Map<String, String> map = new HashMap();
    public static Map<String, Map<String, String>> clientCookieMap = new HashMap();

    public static String createTicket(String account)
    {
        String ticket = productTicket();
        while (map.containsKey(ticket)) {
            ticket = productTicket();
        }
        map.put(ticket, account);
        clientCookieMap.put(ticket, new HashMap());
        return ticket;
    }

    public static void destoryTicket(String ticket)
    {
        map.remove(ticket);
        clientCookieMap.remove(ticket);
    }

    public static String getAccount(String ticket)
    {
        return (String)map.get(ticket);
    }

    public static void addClientCookie(String ticket, String appCode, String cookieStr)
    {
        ((Map)clientCookieMap.get(ticket)).put(appCode, cookieStr);
    }

    public static Map<String, String> getClientCookie(String ticket)
    {
        return (Map)clientCookieMap.get(ticket);
    }

    private static String productTicket()
    {
        Random r = new Random(new Date().getTime());
        String tt = "";
        for (int i = 0; i < 10; i++)
        {
            int g = r.nextInt(62);
            if (g < 10) {
                tt = tt + g;
            } else if (g < 36) {
                tt = tt + (char)(g + 55);
            } else {
                tt = tt + (char)(g + 61);
            }
        }
        return tt;
    }
}
