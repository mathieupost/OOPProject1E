public class CellData {
	String rawData;

	protected CellData(String rawData) {
		this.rawData = rawData;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public CellData getCellData(String rawData) {
		// TODO check what kind of cell this is (formula, number, string)
		return new CellData(rawData);
	}
}
