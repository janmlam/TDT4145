package filmdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Rolle extends DBConn {
	public String finnRolle(String rolle) {
		Statement state = null;
		try {
			String query = "SELECT rolle FROM filmdatabase.film "
					+ "INNER JOIN filmdatabase.tilknyttettil ON film.filmID = tilknyttettil.filmID "
					+ "INNER JOIN filmdatabase.filmperson ON tilknyttettil.filmpersonID = filmperson.filmpersonID "
					+ "WHERE filmperson.navn = '"+rolle+"'";
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("rolle"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rolle;
	}
}


