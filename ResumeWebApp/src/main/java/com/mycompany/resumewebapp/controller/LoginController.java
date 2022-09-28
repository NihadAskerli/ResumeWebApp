package com.mycompany.resumewebapp.controller;

import com.mycompany.resumewebapp.util.ControllerUtil;
import dao.inter.UserDaoInter;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.Contextnew;


/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
  
private UserDaoInter userdao=Contextnew.intstanceUserDao();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        
            request.getRequestDispatcher("login.jsp").forward(request,response);
      
    }
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
      try{ String name= request.getParameter("email");
        String password=request.getParameter("password");
        User user=userdao.findByEmailAndPassword(name, password);
        if(user==null){
            throw new IllegalArgumentException("username and password incorrect!!!");
        }
        request.getSession().setAttribute("loggedInUser",user);
        response.sendRedirect("/users");
      }catch(Exception ex){
        
         ControllerUtil.errorPage(response, ex);
      }
      
    }

}
