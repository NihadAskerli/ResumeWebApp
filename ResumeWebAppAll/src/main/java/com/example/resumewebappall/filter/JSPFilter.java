package com.example.resumewebappall.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(filterName="JSPFileFilter",urlPatterns = {"*.jsp"})
public  class JSPFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  {
        HttpServletResponse res=(HttpServletResponse) response;
        try{
            res.sendRedirect("error?msg=not found");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
