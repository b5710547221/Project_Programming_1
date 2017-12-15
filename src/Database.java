import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Check();
	}

	public static Connection connect() throws SQLException {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
//			e1.printStackTrace();
//
//		}

		// System.out.println("Success! connection");
		return DriverManager.getConnection("jdbc:postgresql:postgres", "tbap", "ionay999");
	}

	public static void Check() {
		String SQL = "SELECT * FROM pg_tables"; //  WHERE tablename ILIKE 'mem%';";

		try (Connection conn = connect(); Statement stmt = conn.createStatement()) {

			ResultSet rs = stmt.executeQuery(SQL);
			System.out.println("" + rs.getFetchSize());
            while(rs.next()){
               System.out.println(rs.getString("tablename"));
            }
            
            //System.out.println("My Table");
            rs.close();
			conn.close();
		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return;
		}
	}

}
