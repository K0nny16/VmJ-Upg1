package Model;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Database {
    static Dotenv dotenv = Dotenv.load();
    public static String port = dotenv.get("Port");
    public static String user = dotenv.get("User");
    public static String db = dotenv.get("DB");
    public static String pw = dotenv.get("PW");
    private static final String connection = "jdbc:mysql://localhost:"+port +"/"+ db +"?user="+user+"&password="+pw;

    public static ArrayList<String> students(){
        ArrayList<String> student = new ArrayList<>();
        try{
            String studentInfo;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connection);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *FROM Students");
            while(rs.next()){
               studentInfo = rs.getString("fname")+","+rs.getString("lname")+","+rs.getString("town")+","+rs.getString("hobby");
               student.add(studentInfo);
            }
            conn.close();
        }catch (Exception ex){
            ex.getStackTrace();
            System.err.println("Exception: "+ex.getMessage());
        }
        return student;
    }
    public static ArrayList<String> courses(){
        ArrayList<String> courses = new ArrayList<>();
        try{
            String coursesInfo;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connection);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *FROM Courses");
            while(rs.next()){
                coursesInfo = rs.getString("name")+","+rs.getInt("YHP")+","+rs.getString("description")+","+rs.getString("lector");
                courses.add(coursesInfo);
            }
            conn.close();
        }catch(Exception ex){
            ex.getStackTrace();
            System.err.println("Exception: "+ex.getMessage());
        }
        return courses;
    }
    public static ArrayList<String> attendance(){
        ArrayList<String> attendance = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String attendanceInfo;
            Connection conn = DriverManager.getConnection(connection);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT students.fname, students.lname,courses.name FROM attendance JOIN students ON attendance.students_id = students.id JOIN courses ON attendance.courses_id = courses.id ORDER BY students.id ASC");
            while(rs.next()){
                attendanceInfo = rs.getString("fname")+","+rs.getString("lname")+","+rs.getString("name");
                attendance.add(attendanceInfo);
            }
            conn.close();
        }catch (Exception ex){
            ex.getStackTrace();
            System.err.println("Exception: "+ex.getMessage());
        }
        return attendance;
    }
}
