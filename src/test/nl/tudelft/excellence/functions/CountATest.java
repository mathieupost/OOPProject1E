package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountATest {

	@Test
	public void testCountA() {
        SpreadSheet.current = new SpreadSheet();
        // If a Cell is empty, the Coordinate will be passed through (Utility.getValue() provides this behaviour)
        COUNTA c = new COUNTA("abc", "A5", "x");
        assertEquals(c.execute(), 2, 0);
        SpreadSheet.current = null;
    }

}
