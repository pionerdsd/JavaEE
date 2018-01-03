package by.homework.servlets;

import by.homework.servlets.DB.DB;
import by.homework.servlets.DB.DB_Builder;
import by.homework.servlets.dao.DaoUsers;
import by.homework.servlets.entity.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/sendForm")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

       /* Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            int i=0;
            for(Cookie cookie: cookies ){

                if(cookie.getName().equals("login")){
                    System.out.println(cookie.getName());

                }
                System.out.println(cookie.getName());


            }
        }*/



        Cookie cok = new Cookie("login", request.getParameter("newLogin"));
        response.addCookie(cok);



        if (request.getParameter("check") != null) {
            if ((new Authorization().Registration(request.getParameter("newLogin"), request.getParameter("newPassword"), request.getParameter("ConfirmPassword"), request.getParameter("email"), request.getParameter("birthdate"), request.getParameter("check").length()))) {

                //DB_Builder.deleteDB("jdbc:mysql://127.0.0.1/", "Shop", "root", "root");
                //DB_Builder.createDB("jdbc:mysql://127.0.0.1/", "Shop", "root", "root");
                DB db = new DB("jdbc:mysql://127.0.0.1/", "Shop", "root", "root");
                new DaoUsers(db).insertLP(new Users(request.getParameter("newLogin"), request.getParameter("newPassword"),request.getParameter("email")));
                System.out.println("insert done!");
                RequestDispatcher dispForvard = request.getRequestDispatcher("/MainPageServlet");
                dispForvard.forward(request,response);

           }else {

                response.sendRedirect("/index.html");
            }
       } else {

            RequestDispatcher dispInclude = request.getRequestDispatcher("/ErrorLincludServlet");
            dispInclude.forward(request, response);
          //  RequestDispatcher dispForvard = request.getRequestDispatcher("/sendForm");
           // dispForvard.forward(request,response);
            //response.sendRedirect("/index.html");




        }




//Authorization authorization= new Authorization(request.getParameter("newLogin"),request.getParameter("newPassword"),request.getParameter("ConfirmPassword"),request.getParameter("email"),request.getParameter("birthdate"));
//authorization.printVal();
//authorization.Registration(request.getParameter("newLogin"),request.getParameter("newPassword"),request.getParameter("ConfirmPassword"),request.getParameter("email"),request.getParameter("birthdate"));

      //  System.out.println(new Authorization().Registration(request.getParameter("newLogin"),request.getParameter("newPassword"),request.getParameter("ConfirmPassword"),request.getParameter("email"),request.getParameter("birthdate"),request.getParameter("check").length()));
/*
        out.print(new Date(System.currentTimeMillis()));
        out.print("<br>");

        out.print(new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())));

        out.print("<br>");*/

        Map<String, String[]> map = request.getParameterMap();
        for(Map.Entry<String, String[]> entry: map.entrySet()) {
            out.print(entry.getKey());
            for(String s : entry.getValue()) {
                out.print(s);
                out.print("<br>");
            }
        }

		/*String login = request.getParameter("newLogin");
        out.print(login);
        String birthdate = request.getParameter("birthdate");
        out.print(birthdate);*/
/*
		String [] checkMas = request.getParameterValues("check");
		for(String s: checkMas) {
			out.print(s);
			out.print("<br>");
		}

		*/

	/*	out.print("<!DOCTYPE html>");
		out.print("<html><head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Insert title here</title>");*/
        //out.print("Hello world! Привет мир!");
        //out.print("</head><body>");

    }



    @Override
    public void destroy() {
        System.out.println("destroy");
    }



}