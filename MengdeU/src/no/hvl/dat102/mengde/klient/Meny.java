package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.datakontaktfirma.Datakontakt;
import no.hvl.dat102.datakontaktfirma.Medlem;
import no.hvl.dat102.mengde.klient.Tekstgrensesnitt;

public class Meny {
	private Tekstgrensesnitt tekstgr;  
	private Datakontakt datakontakt;  
	  
	 public Meny(Datakontakt datakontakt){ 
		 tekstgr = new Tekstgrensesnitt();  
		 this.datakontakt = datakontakt; 
	 } 
	  
	 public void start(){ 
		 Medlem m1 = tekstgr.lesMedlem();
		 m1.tilSkjerm();
	 } 
}
