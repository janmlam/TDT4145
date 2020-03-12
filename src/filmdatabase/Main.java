package filmdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			System.out.println("");
			System.out.println("####################################################################");
			System.out.println("Velg usecase ved å skrive et tall fra 1-5. Avslutt med å skrive 0");
			System.out.println("1: Finne navnet på alle rollene en gitt skuespiller har.");
			System.out.println("2: Finne hvilke filmer som en gitt skuespiller opptrer i.");
			System.out.println("3: Finne hvilke filmselskap som lager flest filmer inne hver sjanger (grøssere, familie,\r\n" + 
					"o.l.).");
			System.out.println("4: Sette inn en ny film med regissør, manusforfattere, skuespillere og det som hører med.");
			System.out.println("5: Sette inn ny anmeldelse av en episode av en serie.");
			System.out.println("####################################################################");
			int usecase = Integer.parseInt(input.readLine());
			if(usecase==0) {
				System.out.println("Break");
				break;
			}
			if(usecase==1) {
				Rolle r = new Rolle();
				r.connect();
				System.out.println("Skriv navnet for skuespiller");
				String rolle = input.readLine();
				r.finnRolle(rolle);
			}
			if(usecase==2) {
				finnFilm ff = new finnFilm();
				ff.connect();
				System.out.println("Skriv navnet for skuespiller");
				String skuespiller = input.readLine();
				ff.finneFilm(skuespiller);
			}
			if(usecase==3) {
				finnSelskap fs = new finnSelskap();
				fs.connect();
				fs.finneSelskap();
			}
			if(usecase==4) {
				leggeTilAlt ltl = new leggeTilAlt();
				ltl.connect();
				System.out.println("Du legger først en film i databasen. Skuespiller, reggisør, og manusforfatter blir knyttet til filmen du la inn.");
				System.out.println("Skriv inn tittel for film");
				String tittel = input.readLine();
				System.out.println("Skriv inn lengde for film");
				int lengde = Integer.parseInt(input.readLine());
				System.out.println("Skriv inn årstall for film");
				int arstall = Integer.parseInt(input.readLine());
				System.out.println("Skriv inn dato (YYYY-MM-DD) for film");
				String dato = input.readLine();
				System.out.println("Skriv inn beskrivelse for film");
				String beskrivelse = input.readLine();
				System.out.println("Skriv inn plattform for film");
				String plattform = input.readLine();
				ltl.leggTilFilm(tittel, lengde, arstall, dato, beskrivelse, plattform);
				
				System.out.println("Skriv inn navn for skuespiller");
				String skuespillerNavn = input.readLine();
				System.out.println("Skriv inn rollen for skuespiller");
				String skuespillerRolle = input.readLine();
				System.out.println("Skriv inn fødselsdato (YYYY-MM-DD) for skuespiller");
				String skuespillerDato = input.readLine();
				System.out.println("Skriv inn land for skuespiller");
				String skuespillerLand = input.readLine();
				ltl.leggTilSkuespiller(skuespillerNavn, skuespillerRolle, "Skuespiller", skuespillerDato,skuespillerLand);
				
				System.out.println("Skriv inn navn for regissør");
				String reggNavn = input.readLine();
				System.out.println("Skriv inn fødselsdato (YYYY-MM-DD) for regissør");
				String reggDato = input.readLine();
				System.out.println("Skriv inn land for regissør");
				String reggLand = input.readLine();
				ltl.leggTilRegg(reggNavn, "Regissør", reggDato, reggLand);
				
				System.out.println("Skriv inn navn for manusforfatter");
				String manusNavn = input.readLine();
				System.out.println("Skriv inn fødselsdato (YYYY-MM-DD) for manusforfatter");
				String manusDato = input.readLine();
				System.out.println("Skriv inn land for manusforfatter");
				String manusLand = input.readLine();
				ltl.leggTilManus(manusNavn, "Manusforfatter", manusDato, manusLand);
				
				ltl.knytteAlt();
			}
			if(usecase==5) {
				anmeldelse pr = new anmeldelse();
				pr.connect();
				
				System.out.println("Skriv inn tittel til film du vil anmelde ");
				String tittel = input.readLine();
				
				System.out.println("Skriv inn din BrukerID ");
				int BrukerID = Integer.parseInt(input.readLine());
				
				System.out.println("Skriv inn rating av film fra 1-10 ");
				double Rating = Double.parseDouble(input.readLine());
				
				System.out.println("Skriv inn din anmeldelse av filmen ");
				String Anmeldelse = input.readLine();
				
				pr.leggTilAnmeldelse(tittel, BrukerID, Rating, Anmeldelse);
				
			}
		}
		input.close();
	}
}
