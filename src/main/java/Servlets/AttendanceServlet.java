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
@WebServlet(urlPatterns = "/Attendance")
public class AttendanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Attendance List</title>");
        out.println("<link rel=stylesheet type=text/css href=style.css>");
        out.println("</head>");
        out.println("<body>");
        out.println("<nav>");
        out.println("<a href=http://localhost:9090/Courses>Courses</a>");
        out.println("<a href=http://localhost:9090/Students>Students</a>");
        out.println("</nav>");
        out.println("<h2>Attendance List</h2>");
        out.println("<table class='table-container'>");
        out.println("<tr><th>Name</th><th>Course</th></tr>");
        ArrayList<String> attendance = Database.attendance();
        for(String attendanceInfo : attendance){
            String[] fields = attendanceInfo.split(",");
            out.println("<tr><td>"+fields[0]+" "+fields[1]+"</td><td>"+fields[2]+"</td></tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
