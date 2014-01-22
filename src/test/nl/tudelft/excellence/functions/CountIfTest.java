package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountIfTest {

	@Test
	public void test() {
		COUNTIF c = new COUNTIF("50", "=", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 1, 0);
		c = new COUNTIF("50", "!=", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 4, 0);
		c = new COUNTIF("50", "<", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 3, 0);
		c = new COUNTIF("50", ">", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 1, 0);
		c = new COUNTIF("50", "<=", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 4, 0);
		c = new COUNTIF("50", ">=", "50", "20", "80", "21.5", "20");
		assertEquals(c.execute(), 2, 0);
	}

}
