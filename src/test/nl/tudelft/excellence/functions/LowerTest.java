package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowerTest {

	@Test
	public void testLower() {
		LOWER a = new LOWER("A");
		assertEquals(a.execute(), "a");
	}
	
	@Test
	public void testLower2(){
		LOWER b = new LOWER("AbCdEfG");
		assertEquals(b.execute(), "abcdefg");
	}

}
