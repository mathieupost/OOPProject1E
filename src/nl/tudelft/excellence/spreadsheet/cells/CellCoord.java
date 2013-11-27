package nl.tudelft.excellence.spreadsheet.cells;
public class CellCoord {
	private long column, row;
	private boolean valid = true;
	
	public CellCoord(long column, long row){
		if(row <= 0 || column <= 0){
			valid = false;
		} else {
			this.column = column;
			this.row = row;
		}
		
	}
	
	public long getColumn() {
		return column;
	}
	
	public long getRow() {
		return row;
	}
	
	public boolean isValid(){
		return valid;
	}
	
	public CellCoord nextRow(){
		return new CellCoord(column, row+1);
	}
	
	public CellCoord nextColumn(){
		return new CellCoord(column+1, row);
	}
	
	public CellCoord previousRow(){
		return new CellCoord(column, row-1);
	}
	
	public CellCoord previousColumn(){
		return new CellCoord(column-1, row);
	}
	
	public boolean equals(Object other){
		if(this==other)
			return true;
		
		if(other==null || !(other instanceof CellCoord))
			return false;
		
		CellCoord that = (CellCoord) other;
		return this.column == that.column && this.row == that.row;
	}
	
}
