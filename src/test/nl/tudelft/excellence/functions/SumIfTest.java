package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumIfTest {

	@Test
	public void test() {
		//test without sumrange
		SUMIF test = new SUMIF("6","=","1","2","3","4","5","6","7");
		SUMIF test2 = new SUMIF("6","!=","1","2","3","4","5","6","7");
		SUMIF test3 = new SUMIF("6","<","1","2","3","4","5","6","7");
		SUMIF test4 = new SUMIF("6",">","1","2","3","4","5","6","7");
		SUMIF test5 = new SUMIF("6","<=","1","2","3","4","5","6","7");
		SUMIF test6 = new SUMIF("6",">=","1","2","3","4","5","6","7");
		assertEquals(test.execute(),6,0);
		assertEquals(test2.execute(),(1+2+3+4+5+7),0);
		assertEquals(test3.execute(),(1+2+3+4+5),0);
		assertEquals(test4.execute(),7,0);
		assertEquals(test5.execute(),(1+2+3+4+5+6),0);
		assertEquals(test6.execute(),(6+7),0);		
	}
}
