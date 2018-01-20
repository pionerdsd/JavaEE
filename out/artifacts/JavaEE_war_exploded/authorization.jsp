<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Autorization</title>
</head>
<body>

<%@ page import="by.homework.servlets.dao.DaoUsers"%>
<%@ page import="by.homework.servlets.entity.Users"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>

<%
    String login = request.getParameter("newLogin");
    String password = request.getParameter("newPassword");

    DaoUsers du = new DaoUsers();

    List<Users> listUesrs = du.getAll("FROM Users WHERE login = '" + login + "' AND password = '" + password + "'");
    //listUesrs.add(new Users("1","2","3"));
   //System.out.println(listUesrs.get(0).getLogin());
    if(!listUesrs.isEmpty()){
        RequestDispatcher dispForvard = request.getRequestDispatcher("authhead");
        dispForvard.forward(request,response);
    }else {

        RequestDispatcher dispForvard = request.getRequestDispatcher("index");
        response.setIntHeader("loginfail",1);
        dispForvard.forward(request,response);
        //response.sendRedirect("index");


    }


%>


</body>
</html>
