<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1> OK!</h1>

<%@ page import="by.homework.servlets.dao.DaoUsers" %>
<%@ page import="by.homework.servlets.entity.Users" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="by.homework.servlets.Validator" %>

<%
    RequestDispatcher dispForvard = request.getRequestDispatcher("registrationform");

        if(!request.getParameter("newLogin").isEmpty()&&!request.getParameter("newPassword").isEmpty()&&!request.getParameter("ConfirmPassword").isEmpty()&&!request.getParameter("email").isEmpty()&&!request.getParameter("birthdate").isEmpty()&&request.getParameter("check").length()>0) {
            String login = request.getParameter("newLogin");
            String password = request.getParameter("newPassword");
            String ConfirmPassword = request.getParameter("ConfirmPassword");
            String email = request.getParameter("email");
            String birthdate = request.getParameter("birthdate");
            int check = request.getParameter("check").length();
            String area = request.getParameter("area1");


        System.out.println(login + " " + password + " " + ConfirmPassword + " " + email + " " + birthdate + " " + check + " " + area);

        Validator validator = new Validator();
        if (validator.Registration(login, password, ConfirmPassword, email, birthdate, check)) {
            DaoUsers du = new DaoUsers();
            List<Users> listlogin = du.getAll("FROM Users WHERE login = '" + login + "'");
            List<Users> listemail = du.getAll("FROM Users WHERE login = '" + login + "'");
            if (listemail.isEmpty() && listlogin.isEmpty()) {


                du.insert(new Users(login, password, email));
                response.sendRedirect("index");


                System.out.println("Ok!");
            } else {

                response.setIntHeader("badlogin", 1);
                dispForvard.forward(request, response);
                // response.sendRedirect("registrationform");
            }
        }
        else {

            response.setIntHeader("badlogin", 2);
            dispForvard.forward(request, response);
        }
    }else {

            response.setIntHeader("badlogin", 2);
            dispForvard.forward(request, response);
        }

/*
    DaoUsers du = new DaoUsers();

    List<Users> listUesrs = du.getAll("FROM Users WHERE login = '" + login + "' AND password = '" + password + "'");
    //listUesrs.add(new Users("1","2","3"));
    //System.out.println(listUesrs.get(0).getLogin());
    if(!listUesrs.isEmpty()){
        RequestDispatcher dispForvard = request.getRequestDispatcher("authhead");
        dispForvard.forward(request,response);
    }else {

        RequestDispatcher dispForvard = request.getRequestDispatcher("index");
        response.setIntHeader("test",1);
        dispForvard.forward(request,response);
        //response.sendRedirect("index");


    }
*/

%>


</body>
</html>