package nl.tudelft.excellence.spreadsheet.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTypeTest {

	//NumberCell cell1 = new NumberCell(1.3);

	@Test
	public void testFromName() {
		assertEquals(CellType.fromName("number"), CellType.NUMBER);
		assertEquals(CellType.fromName("FunCtiOn"), CellType.FUNCTION);
		assertEquals(CellType.fromName("STRING"), CellType.STRING);
	}
	
	@Test
	public void testFromClass(){
		assertEquals(CellType.fromClass(NumberCell.class), CellType.NUMBER);
		assertEquals(CellType.fromClass(FunctionCell.class), CellType.FUNCTION);
		assertEquals(CellType.fromClass(StringCell.class), CellType.STRING);
	}
}
