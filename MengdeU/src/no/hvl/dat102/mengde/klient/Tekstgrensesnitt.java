package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

import java.util.Scanner;

import no.hvl.dat102.datakontaktfirma.*;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
	
	private static MengdeADT<Hobby> hobbyer = new KjedetMengde<>();
	
	public static Medlem lesMedlem() {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Navn: ");
		String navn = myObj.nextLine();
		
		String hobbyerStr;
		do {
			System.out.println("Hobby (Skriv zz for å stoppe): ");
			hobbyerStr = myObj.nextLine();
			hobbyer.leggTil(new Hobby(hobbyerStr));
		}
		while (!hobbyerStr.equals("zz"));
		
		System.out.println("StatusIndeks: ");
		int statusindeks = Integer.parseInt(myObj.nextLine());
		
		myObj.close();
		
		//hobbyer.leggTil(new Hobby(hobbyerStr));
		
		
		return new Medlem(navn, hobbyer, statusindeks);
	}
	
	public static void skrivHobbyListe (Medlem medlem) {
		System.out.println("Alle hobbyene: " + medlem.getHobby().toString()); 
	}
	
	public static void skrivParListe (Datakontakt arkiv) {
		int indeksPar = 0;
		int antallPar = 0;
		
		System.out.println("PARNAVN\t HOBBYER");
		
		for (int i = 0; i < arkiv.getAntall() ; i++) {
			//if (arkiv.) {
				//System.out.println(arkiv."\t HOBBYER");
				antallPar++;
			//}
			indeksPar++;
		}
	}
}
