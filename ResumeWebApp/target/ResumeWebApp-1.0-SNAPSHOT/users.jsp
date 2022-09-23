<%-- 
    Document   : user
    Created on : Sep 10, 2022, 3:35:01 PM
    Author     : ASUS
--%>
<%@page import="entity.User"%>
<%@page import="main.Contextnew"%>
<%@page import="dao.inter.UserDaoInter"%>
<%@ page import="java.util.List" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/user.css">
        <script src="https://kit.fontawesome.com/6a26f00cc0.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UserDaoInter userDao = Contextnew.intstanceUserDao();
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String nationalityStr = request.getParameter("nid");
            Integer nationalityId = null;
            if (nationalityStr != null && !nationalityStr.trim().isEmpty()) {
                nationalityId = Integer.parseInt(nationalityStr);
            }

            List<User> list = userDao.getAll(name, surname, nationalityId);
        %>
        <div class=" container mycontainer" >
            <div class="row">
                <div class="col-4" >
                    <form action="users.jsp" method="GET">
                        <div class="form-group">
                            <label>name:</label>
                            <input placeholder="Enter name" class="form-control" type="text" name="name" value=""/>
                        </div>
                        <div class="form-group">
                            <label>surname:</label>
                            <input  placeholder="Enter surname" class="form-control" type="text" name=surname value=""/>
                        </div>
                        <input class="btn btn-primary" type="submit" name="search" value="Search"/>

                    </form>
                </div>
            </div>
            <div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>name</th>
                            <th>surname</th>
                            <th>nationality</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (User u : list) {
                        %>
                        <tr>
                            <td><%=u.getName()%></td>
                            <td><%=u.getSurname()%></td>
                            <td><%=u.getNationality().getName() == null ? "N/A" : u.getNationality().getName()%></td>
                            <td style="width: 5px">
                                <form action="userdetail"method="POST">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="delete"/>
                                    <button  class="btn btn-danger"  type="submit" value="delete" >
                                        <i class="fas fa-trash-alt"></i>
                                    </button>

                                </form>

                            </td>
                            <td style="width: 5px">
                                <form action="userdetail"method="GET">
                                    <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                    <input type="hidden" name="action" value="update"/>
                                    <button class="btn btn-secondary" type="submit" value="update" >
                                        <i class="fas fa-pen-square"></i>
                                    </button>
                                </form>
                            </td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
