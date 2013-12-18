package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsEvenTest {

	@Test
	public void isEvenTestFalse() {
		ISEVEN e = new ISEVEN(5.56);
		assertEquals(e.execute(), false);
	}
	
	@Test
	public void isEvenTestTrue() {
		ISEVEN e = new ISEVEN(6.34);
		assertEquals(e.execute(), true);
	}

}
