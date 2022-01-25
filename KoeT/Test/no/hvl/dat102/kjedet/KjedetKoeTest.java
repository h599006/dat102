package no.hvl.dat102.kjedet;

public class KjedetKoeTest extends KoeADTTest{
	
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}
}
