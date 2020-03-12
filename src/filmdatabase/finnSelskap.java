package filmdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class finnSelskap extends DBConn {
	public void finneSelskap() {
		Statement state = null;
		try {
			System.out.println("ASD");
			String query = "SELECT url, sjanger.navn, count(*) FROM filmdatabase.selskap " 
					+ "INNER JOIN filmdatabase.filmselskap ON selskap.selskapID = filmselskap.selskapID "  
					+ "INNER JOIN filmdatabase.film ON filmselskap.filmid = film.filmid " 
					+ "INNER JOIN filmdatabase.filmsjanger ON film.filmid=filmsjanger.filmid "  
					+ "INNER JOIN filmdatabase.sjanger ON filmsjanger.sjangerid = sjanger.sjangerID "  
					+ "GROUP BY sjanger.sjangerID";
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				System.out.println("Filmselskapet: " + rs.getString("url")
				+ " har laget flest filmer i " + rs.getString("sjanger.navn")
				+ " med " + rs.getString("count(*)") + " film(er).");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}