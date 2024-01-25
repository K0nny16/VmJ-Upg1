package Servlets;
import Model.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/Courses")
public class CoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Courses List</title></head>");
        out.println("<body>");
        out.println("<h2> Courses List </h2>");
        out.println("<ul>");
        ArrayList<String> courses = Database.courses();
        for(String coursesInfo : courses){
            out.println("<p>"+coursesInfo+"</p>");
            out.println("<hr>");
        }
        out.println("</ul>");
        out.println("<br>");
        out.println("<a href= http://localhost:9090/Students> Students</a>");
        out.println("<a href= http://localhost:9090/Attendance> Attendance</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
