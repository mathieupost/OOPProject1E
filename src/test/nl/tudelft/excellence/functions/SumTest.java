package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumTest {

	@Test
	public void test() {
		SUM test = new SUM("1","2","3","4","5");
		SUM test2 = new SUM("6","-7");
		SUM test3 = new SUM("-2","-4");
		assertEquals(test.execute(),15,0);
		assertEquals(test2.execute(),-1,0);
		assertEquals(test3.execute(),-6,0);
	}

}
