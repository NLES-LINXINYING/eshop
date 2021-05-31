package com.example.eshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserFilter.java
 * @Description TODO
 * @createTime 2021-05-27 20:16:00
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("--------------------------userFilter.doFilter()------------------------");

        // 判断当前session是否有用户信息
        if (request.getSession().getAttribute("user") == null) {
            // 保存当前用户想去的url
            String goURL = request.getServletPath(); // 获得用户想要去往的地址
            String params = request.getQueryString(); // 获得地址中携带的参数
            System.out.println(goURL + "," + params);

            if (params != null) {
                goURL = goURL + "?" + params; // 拼接请求地址和参数
            }
            System.out.println(goURL);

            // 把拼接好的url和参数存入session
            request.getSession().setAttribute("goURL", goURL);

            // 非法请求，跳转到登录页面
            request.getSession().setAttribute("error", "非法请求，请登录！");
            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/ulogin.jsp");
        } else {
            // 如果有下一个过滤器则跳转，否则直接到目标页面
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
