package Servlets;
import Model.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
@WebServlet(urlPatterns = "/Students")
public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Student List</title></head>");
        out.println("<body>");
        out.println("<h2> Student List </h2>");
        out.println("<ul>");
        ArrayList<String> students = Database.students();
        for(String studentInfo : students){
            out.println("<p>"+studentInfo+"</p>");
            out.println("<hr>");
        }
        out.println("</ul>");
        out.println("<br>");
        out.println("<a href= http://localhost:9090/Attendance> Attendance</a>");
        out.println("<a href= http://localhost:9090/Courses> Courses</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
