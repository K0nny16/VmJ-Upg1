package Model;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Database {
    private static Dotenv dotenv = Dotenv.configure().load();
    private static String pw = dotenv.get("PW");
    private static String user = dotenv.get("USERNAME");
    private static String DB = dotenv.get("DATABASE");
    private static String port = dotenv.get("PORT");
    private static String connection = "jdbc:mysql://localhost:"+port+"/"+DB+user+pw;
    public static void students(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connection);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *FROM Students");
            while(rs.next())
                System.out.println(rs.getString("fname")+" "+rs.getString("lname"));
            conn.close();
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
    public static void courses(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connection);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *FROM Courses");
            while(rs.next()){
                System.out.println(rs.getString("name")); //Resten
            }
        }catch(Exception ex){
            ex.getStackTrace();
        }
    }
    public static void attendance(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connection);
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
}
