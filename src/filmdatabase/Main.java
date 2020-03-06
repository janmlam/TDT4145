package filmdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			System.out.println("Velg usecase 1-5");
			int usecase = Integer.parseInt(input.readLine());
			if(usecase==0) {
				System.out.println("Break");
				break;
			}  
			if(usecase==1) {
				Film f = new Film();
				f.connect();
				/*
				System.out.println("Skriv tittel (string)");
				String tittel = input.readLine();
				System.out.println("Skriv lengde (int)");
				int lengde = Integer.parseInt(input.readLine());
				System.out.println("Skriv årstall (int)");
				int arstall = Integer.parseInt(input.readLine());
				System.out.println("Skriv utgivelsesdato (YYYY-MM-DD)");
				String dato = input.readLine();
				System.out.println("Skriv beskrivelse (string)");
				String beskrivelse = input.readLine();
				System.out.println("Skriv format (Video/Kino/Streaming) (string)");
				String format = input.readLine();
				*/
				String tittel = "Captain America";
				int lengde = 124;
				int arstall = 2011;
				String dato = "2011-07-22";
				String beskrivelse = "Steve rogers";
				String format = "kino";
				f.leggTilFilm(tittel, lengde, arstall, dato, beskrivelse, format);
				System.out.println("Lagt til"+tittel);
			}
			
		}
		input.close();
	}

}
