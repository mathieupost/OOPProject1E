package nl.tudelft.excellence.spreadsheet.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	FunctionCell cell1 = new FunctionCell("=abcdefg");
	StringCell cell2 = new StringCell("abcdefg");
	NumberCell cell3 = new NumberCell(0.6);
	
	@Test
	public void testGets() {
		assertEquals(cell1.getRawData(),"=abcdefg");
		assertEquals(cell1.getType(), CellType.FUNCTION);
		
		assertEquals(cell2.getRawData(),"abcdefg");
		assertEquals(cell2.getType(), CellType.STRING);
		
		assertEquals(cell3.getRawData(),"0.6");
		assertEquals(cell3.getType(), CellType.NUMBER);
	}
	
	@Test
	public void testSerialize(){
		assertEquals(cell1.serialize(),"\t" + cell1.getRawData());
		assertEquals(cell1.serialize(),"	=abcdefg");
		
		assertEquals(cell2.serialize(),"\t" + cell2.getRawData());
		assertEquals(cell2.serialize(),"	abcdefg");
		
		assertEquals(cell3.serialize(),"\t" + cell3.getRawData());
		assertEquals(cell3.serialize(),"	0.6");
	}

}
