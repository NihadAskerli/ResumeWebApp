package com.example.resumewebappall.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.resumewebappall.util.ControllerUtil;
import dao.inter.UserDaoInter;
import entity.User;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.Contextnew;


/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private UserDaoInter userdao=Contextnew.intstanceUserDao();
private static BCrypt.Verifyer verifyer=BCrypt.verifyer();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        request.getRequestDispatcher("login.jsp").forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        try{ String email= request.getParameter("email");
            String password=request.getParameter("password");
            User user=userdao.findByEmail(email);

            if(user==null){
                throw new IllegalArgumentException("user does not exist!!");
            }
            BCrypt.Result rs=verifyer.verify(password.toCharArray(),user.getPassword().toCharArray());
            if(!rs.verified){
                throw new IllegalArgumentException("password is incorrect!!");
            }
                    request.getSession().setAttribute("loggedInUser",user);
            response.sendRedirect("users");
        }catch(Exception ex){

            ControllerUtil.errorPage(response, ex);
        }

    }

}
