package no.hvl.dat102.klient;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.kjedet.KjedetStabel;

public class Parentessjekker {
	
	 public boolean erVenstreparentes(char p) {
		 boolean finnnesParentes = false;
		 
		 if (p == '(') {
			 finnnesParentes = true; 
		 } else if (p == '[') {
			 finnnesParentes = true;
		 } else if (p == '{') {
			 finnnesParentes = true;
		 }
		 
		 return finnnesParentes;
	 }
	 
	 public boolean erHogreparentes(char p) {
		 boolean finnnesParentes = false;
		 
		 if (p == ')') {
			 finnnesParentes = true; 
		 } else if (p == ']') {
			 finnnesParentes = true;
		 } else if (p == '}') {
			 finnnesParentes = true;
		 }
		 
		 return finnnesParentes;
	 }
	 
	 public boolean erParentes(char p) {
		 return erHogreparentes(p) || erVenstreparentes(p);
	 }
	 
	 public boolean erPar(char venstre, char hogre) {
		 if (erVenstreparentes(venstre) && erHogreparentes(hogre)) {
			 if (venstre == '(' && hogre == ')') {
				 return true;
			 } else if (venstre == '[' && hogre == ']') {
				 return true;
			 } else if (venstre == '{' && hogre == '}') {
				 return true;
			 }
		 }
		return false; 
	 }

	 public boolean erBalansert(String s) {
		 boolean balansert = false;
		 char poppet;
		 StabelADT<Character> stabel = new KjedetStabel<Character>();
		 
		 for (int i = 0; i < s.length(); i++) {
			 if(erParentes(s.charAt(i))) {
				 if (erVenstreparentes(s.charAt(i))) {
					 stabel.push(s.charAt(i));
				 }
				 if (erHogreparentes(s.charAt(i))) {
					 if (stabel.erTom()) {
						 return false;
					 } else {
						 poppet = stabel.pop();
						 if (erPar(poppet, s.charAt(i))) {
							 balansert = true;
						 } else {
							 balansert = false;
						 }
					 }
				 }
			 }
		 }
		 if (!stabel.erTom()) {
			 balansert = false;
		 }
		 
		 return balansert;
	 } 
}
