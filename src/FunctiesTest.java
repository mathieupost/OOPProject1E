import static org.junit.Assert.*;

import org.junit.Test;


public class FunctiesTest {

	@Test
	public void testAverageInt() {
		assertTrue(Functies.average(1,2,3,4)==2.5);
	}
	
	@Test
	public void testAverageDouble() {
		assertTrue(Functies.average(1.2456,  6.23456, 4874.893)==1627.45772);
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
		double testwaarde = 4;
		assertEquals(Functies.isEven(testwaarde), true);
	}
	
	@Test
	public void testIsNotEven(){
		double testwaarde = 5;
		assertEquals(Functies.isEven(testwaarde), false);
	}

	@Test
	public void testIsNumber() {
		String testString = "8";
		assertEquals(Functies.isNumber(testString), true);
	}
	
	@Test
	public void testIsNotNumber(){
		String testString = "tekst";
		assertEquals(Functies.isNumber(testString), false);
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
		assertTrue(Functies.max(3, 8, 1, -3, 8.01)==8.01);
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
		double testwaarde1 = 2;
		double testwaarde2 = 4;
		assertTrue(Functies.sum(testwaarde1, testwaarde2)==6);
	}
	
	@Test
	public void testSum2() {
		double testwaarde1 = 1;
		double testwaarde2 = 3;
		double testwaarde3 = 5;
		double testwaarde4 = 10;
		assertTrue(Functies.sum(testwaarde1, testwaarde2, testwaarde3, testwaarde4)==19);
	}

	@Test
	public void testSqrt() {
		double testwaarde1 = 9;
		assertTrue(Functies.sqrt(testwaarde1) == 3);
	}

	@Test
	public void testSignPositive() {
		assertTrue(Functies.sign(20)==1);
	}
	
	@Test
	public void testSignZero() {
		assertTrue(Functies.sign(0)==0);
	}
	
	@Test
	public void testSignNegative() {
		assertTrue(Functies.sign(-20)==-1);
	}

	@Test
	public void testRoundUp() {
		assertTrue(Functies.roundUp(1234.5678, 3)==1234.568);
	}

	@Test
	public void testRoundDown() {
		assertTrue(Functies.roundDown(1234.5678, 3)==1234.567);
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
		double testwaarde1 = 2;
		double testwaarde2 = 5;
		assertTrue(Functies.product(testwaarde1, testwaarde2) == 10);
	}
	
	@Test
	public void testProduct2() {
		double testwaarde1 = 3;
		double testwaarde2 = 6;
		double testwaarde3 = 8;
		assertTrue(Functies.product(testwaarde1, testwaarde2, testwaarde3) == 144);
	}

	@Test
	public void testPower() {
		double testwaarde1 = 2;
		double testwaarde2 = 3;
		assertTrue(Functies.power(testwaarde1, testwaarde2) == 8);
	}
	
	
	@Test
	public void testMod() {
		assertTrue(Functies.mod(19, 6)==1);
	}

	@Test
	public void testMin() {
		assertTrue(Functies.min(5.6,9,1,1000,-6.7)==-6.7);
	}

}
