package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountATest {

	@Test
	public void testCountA() {
		COUNTA c = new COUNTA("abc", "", "x");
		assertEquals(c.execute(), 2, 0);
	}

}
