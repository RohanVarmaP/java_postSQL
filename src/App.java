import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/mydb_backend";
        String uName="postgres";
        String pWord="Rohan@2003";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,uName,pWord);
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"studentsList\" ORDER BY roll_no ASC ;");
            while(rs.next()){
                System.err.println("Roll.no: "+rs.getInt(1)+", Name: "+rs.getString(2)+".");
            }
            st.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }
}
