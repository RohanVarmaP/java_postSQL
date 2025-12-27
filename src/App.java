import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/mydb_backend";
        String uName="postgresql";
        String pWord="Rohan@2003";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,uName,pWord);
            if(con!=null){
                System.err.println("Connected");
            }
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }
}
