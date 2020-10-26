package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		boolean skrivd=false;
		PrintWriter skriver=null;
		try {
			String ut=samling.toString();
			skriver = new PrintWriter(mappe+filnavn);
			
			skriver.print(ut);
			
		}
		catch(FileNotFoundException e){
			System.out.println("feil: Filen kan ikke åpnes");
		}
		finally {
			if(skriver != null) {
				skriver.close();
				skrivd=true;
			}
			
		}
		return skrivd;

	}
}
