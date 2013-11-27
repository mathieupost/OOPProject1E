import static org.junit.Assert.*;

import org.junit.Test;


public class FunctiesTest {

	@Test
	public void testAverage() {
		assertTrue(Functies.average(1,2,3,4)==2.5);
		assertTrue(Functies.average(1.2456,6.23456,4874.893)==1627.45772);
		//Casper
	}

	@Test
	public void testCount() {
		
		//
	}

	@Test
	public void testCountA() {
		
		//
	}

	@Test
	public void testCountIf() {
		
	}

	@Test
	public void testTestIf() {
		
	}

	@Test
	public void testMakeIntPositive() {
		assertEquals(Functies.makeInt(5.234), 5);
	}
	
	@Test
	public void testMakeIntNegative() {
		assertEquals(Functies.makeInt(-5.234), -5);
	}

	@Test
	public void testIsLogical() {
		
		//
	}

	@Test
	public void testIsEven() {
		
		//Matthijs
	}

	@Test
	public void testIsNumber() {
		
		//Matthijs
	}

	@Test
	public void testLower1() {
		assertTrue(Functies.lower("DIT IS EEN TESTBERICHT").equals("dit is een testbericht"));
	}
	
	@Test
	public void testLower2() {
		assertTrue(Functies.lower("DiT Is eEn TeStBeRiChT").equals("dit is een testbericht"));
	}

	@Test
	public void testMax() {
		assertEquals(Functies.max(3, 8, 1, -3, 8.01), 8.01);
	}

	@Test
	public void testMedianEven() {
		assertTrue(Functies.median(1,2,3,4)==2.5);
	}
	
	@Test
	public void testMedinUneven() {
		assertTrue(Functies.median(1,2,5,6,7)==5);
	}

	@Test
	public void testSum() {
		
		//Matthijs
	}

	@Test
	public void testSqrt() {
		
		//Matthijs
	}

	@Test
	public void testSign() {
		
		//Wilbert
	}

	@Test
	public void testRoundUp() {
		
		//Wilbert
	}

	@Test
	public void testRoundDown() {
		
		//Wilbert
	}

	@Test
	public void testProper1() {
		assertTrue(Functies.proper("Dit is een testbericht").equals("Dit Is Een Testbericht"));	
	}
	
	@Test
	public void testProper2() {
		assertTrue(Functies.proper("DIT IS EEN TESTBERICHT").equals("Dit Is Een Testbericht"));
	}
		
	@Test
	public void testProduct() {
		
		//Matthijs
	}

	@Test
	public void testPower() {
		
		//Matthijs
	}

	@Test
	public void testMod() {
		
		//Wilbert
	}

	@Test
	public void testMin() {
		assertTrue(Functies.min(5.6,9,1,1000,-6.7)==-6.7);
	}

}
