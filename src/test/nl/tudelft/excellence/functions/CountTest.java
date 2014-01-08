package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountTest {

	@Test
	public void test() {
		COUNT c = new COUNT("asdf", "435", "s45");
		assertEquals(c.execute(), 1,0);
	}

}
