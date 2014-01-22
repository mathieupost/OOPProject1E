package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;
import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

import org.junit.Test;

public class IntTest {

	@Test
	public void intTestPos() {
		INT i = new INT("3.456787");
		assertEquals(i.execute(), 3, 0);
	}
	
	@Test
	public void intTestNeg() {
		INT i = new INT("-3.4532545");
		assertEquals(i.execute(), -3, 0);
	}
	
	@Test
	public void test(){
		try{
			new INT("");
			fail();
		} catch(IllegalFunctionArgumentsException ignore){}
		
		
	}

}
