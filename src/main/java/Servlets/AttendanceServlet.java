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
        out.println("<head><title>Student List</title></head>");
        out.println("<style>");
        out.println("table { width: 70%; border-collapse: collapse; margin-bottom: 20px; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        out.println("</style>");
        out.println("<h2> Attendance List </h2>");
        out.println("<table border=1>");
        out.println("<tr><th>Name</th><th>Course</th></tr>");
        ArrayList<String> attendance = Database.attendance();
        for(String attendanceInfo : attendance ){
            String[] fields = attendanceInfo.split(",");
            out.println("<tr><td>"+fields[0]+" "+fields[1]+"</td><td>"+fields[2]+"</td></tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("<a href= http://localhost:9090/Courses> Courses</a>");
        out.println("<a href= http://localhost:9090/Students> Students</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
