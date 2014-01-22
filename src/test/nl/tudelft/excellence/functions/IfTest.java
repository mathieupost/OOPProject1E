package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IfTest {
	@BeforeClass
	public static void setup() {
		SpreadSheet.current = new SpreadSheet(new TreeMap<CellCoord, Cell>());
	}

	@Test
	public void testIfEqualFalse() {
		IF i = new IF("8 =7", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfEqualTrue() {
		IF i = new IF("8 = 8", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerTrue() {
		IF i = new IF("8 < 10", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerFalse() {
		IF i = new IF("8 < 5", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfBiggerFalse() {
		IF i = new IF("8 > 8", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfBiggerTrue() {
		IF j = new IF("8 > 7", "ja", "nee");
		assertEquals(j.execute(), "ja");
	}
	
	@Test
	public void testIfBiggerEqualTrue() {
		IF i = new IF("8 >= 8", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfBiggerEqualFalse() {
		IF i = new IF("5 >= 8", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfNotEqualsFalse() {
		IF i = new IF("8!= 8", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	@Test
	public void testIfNotEqualsTrue() {
		IF i = new IF("8 != 5", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerEqualTrue(){
		IF i = new IF("8 <= 10", "ja", "nee");
		assertEquals(i.execute(), "ja");
	}
	
	@Test
	public void testIfSmallerEqualFalse(){
		IF i = new IF("18 <= 10", "ja", "nee");
		assertEquals(i.execute(), "nee");
	}
	
	
	@Test
	public void test2(){
		try{
			new IF("2", "ja");
			fail();
		} catch(IllegalFunctionArgumentsException ignore){}
		
	}

}
