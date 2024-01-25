package Servlets;
import Model.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
@WebServlet(urlPatterns = "/Attendance")
public class AttendanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Attendance List</title></head>");
        out.println("<body>");
        out.println("<h2> Attendance List </h2>");
        out.println("<ul>");
        ArrayList<String> attendance = Database.attendance();
        for(String attendanceInfo : attendance){
            out.println("<p>"+attendanceInfo+"</p>");
        }out.println("</ul>");
        out.println("<a href= http://localhost:9090/Students> Students</a>");
        out.println("<a href= http://localhost:9090/Courses> Students</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
