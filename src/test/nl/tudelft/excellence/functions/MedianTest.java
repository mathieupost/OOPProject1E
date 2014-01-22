package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianTest {

	@Test
	public void test() {
		MEDIAN test = new MEDIAN("5","2","8","3","1","2");
		assertEquals(test.execute(),2.5,0);
		MEDIAN test2 = new MEDIAN("-5","100","4");
		assertEquals(test2.execute(),4,0);
	}

}
