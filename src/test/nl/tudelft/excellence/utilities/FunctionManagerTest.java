package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.functions.MEDIAN;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FunctionManagerTest {
	@BeforeClass
	public static void setup(){
		TreeMap<CellCoord, Cell> sheet = new TreeMap<CellCoord, Cell>();
		sheet.put(new CellCoord(1, 1), new StringCell("Eerste rij:"));
		sheet.put(new CellCoord(1, 2), new StringCell("Tweede rij:"));
        sheet.put(new CellCoord(1, 3), new FunctionCell("=A4")); // A3 and A4 contain indirect recursive pointers to each other,
        sheet.put(new CellCoord(1, 4), new FunctionCell("=A3")); // which should also be handled correctly
        sheet.put(new CellCoord(2, 1), new NumberCell(1.0));
        sheet.put(new CellCoord(2, 2), new FunctionCell("=B2"));
        sheet.put(new CellCoord(2, 3), new NumberCell(1.0));
        sheet.put(new CellCoord(2, 4), new NumberCell(1.0));
        sheet.put(new CellCoord(2, 5), new FunctionCell("=IF(2=B3)"));
        sheet.put(new CellCoord(3, 1), new FunctionCell("=SUM(D1:D2)")); //References D1(4, 1) in a range, which contains a recursive pointer
        sheet.put(new CellCoord(3, 2), new FunctionCell("=SUM(5;D3)")); //References D3(4, 3) as argument, which contains a recursive pointer
        sheet.put(new CellCoord(4, 1), new FunctionCell("=SUM(5;C1)")); //Recursive pointer to (3, 1)
        sheet.put(new CellCoord(4, 2), new NumberCell(5.0));
        sheet.put(new CellCoord(4, 3), new FunctionCell("=C2")); //Recursive pointer to (3, 2)
		SpreadSheet.current = new SpreadSheet(sheet);
	}

	@Test
	public void testGetFunctionByName(){
		assertEquals(FunctionManager.getFunctionByName("mEdIaN"), MEDIAN.class);
		assertNull(FunctionManager.getFunctionByName("ProbablyNeverWillBeAFunction"));
	}

	@Test
	public void testParseFunction() {
		assertEquals(new FunctionCell("=IF(B5;minder;fijn)").getData(), "fijn");

		assertEquals(new FunctionCell("=B5").getData(), "false");

		assertEquals(new FunctionCell("=ISEVEN(2)").getData(), "true");
	}

	@Test
	public void testParseFunctionErrors(){
        assertEquals(new FunctionCell("=NotACoordinate").getData(), "Error: No function or (valid) coordinate found after the '='");

        assertEquals(new FunctionCell("=AA10").getData(), "#Cell 'AA10' is empty.");

        assertEquals(new FunctionCell("=SUM(").getData(), "Error: Check your brackets!");

        assertEquals(new FunctionCell("=NOTAFUNCTION(5)").getData(), "Error: This function does not exist: NOTAFUNCTION");

        assertEquals(new FunctionCell("=AVG(5)").getData(), "Error: Need at least 2 arguments in: AVG(5)");
    }

    @Test
    public void testRecursionInput(){
        assertEquals(SpreadSheet.current.getCell(2, 2).getData(), "Error: Recursive Cell pointer");

        assertEquals(SpreadSheet.current.getCell(1, 3).getData(), "Error: Recursive Cell pointer");

        assertEquals(SpreadSheet.current.getCell(3, 1).getData(), "A referenced cell contains an error");

        assertEquals(SpreadSheet.current.getCell(3, 2).getData(), "Error: Expected a number, but got: 'Recursive Cell pointer in '=C2'' in: SUM(5;D3)");
    }

	@Test
	public void testParsArgs(){
		assertEquals(new FunctionCell("=SUM(B1;B3:B4)").getData(), "3.0");

		assertEquals(new FunctionCell("=SUM(SUM(B3:B4);B1)").getData(), "3.0");

		assertEquals(new FunctionCell("=SUM(B3:B4;B1)").getData(), "3.0");
	}
}
