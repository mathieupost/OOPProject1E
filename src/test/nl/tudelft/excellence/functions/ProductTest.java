package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {

	@Test
	public void test() {
		PRODUCT test = new PRODUCT(1,2,3,4,5);
		assertEquals(test.execute(),120,0);
		PRODUCT test2 = new PRODUCT(1.56,7.486);
		assertEquals(test2.execute(),11.67816,0);
		PRODUCT test3 = new PRODUCT(-5,2);
		assertEquals(test3.execute(),-10,0);
		PRODUCT test4 = new PRODUCT(-2,-4);
		assertEquals(test4.execute(),8,0);
	}

}
