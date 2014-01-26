package nl.tudelft.excellence.spreadsheet.cells;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		assertEquals(c1, c1);
		assertNotEquals(c1, null);
		assertNotEquals(c1, c2);
		assertEquals(c1, c3);
	}
	
	@Test
	public void testGetData() {
        assertEquals(c1.getData(), " 12.0");
    }

    @Test
    public void testGetNumber() {
		assertEquals(c1.getNumber(),12.0,0);
	}

}
