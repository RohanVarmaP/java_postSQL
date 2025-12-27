import java.sql.*;

public class App {

    public static void viewAll(Connection con){
        String query="SELECT * FROM public.\"studentsList\" ORDER BY roll_no ASC ;";
        try(Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(query);){
            while(rs.next()){
                System.err.println("Roll.no: "+rs.getInt(1)+", Name: "+rs.getString(2)+".");
            }
        }catch(SQLException e){
            System.out.println("Failed to Fetch: "+e.getMessage());
        }
    }

    public static void addRow(Connection con,int rollno, String name){
        String query="INSERT INTO \"studentsList\" Values (?,?);";
        try(PreparedStatement ps= con.prepareStatement(query);){
            ps.setInt(1, rollno);
            ps.setString(2, name);
            int rs = ps.executeUpdate();
            System.err.println(rs+" rows effected");
        }catch(SQLException e){
            System.out.println("Failed to Add Row: "+e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/mydb_backend";
        String uName="postgres";
        String pWord="Rohan@2003";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,uName,pWord);
            addRow(con, 7, "rajesh");
            viewAll(con);
            con.close();
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }
}
