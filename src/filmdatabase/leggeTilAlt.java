package filmdatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class leggeTilAlt extends DBConn {
	int filmid = 0;
	int filmpersonskuespillerid = 0;
	int filmpersonreggid = 0;
	int filmpersonmanusid = 0;
	String skuespillerRolle = null;
	
	public void leggTilFilm(String tittel, int lengde, int arstall, String dato, String beskrivelse, String format) {
		try {
			String query = "INSERT INTO filmdatabase.film "
					+ "VALUES (DEFAULT,'"+tittel+"', '"+lengde+"', '"+arstall+"','"+dato+"','"+beskrivelse+"','" +format+"')";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
			    filmid = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void leggTilSkuespiller(String navn, String rolle, String jobb, String dato, String land) {
		try {
			skuespillerRolle = rolle;
			String query = "INSERT INTO filmdatabase.filmperson "
					+ "VALUES (DEFAULT,'"+navn+"', '"+jobb+"', '"+dato+"','"+land+"')";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				filmpersonskuespillerid = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void leggTilRegg(String navn, String jobb, String dato, String land) {
		try {
			String query = "INSERT INTO filmdatabase.filmperson "
					+ "VALUES (DEFAULT,'"+navn+"', '"+jobb+"', '"+dato+"','"+land+"')";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				filmpersonreggid = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void leggTilManus(String navn, String jobb, String dato, String land) {
		try {
			String query = "INSERT INTO filmdatabase.filmperson "
					+ "VALUES (DEFAULT,'"+navn+"', '"+jobb+"', '"+dato+"','"+land+"')";
			PreparedStatement pstmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				filmpersonmanusid = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void knytteAlt() {
		Statement state = null;
		try {
			String query = "INSERT INTO filmdatabase.tilknyttettil "
					+ "VALUES ('"+filmid+"','"+filmpersonskuespillerid+"','"+skuespillerRolle+"'),"
					+ "('"+filmid+"','"+filmpersonreggid+"', null),"
					+ "('"+filmid+"','"+filmpersonmanusid+"', null)";
			state = conn.createStatement();
			state.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Vellykket innsetting av film og tilhørende skuespiller, regissør, manusforfatter i Filmdatabase");
	}
	
}


