public class Cell {
	private long row;
	private long column;
	private CellData cellData;

	public Cell(String rawData) {
		this.cellData = new CellData(rawData);
	}

	public CellData getCellData() {
		return cellData;
	}
}
