package no.hvl.dat102.mengde.klient;


import java.util.Scanner;

import no.hvl.dat102.datakontaktfirma.*;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class Tekstgrensesnitt {
	MengdeADT<Hobby> hobby;
	public static Medlem lesMedlem() {
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Navn: ");
		String navn = myObj.nextLine();
		
		System.out.println("Hobbyer: ");
		String hobbyer = myObj.nextLine();
		
		System.out.println("StatusIndeks: ");
		int statusindeks = Integer.parseInt(myObj.nextLine());
		//String navn = JOptionPane.showInputDialog("Navn: ");
		//String hobbyerStr = JOptionPane.showInputDialog("Hobbyer: ");
		//int statusindeks = Integer.parseInt(JOptionPane.showInputDialog("Statusindeks: "));
		
		//MengdeADT<Hobby> hobbyer = hobbyerStr;
		
		//return new Medlem(navn, hobbyer, statusindeks);
	}
}
