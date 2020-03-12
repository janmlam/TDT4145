package filmdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DBConn {
	Connection conn = null;	
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public void connect() throws IOException {
		String url = "jdbc:mysql://localhost:3306/filmdatabase";
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			System.out.println("Connection funker");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
