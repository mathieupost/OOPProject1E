package nl.tudelft.excellence.spreadsheet;

import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.spreadsheet.cells.NumberCell;
import nl.tudelft.excellence.spreadsheet.cells.StringCell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SpreadSheetTest {
    SortedMap<CellCoord, Cell> sheet;
    SpreadSheet s1, s2, s3, s4;

    @Before
    public void beforeTest(){
        sheet = new TreeMap<CellCoord, Cell>();
        sheet.put(new CellCoord(1,1), new StringCell("Eerste rij:"));
        sheet.put(new CellCoord(2,1), new NumberCell(24.0));
        sheet.put(new CellCoord(1,2), new StringCell("Tweede rij:"));
        sheet.put(new CellCoord(2,2), new NumberCell(25.0));
        s1 = new SpreadSheet(sheet);
    }

    @After
    public void afterTest(){
        sheet = null;
        s1 = s2 = s3 = s4 = null;
    }

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#SpreadSheet(java.util.SortedMap)}.
	 */
	@Test
	public void testSpreadSheet() {
        s2 = new SpreadSheet(sheet);
        assertEquals(s1, s1);
        assertEquals(s1, s2);
        assertNotEquals(s1, null);
        assertNotEquals(s1, this);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#getCell(int, int)}.
	 */
	@Test
	public void testGetCellLongLong() {
		assertEquals(s1.getCell(1,1).serialize(), "\tEerste rij:");
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#getCell(nl.tudelft.excellence.spreadsheet.cells.CellCoord)}.
	 */
	@Test
	public void testGetCellCellCoord() {
        assertEquals(s1.getCell(new CellCoord(1,1)).serialize(), "\tEerste rij:");
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#putCell(nl.tudelft.excellence.spreadsheet.cells.CellCoord, nl.tudelft.excellence.spreadsheet.cells.Cell)}.
	 */
	@Test
	public void testPutCell() {
        NumberCell c1 = new NumberCell(26.0);
        s1.putCell(new CellCoord(2,1), c1);
		assertEquals(s1.getCell(2, 1), c1);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#serialize()}.
	 */
	@Test
	public void testSerialize() {
        assertEquals(s1.serialize(),
                "<?xml version=\"1.0\"?>\n" +
                "<SPREADSHEET>\n" +
                    "\t<CELL row=\"1\" column=\"1\">\n" +
                        "\t\tEerste rij:\n" +
                    "\t</CELL>\n" +
                    "\t<CELL row=\"1\" column=\"2\">\n" +
                        "\t\t24.0\n" +
                    "\t</CELL>\n" +
                    "\t<CELL row=\"2\" column=\"1\">\n" +
                        "\t\tTweede rij:\n" +
                    "\t</CELL>\n" +
                    "\t<CELL row=\"2\" column=\"2\">\n" +
                        "\t\t25.0\n" +
                    "\t</CELL>\n" +
                "</SPREADSHEET>"
        );
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#toString()}.
	 */
	@Test
	public void testToString() {
        assertEquals(s1.toString(),
                "SpreadSheet toString output:\n" +
                "==============================================\n" +
                "Coord:\t(1, 1)\n" +
                "Content:'Eerste rij:'\n" +
                "\n" +
                "Coord:\t(2, 1)\n" +
                "Content:'24.0'\n" +
                "\n" +
                "Coord:\t(1, 2)\n" +
                "Content:'Tweede rij:'\n" +
                "\n" +
                "Coord:\t(2, 2)\n" +
                "Content:'25.0'\n" +
                "\n"
        );
	}

}
