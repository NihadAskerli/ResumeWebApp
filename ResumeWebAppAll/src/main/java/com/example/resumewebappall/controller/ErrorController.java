package com.example.resumewebappall.controller;

import dao.inter.UserDaoInter;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Contextnew;









@WebServlet(name = "ErrorController", urlPatterns ={"/error"} )
public class ErrorController extends HttpServlet {
    private UserDaoInter userDao= Contextnew.intstanceUserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("error.jsp").forward(request,response);

    }




}
