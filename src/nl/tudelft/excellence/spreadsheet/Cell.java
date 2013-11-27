package nl.tudelft.excellence.spreadsheet;
public class Cell {
	private CellData cellData;

	public Cell(String rawData) {
		this.cellData = new CellData(rawData);
	}

	public CellData getCellData() {
		return cellData;
	}
}
