package nl.tudelft.excellence.spreadsheet.cells;
public class CellCoord implements Comparable<CellCoord> {
	private long column = 0, row = 0;
	private boolean valid = true;
	
	/**
	 * Construct the CellCoord belonging to the given column and row input
	 * @param column The column of the coordinate (x-axis)
	 * @param row The row of the coordinate (y-axis)
	 */
	public CellCoord(long column, long row){
		if(row <= 0 || column <= 0){
			valid = false;
		} else {
			this.column = column;
			this.row = row;
		}
		
	}
	
	/**
	 * Construct the CellCoord belonging to the given String representation of a coordinate
	 * This can be used to parse a reference to another Cell in a function to the CellCoord belonging to it
	 * @param coord A String representation of a coordinate (Excel Syntax; fi.: AA15)
	 */
	public CellCoord(String coord){
		if(coord==null || coord.length()==0){
			valid = false;
			return;
		}
		int rowSplitIndex = 0;
		while(!Character.isDigit(coord.charAt(rowSplitIndex))) rowSplitIndex++;
		
		String temp = coord.substring(0, rowSplitIndex).toUpperCase(); //coord.substring(rowSplitIndex)
		for(int i = rowSplitIndex-1; i >= 0; i--){
			if(Character.getType(temp.charAt(i)) != Character.UPPERCASE_LETTER){
				valid = false;
				return;
			}
			column += Math.pow(26, i)*(temp.charAt(i)-64);
		}
		
		try{
			row = Long.parseLong(coord.substring(rowSplitIndex));
		} catch (NumberFormatException e){}
		if(row <= 0 || column <= 0){
			valid = false;
		}
	}
	
	/**
	 * Get the column of this coordinate (x-axis)
	 * @return The column of this coordinate
	 */
	public long getColumn() {
		return column;
	}
	
	/**
	 * Get the row of this coordinate (y-axis)
	 * @return The row of this coordinate
	 */
	public long getRow() {
		return row;
	}
	
	/**
	 * Get whether or not this coordinate is valid (overflow detection)
	 * @return Whether or not this coordinate is valid
	 */
	public boolean isValid(){
		return valid;
	}
	
	/**
	 * Get the coordinate of this column in the next row
	 * @return The CellCoord of this column in the next row
	 */
	public CellCoord nextRow(){
		return new CellCoord(column, row+1);
	}
	
	/**
	 * Get the coordinate of this row in the next column
	 * @return The CellCoord of this row in the next column
	 */
	public CellCoord nextColumn(){
		return new CellCoord(column+1, row);
	}
	
	/**
	 * Get the coordinate of this column in the previous row
	 * @return The CellCoord of this column in the previous row
	 */
	public CellCoord previousRow(){
		return new CellCoord(column, row-1);
	}
	
	/**
	 * Get the coordinate of this row in the previous column
	 * @return The CellCoord of this row in the previous column
	 */
	public CellCoord previousColumn(){
		return new CellCoord(column-1, row);
	}
	
	@Override
	public boolean equals(Object other){
		if(this==other)
			return true;
		
		if(other==null || !(other instanceof CellCoord))
			return false;
		
		CellCoord that = (CellCoord) other;
		return this.column == that.column && this.row == that.row;
	}

	@Override
	public int compareTo(CellCoord other) {
		return  Long.signum(this.row==other.row? this.column-other.column : this.row-other.row);
	}
	
	/**
	 * Get a serialized version of this CellCoord that can be parsed to a CellCoord object
	 * @return A String representation of this CellCoord
	 */
	public String serialize(){
		return "row=\""+row+"\" column=\""+column+"\"";
	}
	
}
