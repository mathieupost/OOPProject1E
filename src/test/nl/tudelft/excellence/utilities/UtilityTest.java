package nl.tudelft.excellence.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {

	@Test
	public void testIsNumber() {
		assertTrue(Utility.isNumber("1"));
		assertTrue(Utility.isNumber("1.0001"));
		
		assertFalse(Utility.isNumber("1,001"));
		assertFalse(Utility.isNumber("4bcd3fg"));
		assertFalse(Utility.isNumber("abcdefg"));
	}

}
