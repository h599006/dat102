package no.hvl.dat102.datakontaktfirma;

public class Datakontakt {
	private Medlem[] medlemmer;
	private int antallMedlemmer;
	
	public Datakontakt(int lengde) {
		medlemmer = new Medlem[lengde];
		antallMedlemmer = 0;
	}
	
	public void leggTilMedlem (Medlem person) {
		if (!inneholder(person)) {
			if (antallMedlemmer == medlemmer.length) {
				utvidKapasitet();
			}
			medlemmer[antallMedlemmer] = person;
			antallMedlemmer++;
		}
	}
	
	public int finnMedlemsIndeks (String medlemsnavn) {
		int indeks = -1;
		for (int i = 0; i < antallMedlemmer; i++) {
			if (medlemmer[i].getNavn() == medlemsnavn) {
				indeks = i;
			}
		}
		return indeks;
	}
	
	public int finnPartnerFor (String medlemsnavn) {
		int medlemIndeks = finnMedlemsIndeks(medlemsnavn);
		int matchIndeks = -1;
		int teller = 0;
		
		boolean matchFunnet = false;
		
		while (teller < antallMedlemmer && !matchFunnet) { //F�r feil her pga passerTil()
			if (teller != medlemIndeks && medlemmer[teller].passerTil(medlemmer[medlemIndeks]) && medlemmer[teller].getStatusIndeks() == -1) {
				matchIndeks = teller;
				medlemmer[medlemIndeks].setStatusIndeks(matchIndeks);
				medlemmer[matchIndeks].setStatusIndeks(medlemIndeks);
				matchFunnet = true;
			}
			teller++;
		}
		
		return matchIndeks;
	}
	
	public void tilbakestillStatusIndeks (String medlemsnavn) {
		boolean brytet = false;
		int teller = 0;
		
		while (!brytet && teller < antallMedlemmer) {
			if (medlemmer[teller].getNavn() == medlemsnavn && medlemmer[teller].getStatusIndeks() != -1) {
				medlemmer[medlemmer[teller].getStatusIndeks()].setStatusIndeks(-1);
				medlemmer[teller].setStatusIndeks(-1);
				brytet = true;
			}
			teller++;
		}
	}
	
	private void utvidKapasitet() {
		Medlem[] hjelpetabell = (Medlem[]) (new Object[2 * medlemmer.length]);
		for (int i = 0; i < medlemmer.length; i++) {
			hjelpetabell[i] = medlemmer[i];
		}
		medlemmer = hjelpetabell;
	}
	
	public boolean inneholder(Medlem person) {
		boolean funnet = false;
		for (int i = 0; (i < antallMedlemmer) && (!funnet); i++) {
			if (medlemmer[i].equals(person)) {
				funnet = true;
			}
		}
		return (funnet);
	}
	
	public int getAntall() {
		return antallMedlemmer;
	}
	
	public Medlem[] getMedlemmer() {
		return medlemmer;
	}
}
