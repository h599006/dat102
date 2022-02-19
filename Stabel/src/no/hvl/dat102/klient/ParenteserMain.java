package no.hvl.dat102.klient;

import no.hvl.dat102.klient.Parentessjekker;

public class ParenteserMain {

	public static void main(String[] args) {
		Parentessjekker sjekker = new Parentessjekker();
		
		//Skal få false:
		String s1 = "{ [ Hei } ]";
		String s2 = "( [ på ] ) }";
		String s3 = "{ ( [ deg ] )";
		
		//Skal få true:
		String s4 = "( [ Per ] )";
		String s5 = "{ ( [ Person ] ) }";
		
		
		System.out.println(sjekker.erBalansert(s1));
		System.out.println(sjekker.erBalansert(s2));
		System.out.println(sjekker.erBalansert(s3));
		System.out.println(sjekker.erBalansert(s4));
		System.out.println(sjekker.erBalansert(s5));

	}
}
 