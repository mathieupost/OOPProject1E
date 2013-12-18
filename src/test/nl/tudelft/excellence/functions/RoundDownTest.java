package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundDownTest {

	@Test
	public void testRoundDown() {
		ROUNDDOWN test = new ROUNDDOWN(2345456766345475.12345678,2);
		assertEquals(test.execute(), 2345456766345475.12,0);
	}
	
	@Test
	public void testRoundDown2(){
		ROUNDDOWN test2 = new ROUNDDOWN(-2345456766345475.12345678,9);
		assertEquals(test2.execute(), -2345456766345475.123456780,0);
	}

}
