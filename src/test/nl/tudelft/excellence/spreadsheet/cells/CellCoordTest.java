package nl.tudelft.excellence.spreadsheet.cells;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellCoordTest {
    static CellCoord c1, c2, c3, c4;

    @After
    public void breakDown (){
        c1 = c2 = c3 = c4 = null;
    }

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#CellCoord(int, int)}.
	 */
	@Test
	public void testCellCoordLongLong() {
        c1 = new CellCoord(2, 5);
        c2 = new CellCoord(5, 2);
        assertNotEquals(c1, c2);
        assertEquals(c1, c1);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#CellCoord(java.lang.String)}.
	 */
	@Test
	public void testCellCoordString() {
        c1 = new CellCoord("AA482");
        c2 = new CellCoord("AA483").previousRow();
        assertEquals(c1, c2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#getColumn()}.
	 */
	@Test
	public void testGetColumn() {
		c1 = new CellCoord(2, 5);
        assertEquals(c1.getColumn(), 2);
        assertNotEquals(c1.getColumn(), 5);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#getRow()}.
	 */
	@Test
	public void testGetRow() {
        c1 = new CellCoord(2, 5);
        assertEquals(c1.getRow(), 5);
        assertNotEquals(c1.getRow(), 2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#isValid()}.
	 */
	@Test
	public void testIsValid() {
        c1 = new CellCoord(-3, 4);
        assertFalse(c1.isValid());
        c2 = new CellCoord(3, 4);
        assertTrue(c2.isValid());

        c3 = new CellCoord("A-4");
        assertFalse(c3.isValid());
        c4 = new CellCoord("A5");
        assertTrue(c4.isValid());

        c1 = new CellCoord("");
        assertFalse(c1.isValid());
        c2 = new CellCoord(null);
        assertFalse(c2.isValid());
        c3 = new CellCoord("A3-5");
        assertFalse(c3.isValid());
        c4 = new CellCoord("5");
        assertFalse(c4.isValid());
    }

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#nextRow()}.
	 */
	@Test
	public void testNextRow() {
        c1 = new CellCoord("A4");
        c2 = new CellCoord("A5");
        assertEquals(c1.nextRow(), c2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#nextColumn()}.
	 */
	@Test
	public void testNextColumn() {
        c1 = new CellCoord("A5");
        c2 = new CellCoord("B5");
        assertEquals(c1.nextColumn(), c2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#previousRow()}.
	 */
	@Test
	public void testPreviousRow() {
		c1 = new CellCoord("A5");
        c2 = new CellCoord("A4");
        assertEquals(c1.previousRow(), c2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#previousColumn()}.
	 */
	@Test
	public void testPreviousColumn() {
        c1 = new CellCoord("B5");
        c2 = new CellCoord("A5");
        assertEquals(c1.previousColumn(), c2);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		c1 = new CellCoord("A4");
        assertNotEquals(c1, null);
        assertNotEquals(c1, this);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#compareTo(nl.tudelft.excellence.spreadsheet.cells.CellCoord)}.
	 */
	@Test
	public void testCompareTo() {
        c1 = new CellCoord("A5");
        c2 = new CellCoord("B5");
        assertEquals(c1.compareTo(c2), -1);
	}

	/**
	 * Test method for {@link nl.tudelft.excellence.spreadsheet.cells.CellCoord#serialize()}.
	 */
	@Test
	public void testSerialize() {
        c1 = new CellCoord(2, 5);
        assertEquals(c1.serialize(), "row=\"5\" column=\"2\"");
	}

}
