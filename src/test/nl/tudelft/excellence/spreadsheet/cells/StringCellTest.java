package nl.tudelft.excellence.spreadsheet.cells;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertTrue(c1.equals(c1));
        assertTrue(c1.equals(c3));

        assertFalse(c1.equals(null));
        assertFalse(c1.equals(c2));
    }

    @Test
	public void testGetData(){
        assertEquals(c1.getData(), " This is a String");
    }

}
