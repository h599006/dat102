package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.listeklient.Person;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class Main {

	public static void main(String[] args) {
		OrdnetListeADT<Person> kjedetListe = new KjedetOrdnetListe<>();
		OrdnetListeADT<Person> tabellListe = new TabellOrdnetListe<>();
		
		Scanner in = new Scanner(System.in);
		String fornavn, etternavn, svar;
		int foedselsaar;
		Person person;

		do {
			System.out.println("Oppgi fornavn?:");
			fornavn = in.nextLine();
			
			System.out.println("Oppgi etternavn?:");
			etternavn = in.nextLine();
			
			System.out.println("Oppgi fødselsår?:");
			foedselsaar = Integer.parseInt(in.nextLine());
			
			person = new Person(fornavn, etternavn, foedselsaar);
			
			kjedetListe.leggTil(person);
			tabellListe.leggTil(person);

			System.out.print("Oppgi flere navn [J/N]?:");
			svar = in.nextLine();

		} while (svar.equals("j") || svar.equals("J"));
		
		Person foerste;
		
		System.out.println("KJEDET LISTE:");
		while (!kjedetListe.erTom()) {
			foerste = kjedetListe.fjernFoerste();
			System.out.println(foerste);
		}
		
		System.out.println("\nTABELL LISTE:");
		while (!tabellListe.erTom()) {
			foerste = tabellListe.fjernFoerste();
			System.out.println(foerste);
		} 

	}

}
