package nl.tudelft.excellence.spreadsheet.cells;

public class NumberCell extends Cell {
	private double data;
	
	/**
	 * Create a new NumberCell Object
	 * @param rawData The raw String present in the cell
	 */
	public NumberCell(String rawData) {
		super(rawData);
		this.data = Double.parseDouble(rawData);
	}
	
	/**
	 * The double present in the cell
	 * @return The double present in the cell
	 */
	public double getData() {
		return data;
	}

}
