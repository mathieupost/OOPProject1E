package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqrtTest {

	@Test
	public void test() {
		SQRT test = new SQRT("-10");
		SQRT test2 = new SQRT("0");
		SQRT test3 = new SQRT("9999");
		assertEquals(test.execute(),Math.sqrt(-10),0);
		assertEquals(test2.execute(),Math.sqrt(0),0);
		assertEquals(test3.execute(),Math.sqrt(9999),0);
	}

}
