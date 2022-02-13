package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.datakontaktfirma.Datakontakt;
import no.hvl.dat102.datakontaktfirma.Hobby;
import no.hvl.dat102.datakontaktfirma.Medlem;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.klient.Tekstgrensesnitt;

public class Meny {
	private Tekstgrensesnitt tekstgr;  
	private Datakontakt datakontakt;  
	  
	 public Meny(Datakontakt datakontakt){ 
		 tekstgr = new Tekstgrensesnitt();  
		 this.datakontakt = datakontakt; 
	 } 
	  
	 public void start(){ 
		 
		 MengdeADT<Hobby> hobbyer = new KjedetMengde<>();
		 hobbyer.leggTil(new Hobby("Sjakk"));
		 Medlem m1 = new Medlem ("Christine", hobbyer, -1);
		 datakontakt.leggTilMedlem(m1);
		 m1.tilSkjerm();
		 System.out.println("---------------");
		 
		 
		 Medlem m2 = tekstgr.lesMedlem();
		 datakontakt.leggTilMedlem(m2);
		 tekstgr.skrivHobbyListe(m2);
		 System.out.println("---------------");
		 
		
		 datakontakt.finnPartnerFor(m2.getNavn());
		 m1.tilSkjerm();
		 m2.tilSkjerm();
		 
		 System.out.println("---------------");
		 tekstgr.skrivParListe(datakontakt);
		 
		 //Fullføre bruk av alle metodene fra Datakontakt og Teksgrensesnitt
	 } 
}
