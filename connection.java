import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class connection {
    public static void main(String[] args) {
        try {


            String oracleDriver = "oracle.jdbc.driver.OracleDriver";
            String oracleURl = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "system";
            String password = "12345";


            Class.forName(oracleDriver);
            Connection con = DriverManager.getConnection(oracleURl, username, password);
            con.setAutoCommit(false);

            PreparedStatement insertStmt = con.prepareStatement("insert into employee values(6, 'Y','Pune')");
            int insertCount = insertStmt.executeUpdate();
            System.out.println(insertCount + " : Rows inserted...");

            if (insertCount > 0) {
                con.commit();
            } else {
                con.rollback();
            }
            con.close();

            } catch (Exception ex){
                ex.printStackTrace();
            }

        }

    }




