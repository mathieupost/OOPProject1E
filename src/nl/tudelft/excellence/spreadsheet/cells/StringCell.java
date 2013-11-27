package nl.tudelft.excellence.spreadsheet.cells;

public class StringCell extends Cell {
	
	public StringCell(String rawData) {
		super(rawData);
	}
	
	public String getData(){
		return getRawData();
	}

}
