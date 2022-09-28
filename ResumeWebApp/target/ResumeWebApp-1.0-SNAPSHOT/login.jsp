<%-- 
    Document   : login
    Created on : Sep 28, 2022, 6:38:29 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="assets/css/Adminlogin.css">
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body class="login_background">
        <form action="login" method="Post">
            <div class="col-4 container login_fix_">
                <center>
                    <h1>Login:</h1>
                </center>
                <div class="form-group">
                    <label>Email address </label>
                    <input   type="email" class="form-control"  placeholder="email@example.com" name="email">
                </div>
                <div class="form-group">
                    <label>Password </label>
                    <input type="password" class="form-control"  placeholder="Password" name="password">
                </div>
                <button type="submit" class="btn btn-primary" name="login" >Login</button>
            </div>
        </form>
    </body>
</html>
