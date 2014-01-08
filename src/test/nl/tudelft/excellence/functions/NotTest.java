package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class NotTest {

	@Test
	public void testNot() {
		NOT a = new NOT(true);
		assertEquals(a.execute(), false);
	}
	
	@Test
	public void testNot2(){
		NOT b = new NOT(false);
		assertEquals(b.execute(), true);
	}

}
