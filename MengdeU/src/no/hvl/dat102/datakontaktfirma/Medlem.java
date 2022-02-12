package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem (String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = statusIndeks;
	}
	
	public void setNavn (String navn) {
		this.navn = navn;
	}
	public String getNavn() {
		return navn;
	}
	
	public void setHobby(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	public MengdeADT<Hobby> getHobby() {
		return hobbyer;
	}
	
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		
		if (hobbyer.equals(medlem2.getHobby())) {
			passer = true;
		}
		return passer;
	}
	
	public void tilSkjerm() {
		System.out.println("Medlem: " + navn);
		System.out.println("Hobbyer: " + hobbyer);
		System.out.println("Statusindeks: " + statusIndeks);
	}
}
