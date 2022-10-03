package com.example.resumewebappall.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 *
 * @author ASUS
 */
public class ControllerUtil {
    public static void errorPage(HttpServletResponse resp, Exception ex){
        try {
            ex.printStackTrace();
            resp.sendRedirect("error?msg=" + ex.getMessage());
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}
