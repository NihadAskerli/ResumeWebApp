/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resumewebapp.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;




/**
 *
 * @author ASUS
 */
public class ControllerUtil {
    public static void errorPage(HttpServletResponse resp,Exception ex){
        try {
              ex.printStackTrace();
            resp.sendRedirect("error?msg=" + ex.getMessage());
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
    }
}
