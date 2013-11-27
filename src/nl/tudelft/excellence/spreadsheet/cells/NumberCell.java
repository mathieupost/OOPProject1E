package nl.tudelft.excellence.spreadsheet.cells;

public class NumberCell extends Cell {
	private double data;
	
	public NumberCell(String rawData) {
		super(rawData);
		this.data = Double.parseDouble(rawData);
	}

	public double getData() {
		return data;
	}

}
