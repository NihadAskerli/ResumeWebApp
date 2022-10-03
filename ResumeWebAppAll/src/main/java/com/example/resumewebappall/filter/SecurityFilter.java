package com.example.resumewebappall.filter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName="JSPFileFilter",urlPatterns = {"*"})
public  class SecurityFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  {

        try{
            HttpServletResponse res=(HttpServletResponse) response;
            HttpServletRequest req=(HttpServletRequest) request;
           if(!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedInUSer")==null) {
               res.sendRedirect("login");
           }else{
               try {
                   chain.doFilter(request,response);
               } catch (ServletException e) {
                   throw new RuntimeException(e);
               }
           }
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
