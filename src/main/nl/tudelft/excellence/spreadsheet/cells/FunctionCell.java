package nl.tudelft.excellence.spreadsheet.cells;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FunctionCell extends Cell implements Observer {
	private ArrayList<CellCoord> references = new ArrayList<CellCoord>(); //TODO Implement this as a way to keep track of referenced cells
	
	/**
	 * Create a new FunctionCell Object
	 * @param rawData The raw String present in the cell
	 */
	public FunctionCell(String rawData) {
		super(rawData);
	}
	
	/**
	 * Return the result of the Function as a String
	 * <b>Note:</b> Output can be a number.
	 * @return The the result of this function
	 */
	public String getData(){
		return ""; //TODO Parse function
	}
	
	
	/**
	 * Get if the output of this function is a double or a String
	 * @return 
	 */
	public boolean isNumber(){
		try{
			Double.parseDouble(getRawData());
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
