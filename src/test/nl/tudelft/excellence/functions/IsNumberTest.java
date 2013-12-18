package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsNumberTest {
	
	@Test
	public void testIsNotNumber() {
		ISNUMBER a = new ISNUMBER("A");
		assertEquals(a.execute(), false);
	}
	
	@Test
	public void testIsNumber(){
		ISNUMBER b = new ISNUMBER("8");
		assertEquals(b.execute(), true);
	}
	
	@Test
	public void testIsDecNumber(){
		ISNUMBER c = new ISNUMBER("8.3");
		assertEquals(c.execute(), true);
	}

}
