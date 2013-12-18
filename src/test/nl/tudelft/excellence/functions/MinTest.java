package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinTest {

	@Test
	public void testMin() {
		MIN a = new MIN(5.6, 9, 1, 1000, -6.7);
		assertEquals(a.execute(), -6.7,0);
	}

}
