package nl.tudelft.excellence.spreadsheet.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberCellTest {

	NumberCell c1 = new NumberCell(12.0);
	StringCell c2 = new StringCell("something");
	NumberCell c3 = new NumberCell(12.0);
	
	@Test
	public void testConstructor() {
		assertEquals(c1.getType(),CellType.NUMBER);
		assertEquals(c1.getRawData(),"12.0");
	}
	
	@Test
	public void testEquals() {
		assertEquals(c1.equals(c1),true);
		assertEquals(c1.equals(null),false);
		assertEquals(c1.equals(c2),false);
		assertEquals(c1.equals(c3),true);
	}
	
	@Test
	public void testGetData() {
		assertEquals(c1.getData(),"12.0");
	}
	
	@Test
	public void testGetNumber() {
		assertEquals(c1.getNumber(),12.0,0);
	}

}
