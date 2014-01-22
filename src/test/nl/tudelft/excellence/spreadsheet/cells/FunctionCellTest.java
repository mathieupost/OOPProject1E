package nl.tudelft.excellence.spreadsheet.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionCellTest {

	Cell c1 = new FunctionCell("=SUM(3,4)");	

	@Test
	public void testConstructor() {
		assertEquals(c1.getType(),CellType.FUNCTION);
		assertEquals(c1.getRawData(),"=SUM(3,4)");
	}
	
	@Test
	public void testEquals() {
		assertEquals(c1.equals(c1),true);
		assertEquals(c1.equals(null),false);
		Cell c2 = new FunctionCell("AVG(1,2,3");
		Cell c3 = new FunctionCell("=SUM(3,4)");
		assertEquals(c1.equals(c2),false);
		assertEquals(c1.equals(c3),true);
	}

}
