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

    Cookie cooklog = new Cookie("login", login);
    Cookie cookpass = new Cookie("password", password);
    Cookie[] cookies = request.getCookies();

    String userlogin = null;
    String userpassword = null;
    for(Cookie cookie : cookies){
        if("login".equals(cookie.getName())){
            userlogin = cookie.getValue();
        }
        if("password".equals(cookie.getName())){
            userpassword = cookie.getValue();
        }


        System.out.println(cookie.getName() + " " + cookie.getValue());
    }

 /*   Cookie[] cookies = request.getCookies();

    String userId = null;
    for(Cookie cookie : cookies){
        if("uid".equals(cookie.getName())){
            userId = cookie.getValue();
        }
    }*/

if(userlogin==null&&userpassword==null) {
    List<Users> listUesrs = du.getAll("FROM Users WHERE login = '" + login + "' AND password = '" + password + "'");
    //listUesrs.add(new Users("1","2","3"));
    //System.out.println(listUesrs.get(0).getLogin());
    if (!listUesrs.isEmpty()) {
        RequestDispatcher dispForvard = request.getRequestDispatcher("authhead");
        response.addCookie(cooklog);
        response.addCookie(cookpass);
        dispForvard.forward(request, response);
        System.out.println(listUesrs);


    } else {

        RequestDispatcher dispForvard = request.getRequestDispatcher("index");
        response.setIntHeader("loginfail", 1);
        dispForvard.forward(request, response);
        //response.sendRedirect("index");


    }
} else {
    List<Users> listUesrs = du.getAll("FROM Users WHERE login = '" + userlogin + "' AND password = '" + userpassword + "'");
    System.out.println(listUesrs);
    if (!listUesrs.isEmpty()) {
        RequestDispatcher dispForvard = request.getRequestDispatcher("authhead");
        response.addCookie(cooklog);
        response.addCookie(cookpass);
        dispForvard.forward(request, response);
        System.out.println(listUesrs);


}


%>


</body>
</html>
