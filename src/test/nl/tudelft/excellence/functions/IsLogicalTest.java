package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsLogicalTest {

	@Test
	public void test() {
		ISLOGICAL i = new ISLOGICAL("7 < 5");
		assertEquals(i.execute(), true);
	}

}
