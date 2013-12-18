package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsLogicalTest {

	@Test
	public void test() {
		COUNT c = new COUNT("aasdf", "3", "4", "8aad");
		assertEquals(c.execute(), 2, 0);
	}

}
