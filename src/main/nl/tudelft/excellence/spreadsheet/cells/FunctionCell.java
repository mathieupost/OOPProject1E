package nl.tudelft.excellence.spreadsheet.cells;

import nl.tudelft.excellence.utilities.FunctionManager;
import nl.tudelft.excellence.utilities.Utility;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FunctionCell extends Cell implements Observer {
	private ArrayList<CellCoord> references = new ArrayList<CellCoord>(); //TODO Implement this as a way to keep track of referenced cells
    private String result;
	
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
        if(Utility.isNumber(this.getData()) && Utility.isNumber(that.getData())){
            return Double.parseDouble(this.getData())==Double.parseDouble(that.getData());
        } else if(Utility.isBoolean(this.getData()) && Utility.isBoolean(that.getData())){
            return Boolean.parseBoolean(this.getData())==Boolean.parseBoolean(that.getData());
        } else {
            return this.getData().equals(that.getData());
        }
    }

    /**
	 * Return the result of the Function as a String
	 * <b>Note:</b> Output can be a number.
	 * @return The the result of this function
	 */
	@Override
	public String getData() {
		if(this.result == null){
            result = FunctionManager.parseFunction(this.getRawData());
        }
        return result;
	}

    @Override
    public void update(Observable o, Object arg) {
		
	}

    private boolean isSame(String s1, String s2){
        if(s1==s2)
            return true;

        if(s1==null || s2==null)
            return false;

        if(Utility.isNumber(s1) && Utility.isNumber(s2)){
            return Double.parseDouble(s1)==Double.parseDouble(s2);
        } else if(Utility.isBoolean(s1) && Utility.isBoolean(s2)){
            return Boolean.parseBoolean(s1)==Boolean.parseBoolean(s2);
        } else {
            return s1.equals(s2);
        }
    }

}
