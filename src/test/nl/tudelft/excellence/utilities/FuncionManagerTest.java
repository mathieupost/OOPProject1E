package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.*;
import org.junit.Test;

import java.util.TreeMap;

public class FuncionManagerTest {

	@Test
	public void testFunctionManager() {
		TreeMap<CellCoord, Cell> sheet = new TreeMap<CellCoord, Cell>();
		sheet.put(new CellCoord(1, 1), new StringCell("Eerste rij:"));
		sheet.put(new CellCoord(2, 1), new NumberCell(1.0));
		sheet.put(new CellCoord(1, 2), new StringCell("Tweede rij:"));
		sheet.put(new CellCoord(2, 2), new NumberCell(1.0));
		sheet.put(new CellCoord(2, 3), new NumberCell(1.0));
		sheet.put(new CellCoord(2, 4), new NumberCell(1.0));
		sheet.put(new CellCoord(2, 5), new FunctionCell("=IF(2=B2)"));
		SpreadSheet s1 = new SpreadSheet(sheet);
		SpreadSheet.current = s1;

		Cell cell = new FunctionCell("=IF(B5;SUM(B1:B4);hoi)");
		System.out.println("cellRawData = " + cell.getRawData());
		System.out.println("cellData = " + cell.getData());
	}
}
