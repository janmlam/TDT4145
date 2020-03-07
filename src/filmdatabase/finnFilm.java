package filmdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class finnFilm extends DBConn {
	public void finneFilm(String skuespiller) {
		Statement state = null;
		try {
			String query = "SELECT tittel FROM filmdatabase.film "
					+ "INNER JOIN filmdatabase.tilknyttettil ON film.filmID = tilknyttettil.filmID "
					+ "INNER JOIN filmdatabase.filmperson ON tilknyttettil.filmpersonID = filmperson.filmpersonID "
					+ "WHERE filmperson.navn = '"+skuespiller+"'";
			state = conn.createStatement();
			ResultSet rs = state.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("tittel"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
