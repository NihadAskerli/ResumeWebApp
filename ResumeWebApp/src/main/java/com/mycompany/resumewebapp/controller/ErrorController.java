package com.mycompany.resumewebapp.controller;

import dao.inter.UserDaoInter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.Contextnew;









@WebServlet(name = "ErrorController", urlPatterns ={"/error"} )
public class ErrorController extends HttpServlet {
    private UserDaoInter userDao= Contextnew.intstanceUserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getRequestDispatcher("error.jsp").forward(request,response);

    }




}
