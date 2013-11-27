package nl.tudelft.excellence.spreadsheet.cells;
public /*abstract*/ class Cell {
	private CellType type;
	private String rawData;

	public Cell(String rawData) {
		this.rawData = rawData;
		type = CellType.fromClass(this.getClass());
	}

	public String getRawData() {
		return rawData;
	}

	public CellType getType() {
		return type;
	}
}
