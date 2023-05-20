import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver"); 
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMSIMULATORSYSTEM","root","aklovesdik06@S");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
