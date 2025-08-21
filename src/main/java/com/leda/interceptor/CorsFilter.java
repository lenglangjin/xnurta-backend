package com.leda.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤器方式解决跨域
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        // 允许所有来源进行跨域请求
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许发送 cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 允许的请求方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        // 允许的请求头字段，在这里允许token请求解决
        response.setHeader("Access-Control-Allow-Headers", "*");
        // 预检请求的有效期，单位为秒
        response.setHeader("Access-Control-Max-Age", "3600");
        // 如果是预检请求，直接返回 200 状态码
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(req, res);
    }
}
