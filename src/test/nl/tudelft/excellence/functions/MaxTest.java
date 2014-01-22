package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxTest {

	@Test
	public void testMax() {
		MAX a = new MAX("8.0");
		assertEquals(a.execute(), 8,0);
	}
	
	@Test
	public void testMax2(){
		MAX b = new MAX("-2.8", "8", "6.3");
		assertEquals(b.execute(), 8,0);
	}
	
	

}
