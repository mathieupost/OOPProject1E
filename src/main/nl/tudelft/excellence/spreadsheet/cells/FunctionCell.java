package nl.tudelft.excellence.spreadsheet.cells;

import nl.tudelft.excellence.utilities.FunctionManager;
import nl.tudelft.excellence.utilities.Utility;

public class FunctionCell extends Cell{

	/**
	 * Create a new FunctionCell Object
	 * @param rawData The raw String present in the cell
	 */
	public FunctionCell(String rawData) {
		super(rawData);
	}

    @Override
    public boolean equals(Object other) {
        if(this==other)
            return true;

        if(other==null || !(other instanceof FunctionCell))
            return false;

        FunctionCell that = (FunctionCell) other;
        return this.getRawData().equals(that.getRawData());
    }

    /**
	 * Return the result of the Function as a String
	 * <b>Note:</b> Output can be a number.
	 * @return The the result of this function
	 */
	@Override
	public String getData() {
		try {
			return FunctionManager.parseFunction(this.getRawData());
		} catch (Exception e) {
			//e.printStackTrace();
			return e.getMessage();
		}
	}
}
