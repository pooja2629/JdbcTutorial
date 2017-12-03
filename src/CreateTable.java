import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement stmt=con.createStatement();
//            stmt.execute("create table class(id int(10),name varchar(20),city varchar(20));");

            PreparedStatement ps=con.prepareCall("insert into class values(?,?,?,?);");

            ps.setInt(1,5);
            ps.setString(2,"sk");
            ps.setString(3,"satara");
            ps.setString(4,"mah");
            ps.execute();
            ResultSet rs=stmt.executeQuery("select * from class;");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

