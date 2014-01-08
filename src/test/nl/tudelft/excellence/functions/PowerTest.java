package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerTest {

	@Test
	public void test() {
		POWER test = new POWER("2","3");
		assertEquals(test.execute(), 8, 0);
		POWER test2 = new POWER("2","-2");
		assertEquals(test2.execute(), 0.25, 0);
		POWER test3 = new POWER("40.16","2.6");
		assertEquals(test3.execute(), 14786.4402, 0.0001);
	}

}
