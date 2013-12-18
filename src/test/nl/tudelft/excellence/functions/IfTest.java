package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class IfTest {

	@Test
	public void testIfEqualFalse() {
		IF i = new IF("8 =7", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfEqualTrue() {
		IF i = new IF("8 = 8", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerTrue() {
		IF i = new IF("8 < 10", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerFalse() {
		IF i = new IF("8 < 5", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfBiggerFalse() {
		IF i = new IF("8 > 8", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfBiggerTrue() {
		IF j = new IF("8 > 7", "ja", "nee");
		assertEquals(j.execute(), "ja");
	}
	
	@Test
	public void testIfBiggerEqualTrue() {
		IF i = new IF("8 >= 8", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfBiggerEqualFalse() {
		IF i = new IF("8 >= 5", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfNotEqualsFalse() {
		IF i = new IF("8!= 8", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfNotEqualsTrue() {
		IF i = new IF("8 != 5", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}

}
