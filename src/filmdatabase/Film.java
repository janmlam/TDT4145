package filmdatabase;

import java.sql.SQLException;
import java.sql.Statement;

public class Film extends DBConn{
	public void leggTilFilm(String tittel, int lengde, int arstall, String dato, String beskrivelse, String format) {
		Statement state = null;
		try {
			String query = "INSERT INTO filmdatabase.film "
					+ "VALUES (DEFAULT,'"+tittel+"', '"+lengde+"', '"+arstall+"','"+dato+"','"+beskrivelse+"','" +format+"')"; 
			state = conn.createStatement();
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
