package filmdatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			System.out.println("Velg usecase ved å skrive et tall fra 1-5. Avslutt med å skrive 0");
			System.out.println("1: Finne navnet på alle rollene en gitt skuespiller har.");
			System.out.println("2: Finne hvilke filmer som en gitt skuespiller opptrer i.");
			System.out.println("3: Finne hvilke filmselskap som lager flest filmer inne hver sjanger (grøssere, familie,\r\n" + 
					"o.l.).");
			System.out.println("4: Sette inn en ny film med regissør, manusforfattere, skuespillere og det som hører med.");
			System.out.println("5: Sette inn ny anmeldelse av en episode av en serie.");
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
		}
		input.close();
	}
}
