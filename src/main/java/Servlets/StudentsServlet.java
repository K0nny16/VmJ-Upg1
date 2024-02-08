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
        out.print("<nav>");
        out.println("<a href= http://localhost:9090/Attendance> Attendance</a>");
        out.println("<a href= http://localhost:9090/Courses> Courses</a>");
        out.print("</nav>");
        out.println("<h2> Students List </h2>");
        out.println("<table border=1>");
        out.println("<tr><th>Name</th><th>Town</th><th>Hobby</th></tr>");
        ArrayList<String> students = Database.students();
        for(String studentInfo : students){
            String[] fields = studentInfo.split(",");
            out.println("<tr><td>"+fields[0]+" "+fields[1]+"</td><td>"+fields[2]+"</td><td>"+fields[3]+"</td></tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
