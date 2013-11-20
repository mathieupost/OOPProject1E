public class Cell {
	private int row;
	private int column;
	private String rawData;

	public Cell(int row, int column, String rawData) {
		this.row = row;
		this.column = column;
		this.rawData = rawData;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String getRawData() {
		return rawData;
	}
}
