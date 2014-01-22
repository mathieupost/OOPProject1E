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
		sheet.put(new CellCoord(2, 1), new NumberCell(1.0));
		sheet.put(new CellCoord(1, 2), new StringCell("Tweede rij:"));
		sheet.put(new CellCoord(2, 2), new FunctionCell("=B2"));
		sheet.put(new CellCoord(2, 3), new NumberCell(1.0));
		sheet.put(new CellCoord(2, 4), new NumberCell(1.0));
		sheet.put(new CellCoord(2, 5), new FunctionCell("=IF(2=B3)"));
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
	}

	@Test
	public void testParseFunctionErrors(){
		assertEquals(SpreadSheet.current.getCell(2, 2).getData(), "Error: Recursive Cell pointer");

		assertEquals(new FunctionCell("=NotACoordinate").getData(), "Error: No function or coordinate found after the '='");

		assertEquals(new FunctionCell("=AA10").getData(), "#Cell 'AA10' is empty.");

		assertEquals(new FunctionCell("=SUM(").getData(), "Error: Check your brackets!");

		assertEquals(new FunctionCell("=NOTAFUNCTION(5)").getData(), "Error: This function does not exist: NOTAFUNCTION");

		assertEquals(new FunctionCell("=AVG(5)").getData(), "Error: Need at least 2 arguments in: AVG(5)");
	}

	@Test
	public void testParsArgs(){
		assertEquals(new FunctionCell("=SUM(B1;B3:B4)").getData(), "3.0");

		assertEquals(new FunctionCell("=SUM(SUM(B3:B4);B1)").getData(), "3.0");

		assertEquals(new FunctionCell("=SUM(B3:B4;B1)").getData(), "3.0");
	}
}
