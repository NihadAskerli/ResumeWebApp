package com.example.resumewebappall.controller;

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
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private UserDaoInter userDao = Contextnew.intstanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            User user = userDao.getById(id);
            user.setName(name);
            user.setSurname(surname);
            userDao.updateUser(user);
        } else if (action.equals("delete")) {
            userDao.removeUser(id);
        }
        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String usedIdStr = request.getParameter("id");
            if (usedIdStr == null || usedIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(usedIdStr);
            UserDaoInter userDao = Contextnew.intstanceUserDao();
            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("owner", true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }
    }

}
