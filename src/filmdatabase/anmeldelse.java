package filmdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class anmeldelse extends DBConn {
	public void leggTilAnmeldelse(String tittel, int BrukerID, double Rating, String Anmeldelse) {
		Statement state = null;
		Statement stateIn = null;
		int filmid = 0;
		try {
			state = conn.createStatement();
			String queryFetch = "SELECT filmid FROM filmdatabase.film WHERE tittel='"+tittel+"'";
			ResultSet rs = state.executeQuery(queryFetch);
			while(rs.next()) {
				filmid = rs.getInt("filmid");
			}
			stateIn = conn.createStatement();
			String sql = "INSERT INTO Filmvurdering " +
                  	 "VALUES('"+filmid+"', '"+BrukerID+"', '"+Rating+"','"+Anmeldelse+"')";
			stateIn.executeUpdate(sql);
			stateIn = conn.createStatement();
			
			System.out.println("Vellykket innsetting av Anmeldelse i Filmdatabase");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}