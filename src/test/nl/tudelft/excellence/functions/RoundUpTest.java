package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundUpTest {

	@Test
	public void test() {
		ROUNDUP test = new ROUNDUP(2.12345678,2);
		ROUNDUP test2 = new ROUNDUP(2.12345678,3);
		ROUNDUP test3 = new ROUNDUP(2.12345678,4);
		ROUNDUP test4 = new ROUNDUP(2.12345678,10);
		assertEquals(test.execute(),2.13,0);
		assertEquals(test2.execute(),2.124,0);
		assertEquals(test3.execute(),2.1235,0);
		assertEquals(test4.execute(),2.12345678,0);
	}

}
