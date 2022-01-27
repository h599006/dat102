package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import no.hvl.dat102.exceptions.*;

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
	public void testInnKoeUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
			assertEquals(e4, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utkoe feilet uventet " + e.getMessage());
		}
	}
	@Test
	public void innKoeReturnForste() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		try {
			assertEquals(e0, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("return forste feilet uventet " + e.getMessage());
		}
	}
	
	@Test
	public void innKoeUtkoeTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("inn eller ut feilet uventet " + e.getMessage());
		}
	}
	
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		assertFalse(koe.erTom());
	}
}
