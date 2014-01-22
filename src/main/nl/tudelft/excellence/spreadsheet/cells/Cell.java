package nl.tudelft.excellence.spreadsheet.cells;

import nl.tudelft.excellence.utilities.Utility;

public abstract class Cell{
	private CellType type;
	private String rawData;
	
	/**
	 * Create a new Cell Object
	 * @param rawData The raw String present in the cell
	 */
	public Cell(String rawData) {
		this.rawData = rawData;
		type = CellType.fromClass(this.getClass());
	}
	
	/**
	 * Get the raw String present in the cell
	 * @return The raw String present in the cell
	 */
	public String getRawData() {
		return rawData;
	}

	/**
	 * Get the CellType of this Cell
	 * @return The CellType of this Cell
	 */
	public CellType getType() {
		return type;
	}

    @Override
    public abstract boolean equals(Object other);

	/**
	 * Get a serialized version of this Cell that can be parsed to a Cell object
	 * @return A String representation of this Cell
	 */
	public String serialize(){
		return "\t" + Utility.escapeXML(rawData) + "";
	}

	public abstract String getData();
}
