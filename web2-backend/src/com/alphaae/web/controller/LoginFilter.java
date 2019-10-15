package com.alphaae.web.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    private static List<String> urls = new ArrayList<>();

    static {
        urls.add("/index.jsp");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //得到当前页面所在目录下全名称
        String urlPattern = req.getServletPath();
        //得到页面所在服务器的绝对路径
        String path = req.getRequestURI();

        for (String url : urls) {
            if (url.equals(urlPattern) || path.contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }

        String token = request.getParameter("token");

        //此处Token验证还没写故写True
        if (token == null && true) {
            res.sendError(401, "所请求的页面需要用户名和密码！" );
        } else {
            System.out.println("token: " + token);
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
