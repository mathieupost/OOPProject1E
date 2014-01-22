package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModTest {

	@Test
	public void testMod() {
		MOD a = new MOD("19.0", "6.0");
		assertEquals(a.execute(), 1,0);
	}

}
