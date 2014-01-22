package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignTest {

	@Test
	public void test() {
		SIGN test = new SIGN("-1234.567");
		SIGN test2 = new SIGN("0.0000000");
		SIGN test3 = new SIGN("123456.7");
		assertEquals(test.execute(),-1,0);
		assertEquals(test2.execute(),0,0);
		assertEquals(test3.execute(),1,0);
	}

}
