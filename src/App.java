import java.sql.*;

public class App {

    public static void viewAll(Statement st){
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"studentsList\" ORDER BY roll_no ASC ;");
            while(rs.next()){
                System.err.println("Roll.no: "+rs.getInt(1)+", Name: "+rs.getString(2)+".");
            }
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }

    public static void addRow(Statement st,int rollno, String name){
        try{
            int rs = st.executeUpdate("INSERT INTO \"studentsList\" Values ("+rollno+",'"+name+"');");
            System.err.println(rs+" rows effected");
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        String url="jdbc:postgresql://localhost:5432/mydb_backend";
        String uName="postgres";
        String pWord="Rohan@2003";
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,uName,pWord);
            Statement st= con.createStatement();
            viewAll(st);
            addRow(st, 6, "ramsi");
            st.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Connection Failed:"+e.getMessage());
        }
    }
}
