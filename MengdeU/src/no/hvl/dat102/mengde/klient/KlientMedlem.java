package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.datakontaktfirma.Datakontakt;

public class KlientMedlem {
	
	public static void main(String[] args) {
		Datakontakt medlemmer = new Datakontakt(2);
		Meny meny = new Meny(medlemmer);
		meny.start(); 
	}

}
