package nl.tudelft.excellence.utilities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilityTest {

	@Test
	public void testIsNumber() {
		assertTrue(Utility.isNumber("1"));
		assertTrue(Utility.isNumber("1.0001"));
		
		assertFalse(Utility.isNumber("1,001"));
		assertFalse(Utility.isNumber("4bcd3fg"));
		assertFalse(Utility.isNumber("abcdefg"));
	}

	@Test
	public void testIsBoolean() {
		assertTrue(Utility.isBoolean("false"));
		assertTrue(Utility.isBoolean("true"));
		assertTrue(Utility.isBoolean("FaLsE"));

		assertFalse(Utility.isBoolean("5>4"));
		assertFalse(Utility.isBoolean("Nope, not a boolean"));
		assertFalse(Utility.isBoolean("Is this a boolean? False"));
	}

	@Test
	public void testGetOS(){
		String tmp = System.getProperty("os.name"); //Backup current os.name
		//Force os.name to resemble various OS's to make this test Platform Independent
		System.setProperty("os.name", "Windows 8");
		assertEquals(Utility.getOS(), "WIN");

		System.setProperty("os.name", "MAC OS X");
		assertEquals(Utility.getOS(), "MAC");

		System.setProperty("os.name", tmp); //Restore os.name
	}

	@Test
	public void testEscapeXML() {
		assertEquals(Utility.escapeXML("< > & \' \""), "&lt; &gt; &amp; &apos; &quot;");
	}
}
