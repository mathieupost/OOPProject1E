package nl.tudelft.excellence.spreadsheet.cells;

import java.util.Observable;

public abstract class Cell extends Observable{
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
	
	/**
	 * Get a serialized version of this Cell that can be parsed to a Cell object
	 * @return A String representation of this Cell
	 */
	public String serialize(){
		return "\t" + rawData;
	}

	public abstract String getData();
}