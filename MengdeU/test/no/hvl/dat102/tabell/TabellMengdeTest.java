package no.hvl.dat102.tabell;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;
import no.hvl.dat102.adt.MengdeADTTest;

public class TabellMengdeTest extends MengdeADTTest {
		
	@Override
	protected MengdeADT<String> reset() {
		return new TabellMengde<String>();
	}
}

