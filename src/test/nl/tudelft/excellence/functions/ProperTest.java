package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProperTest {

	@Test
	public void test() {
		PROPER test = new PROPER("This is a test");
		PROPER test2 = new PROPER("THIS IS A TEST");
		PROPER test3 = new PROPER("tHiS iS a TeSt");
		assertEquals(test.execute(),"This Is A Test");
		assertEquals(test2.execute(),"This Is A Test");
		assertEquals(test3.execute(),"This Is A Test");
	}

}
