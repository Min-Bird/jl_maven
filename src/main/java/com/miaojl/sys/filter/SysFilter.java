package com.miaojl.sys.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author mjl
 * @date 2020/3/17
 * @description 系统过滤器
 */
@WebFilter("/*")
public class SysFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        filterChain.doFilter(request,response);
    }
}
