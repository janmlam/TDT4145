package filmdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	Connection conn = null;	
	public void connect() {
		String url = "jdbc:mysql://localhost:3306/filmdatabase";
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection funker");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
