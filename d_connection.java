import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class d_connection {
    public static void main(String[] args) {
        try {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter City : ");
            String city = scan.next();

            String oracleDriver = "oracle.jdbc.driver.OracleDriver";
            String oracleURl = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "12345";
            String selectSql = "select * from employee";
            //String groupBySql = "select city, count(*) AS total FROM employee group by city;";
            String selectByCity = "select * from employee WHERE address = ?";
            Class.forName(oracleDriver);
            Connection con = DriverManager.getConnection(oracleURl,username,password);
            PreparedStatement stmt = con.prepareStatement(selectByCity);
            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("address"));
                //System.out.println(rs.getString("total"));
                System.out.println("--------------------------------");
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}