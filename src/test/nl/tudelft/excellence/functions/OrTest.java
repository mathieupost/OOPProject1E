package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrTest {

	@Test
	public void testOr() {
		OR a = new OR("true", "false");
		assertEquals(a.execute(), true);
	}
	
	@Test
	public void testOr2(){
		OR b = new OR("false", "false");
		assertEquals(b.execute(), false);
	}

}
