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
		 
		 MengdeADT<Hobby> hobbyer1 = new KjedetMengde<>();
		 hobbyer1.leggTil(new Hobby("Sjakk"));
		 Medlem m1 = new Medlem ("Christine", hobbyer1, -1);
		 datakontakt.leggTilMedlem(m1);
		 m1.tilSkjerm();
		 System.out.println("---------------");
		 
		 
		 Medlem m2 = tekstgr.lesMedlem();
		 datakontakt.leggTilMedlem(m2);
		 tekstgr.skrivHobbyListe(m2);
		 System.out.println("---------------");
		 
		 
		 datakontakt.finnPartnerFor(m2.getNavn());
		 m1.tilSkjerm();
		 System.out.println("---------------");
		 m2.tilSkjerm();
		 System.out.println("---------------");
		 
		 
		 MengdeADT<Hobby> hobbyer3 = new KjedetMengde<>();
		 hobbyer3.leggTil(new Hobby("Fotball"));
		 Medlem m3 = new Medlem ("Endre", hobbyer3, 3);
		 datakontakt.leggTilMedlem(m3);
		 m3.tilSkjerm();
		 System.out.println("---------------");
		 
		 
		 MengdeADT<Hobby> hobbyer4 = new KjedetMengde<>();
		 hobbyer4.leggTil(new Hobby("Fotball"));
		 Medlem m4 = new Medlem ("Emilie", hobbyer4, 2);
		 datakontakt.leggTilMedlem(m4);
		 m4.tilSkjerm();
		 System.out.println("---------------");
		 
		 
		 System.out.println("LISTE AV PAR: ");
		 tekstgr.skrivParListe(datakontakt);
		 datakontakt.tilbakestillStatusIndeks(m2.getNavn());
		 System.out.println("---------------");
		 
		 System.out.println("LISTE ETTER Å TILBAKESTILLE STATUS: ");
		 tekstgr.skrivParListe(datakontakt);
		 
	 } 
}
