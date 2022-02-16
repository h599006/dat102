package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.dobbelkjedetordnetliste.DobbelNode;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		// Første node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>(maksVerdi);
		// Kjeding
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();
		while ((el.compareTo(aktuell.getElement()) > 0)) {
			aktuell = aktuell.getNeste();
		}
		// Legg inn foran aktuell
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;

	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		p = foerste.getNeste();
		
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} 

		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}
	
	public boolean fins(T el) {
		boolean finnes = false;
		DobbelNode<T> p = null;
		
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
				p = foerste.getNeste();

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} 
			if (el.compareTo(p.getElement()) == 0) {
				finnes = true;
			}
		}
		
		return finnes;
	}
	
	
	public void visListe() {
		DobbelNode<T> p = foerste.getNeste();

		while (p != null && p != siste) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}
	}


}