package nl.tudelft.excellence.functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumIfTest {

	@Test
	public void test() {
		//test without sumrange
		SUMIF test = new SUMIF(6,"<",new double[]{1,2,3,4,5,6,7});
		SUMIF test2 = new SUMIF(6,"<=",new double[]{1,2,3,4,5,6,7});
		SUMIF test3 = new SUMIF(6,"!=",new double[]{1,2,3,4,5,6,7});
		assertEquals(test.execute(),(1+2+3+4+5),0);
		assertEquals(test2.execute(),(1+2+3+4+5+6),0);
		assertEquals(test3.execute(),(1+2+3+4+5+7),0);
		
		//test with sumrange
		SUMIF test4 = new SUMIF(6,"<",new double[]{1,2,3,4,5,6,7},0,5);
		SUMIF test5 = new SUMIF(6,"<=",new double[]{1,2,3,4,5,6,7},0,5);
		SUMIF test6 = new SUMIF(6,"!=",new double[]{1,2,3,4,5,6,7},0,5);
		assertEquals(test4.execute(),(1+2+3+4+5),0);
		assertEquals(test5.execute(),(1+2+3+4+5),0);
		assertEquals(test6.execute(),(1+2+3+4+5),0);
	}

}
