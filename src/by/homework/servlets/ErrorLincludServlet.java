package by.homework.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/ErrorLincludServlet")
public class ErrorLincludServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("");
        out.print("<!DOCTYPE html>");
        out.print("<html><head>");
        out.print("<meta charset=\"UTF-8\">");
        out.print("<title>Insert title here</title>");
        out.print("</head><body>");
        out.print("<script type=\"text/javascript\">");
        out.print("alert('Error');");
        out.print("</script></body></html>");



    }

    public void destroy() {
        // RequestDispatcher dispForvard = req.getRequestDispatcher("/sendForm");
        //dispForvard.forward(req,resp);



    }
}
