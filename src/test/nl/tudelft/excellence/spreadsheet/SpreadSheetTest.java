package nl.tudelft.excellence.spreadsheet;

import nl.tudelft.excellence.exceptions.SaveNotNeededException;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.spreadsheet.cells.NumberCell;
import nl.tudelft.excellence.spreadsheet.cells.StringCell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class SpreadSheetTest {
    SortedMap<CellCoord, Cell> sheet;
    SpreadSheet s1, s2, s3, s4;

    @Before
    public void beforeTest() {
        sheet = new TreeMap<CellCoord, Cell>();
        sheet.put(new CellCoord(1, 1), new StringCell("Eerste rij:"));
        sheet.put(new CellCoord(2, 1), new NumberCell(24.0));
        sheet.put(new CellCoord(1, 2), new StringCell("Tweede rij:"));
        sheet.put(new CellCoord(2, 2), new NumberCell(25.0));
        s1 = new SpreadSheet(sheet);
    }

    @After
    public void afterTest() {
        sheet = null;
        s1 = s2 = s3 = s4 = null;
    }

    @Test
    public void testConstructor() {
        SpreadSheet s5 = new SpreadSheet();
        SpreadSheet s6 = new SpreadSheet(new TreeMap<CellCoord, Cell>());
        assertEquals(s5.equals(s6), true);
        assertEquals(s6.equals(s5), true);

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
        assertEquals(s1.getCell(1, 1).serialize(), "\tEerste rij:");
    }

    /**
     * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#getCell(nl.tudelft.excellence.spreadsheet.cells.CellCoord)}.
     */
    @Test
    public void testGetCellCellCoord() {
        assertEquals(s1.getCell(new CellCoord(1, 1)).serialize(), "\tEerste rij:");
    }

    @Test
    public void testGetCellCoords() {
        ArrayList<String> test1 = s1.getCellCoords("A1", "B2");
        assertEquals(test1.get(0), "A1");
        assertEquals(test1.get(1), "A2");
        assertEquals(test1.get(2), "B1");
        assertEquals(test1.get(3), "B2");
        assertNull(s1.getCellCoords("A1", "not valid"));
        assertNull(s1.getCellCoords("also not valid", "B2"));
    }

    /**
     * Test method for {@link nl.tudelft.excellence.spreadsheet.SpreadSheet#putCell(nl.tudelft.excellence.spreadsheet.cells.CellCoord, nl.tudelft.excellence.spreadsheet.cells.Cell)}.
     */
    @Test
    public void testPutCell() {
        NumberCell c1 = new NumberCell(26.0);
        NumberCell c2 = new NumberCell(26.0);
        s1.putCell(new CellCoord(2, 1), c1);
        s1.putCell(new CellCoord(-3, 1), c2);
        assertEquals(s1.getCell(2, 1), c1);
        assertEquals(s1.getCell(-3, 1), null);
    }

    @Test
    public void testRemoveCell() {
        NumberCell c1 = new NumberCell(26.0);
        s1.putCell(new CellCoord(2, 1), c1);
        assertEquals(s1.getCell(2, 1), c1);
        s1.removeCell(new CellCoord(2, 1));
        assertEquals(s1.getCell(2, 1), null);
    }

    @Test
    public void testOpenFile() {
        assertNull(SpreadSheet.openFile(null));
        assertNull(SpreadSheet.openFile("C://windows/system32/doesnotexist.xml"));
        s2 = SpreadSheet.openFile("assets/testfile.xml");
        assertEquals(s2.serialize(),
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
                        "\t\t=SUM(A2;10)\n" +
                        "\t</CELL>\n" +
                        "</SPREADSHEET>"
        );
    }

    @Test
    public void testSaveFile() {
        try {
            assertEquals(s1.saveToFile("assets/testfile.xml"), false);
            fail();
        } catch (SaveNotNeededException e) {
        }

        try {
            assertEquals(s1.saveToFile(null, true), false);
        } catch (SaveNotNeededException e) {
            fail();
        }
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

    @Test
    public void testHasUnsavedChanges() {
        assertEquals(s1.hasUnsavedChanges(), false);
        s1.putCell(new CellCoord(1, 1), s1.getCell(1, 1)); //Sets unsaved changes to true
        assertEquals(s1.hasUnsavedChanges(), true);
    }
}
