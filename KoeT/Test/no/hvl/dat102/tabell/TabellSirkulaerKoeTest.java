package no.hvl.dat102.tabell;

public class TabellSirkulaerKoeTest extends KoeADTTest {
	
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}
}
