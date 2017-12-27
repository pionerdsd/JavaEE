package by.homework.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/sendForm")
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