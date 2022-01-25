package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class KoeADTTest {
	
	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	
	@Test
	public void nyStabelErTom() {
		assertTrue(koe.erTom());
	}
	
	@Test
	public void testInnKoe(int element) {
		
	}
}
