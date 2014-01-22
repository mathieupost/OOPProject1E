package nl.tudelft.excellence.spreadsheet.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCellTest {

	Cell c1 = new StringCell("This is a String");	
	Cell c2 = new NumberCell(12.0);
	Cell c3 = new StringCell("This is a String");

	@Test
	public void testConstructor() {
		assertEquals(c1.getType(),CellType.STRING);
		assertEquals(c1.getRawData(),"This is a String");
	}
	
	@Test
	public void testEquals() {
		assertEquals(c1.equals(c1),true);
		assertEquals(c1.equals(null),false);
		assertEquals(c1.equals(c2),false);
		assertEquals(c1.equals(c3),true);
	}
	
	@Test
	public void testGetData(){
		assertEquals(c1.getData(),"This is a String");
	}

}
