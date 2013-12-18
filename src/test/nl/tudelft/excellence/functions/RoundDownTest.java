package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundDownTest {

	@Test
	public void test() {
		ROUNDDOWN test = new ROUNDDOWN(2.12345678,2);
		ROUNDDOWN test2 = new ROUNDDOWN(2.12345678,3);
		ROUNDDOWN test3 = new ROUNDDOWN(2.12345678,4);
		ROUNDDOWN test4 = new ROUNDDOWN(2.12345678,10);
		assertEquals(test.execute(),2.12,0);
		assertEquals(test2.execute(),2.123,0);
		assertEquals(test3.execute(),2.1234,0);
		assertEquals(test4.execute(),2.12345678,0);
	}

}
