package nl.tudelft.excellence.spreadsheet.cells;

public class StringCell extends Cell {
	
	/**
	 * Create a new StringCell Object
	 * @param rawData The raw String present in the cell
	 */
	public StringCell(String rawData) {
		super(rawData);
	}
	
	/**
	 * Get the String present in the cell
	 * @return The String present in the cell
	 */
	public String getData(){
		return getRawData();
	}

}
