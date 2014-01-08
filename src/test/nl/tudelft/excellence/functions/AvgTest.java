package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class AvgTest {

	@Test
	public void testAvgInt() {
		AVG a = new AVG("1","2","3","4");
		assertEquals(a.execute(), 2.5, 0);
	}
	
	@Test
	public void testAvgDouble() {
		AVG b = new AVG("1.2456", "6.23456", "4874.893");
		assertEquals(b.execute(), 1627.45772, 0);
	}

}
