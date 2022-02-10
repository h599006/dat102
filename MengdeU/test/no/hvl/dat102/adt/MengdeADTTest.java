package no.hvl.dat102.adt;

import no.hvl.dat102.exception.*;
import no.hvl.dat102.mengde.adt.MengdeADT;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public abstract class MengdeADTTest {
	
	private MengdeADT<String> m1;
	private MengdeADT<String> m2;
	private MengdeADT<String> begge;
	
	protected abstract MengdeADT<String> reset();
	
	String o1 = "God";
	String o2 = "dag";
	String o3 = "Hans";
	String o4 = "Hansen";
	String o5 = "Hansaby";
	
	String o6 = "Bingo";
	String o7 = "Ole";
	String o8 = "Olsen";
	String o9 = "buss";
	String o10 = "rute";
	
	@BeforeEach
	public void setup() {
		m1 = reset();
		m2 = reset();
		begge = reset();
	}
	
	@Test
	public void unionFelles() {
		m1.leggTil(o1);
		m1.leggTil(o2);
		m1.leggTil(o3);
		m1.leggTil(o4);
		
		m2.leggTil(o1);
		m2.leggTil(o4);
		m2.leggTil(o6);
	
		
		begge = m1.union(m2);
		try {
			assertTrue(begge.inneholder(o1));
			assertTrue(begge.inneholder(o2));
			assertTrue(begge.inneholder(o3));
			assertTrue(begge.inneholder(o4));
			assertTrue(begge.inneholder(o6));
		} catch (EmptyCollectionException e){
			fail("UnionFelles feilet uventet " + e.getMessage());
		}
	}
	@Test
	public void unionIkkeFelles() {
		m1.leggTil(o1);
		m1.leggTil(o2);
		m1.leggTil(o3);
		m1.leggTil(o4);
		m1.leggTil(o5);
		
		m2.leggTil(o6);
		m2.leggTil(o7);
		m2.leggTil(o8);
		m2.leggTil(o9);
		m2.leggTil(o10);
		
		begge = m1.union(m2);
		try {
			assertTrue(begge.inneholder(o1));
			assertTrue(begge.inneholder(o2));
			assertTrue(begge.inneholder(o3));
			assertTrue(begge.inneholder(o4));
			assertTrue(begge.inneholder(o5));
			assertTrue(begge.inneholder(o6));
			assertTrue(begge.inneholder(o7));
			assertTrue(begge.inneholder(o8));
			assertTrue(begge.inneholder(o9));
			assertTrue(begge.inneholder(o10));
		} catch (EmptyCollectionException e){
			fail("UnionIkkeFelles feilet uventet " + e.getMessage());
		}
}
	
	@Test
	public void snittFelles() {
		m1.leggTil(o1);
		m1.leggTil(o2);
		m1.leggTil(o3);
		m1.leggTil(o4);
		m1.leggTil(o5);
		
		m2.leggTil(o1);
		m2.leggTil(o4);
		m2.leggTil(o6);
		m2.leggTil(o7);
		m2.leggTil(o8);
		
		begge = m1.snitt(m2);
		try {
			assertTrue(begge.inneholder(o1));
			assertTrue(begge.inneholder(o4));
		} catch (EmptyCollectionException e){
			fail("SnittFelles feilet uventet " + e.getMessage());
		}
		
	}
	
	@Test
	public void snittIkkeFelles() {
		m1.leggTil(o1);
		m1.leggTil(o2);
		m1.leggTil(o3);
		m1.leggTil(o4);
		m1.leggTil(o5);
		
		m2.leggTil(o6);
		m2.leggTil(o7);
		m2.leggTil(o8);
		m2.leggTil(o9);
		m2.leggTil(o10);
		
		begge = m1.snitt(m2);
		try {
			assertTrue(begge.erTom());
		} catch (EmptyCollectionException e){
			fail("SnittIkkeFelles feilet uventet " + e.getMessage());
		}
		
		
	}
	
	@Test
	public void diffFelles() {
		
	}
	
	@Test
	public void diffIkkeFelles() {
		
	}
}
