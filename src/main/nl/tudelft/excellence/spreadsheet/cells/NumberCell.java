package nl.tudelft.excellence.spreadsheet.cells;

public class NumberCell extends Cell {
	private double data;
	
	/**
	 * Create a new NumberCell Object
	 * @param rawData The raw String present in the cell
	 */
	public NumberCell(Double rawData) {
		super(rawData.toString());
		this.data = rawData;
	}

    @Override
    public boolean equals(Object other) {
        if(this==other)
            return true;

        if(other==null || !(other instanceof NumberCell))
            return false;

        NumberCell that = (NumberCell) other;
        return this.getNumber()==that.getNumber();
    }

    /**
	 * The double present in the cell
	 * @return The double present in the cell
	 */
	@Override
	public String getData() {
		return getRawData();
	}

	public double getNumber() {
		return data;
	}
}
