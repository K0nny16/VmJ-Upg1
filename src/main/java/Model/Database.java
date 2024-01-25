package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Database {
    public static void content(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GritAcademy","root","");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT *FROM Students");
            while(rs.next())
                System.out.println(rs.getString("fname")+" "+rs.getString("lname"));
            conn.close();
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
}
