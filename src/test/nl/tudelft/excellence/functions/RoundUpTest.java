package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundUpTest {

	@Test
	public void testRoundUp() {
		ROUNDUP test = new ROUNDUP("2.12345678",2);
		assertEquals(test.execute(), 2.13,0);
	}
	
	@Test
	public void testRoundUp2(){
		ROUNDUP test2 = new ROUNDUP("-8765432356.2458765", 6);
		assertEquals(test2.execute(), -8765432356.245877,0);
	}

}
