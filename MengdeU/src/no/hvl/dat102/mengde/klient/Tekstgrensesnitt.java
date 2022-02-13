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
		
		System.out.println("Hobbyer (Skriv zz for å stoppe): ");
		String hobbyerStr = myObj.nextLine();
		
		while (!hobbyerStr.equals("zz")) {
			hobbyer.leggTil(new Hobby(hobbyerStr));
			System.out.println("Hobbyer (Skriv zz for å stoppe): ");
			hobbyerStr = myObj.nextLine();
		}
		
		System.out.println("StatusIndeks: ");
		int statusindeks = Integer.parseInt(myObj.nextLine());
		
		myObj.close();
		
		return new Medlem(navn, hobbyer, statusindeks);
	}
	
	public static void skrivHobbyListe (Medlem medlem) {
		System.out.println("Alle hobbyene: " + medlem.getHobby().toString()); 
	}
	
	public static void skrivParListe (Datakontakt arkiv) {
		int indeksPar = 0;
		int antallPar = 0;
		Medlem[] medlemmer = arkiv.getMedlemmer();
		
		System.out.println("PARNAVN\t\t HOBBYER");
		//Kode ferdig herS
		for (int i = 0; i < arkiv.getAntall() ; i++) {
			if (medlemmer[i].getStatusIndeks() == medlemmer[indeksPar].getStatusIndeks()) {
				System.out.print(medlemmer[i].getNavn() + " og ");
				antallPar++;
				indeksPar++;
				
			}
		}
	}
}
