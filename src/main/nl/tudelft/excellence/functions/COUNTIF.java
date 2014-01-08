package nl.tudelft.excellence.functions;

import nl.tudelft.excellence.exceptions.IllegalFunctionArgumentsException;

/**
 * Count how many cells in a given range meet a given logical condition
 * <b>Syntax:</b> COUNTIF(double criteria, String criteria_operand, double...cells
 */
public class COUNTIF extends NumberFunction{
	final static int MIN_ARGS = 2;
	
	private double[] cells;
	private double criteria;
	private String operand;
	
	
	public COUNTIF(String...strings){
		super(MIN_ARGS, strings);
		cells = new double[strings.length];
		
		try{
			for(int i = 2; i < strings.length; i++){
				cells[i] = Double.parseDouble(strings[i]);	
			}
			
			criteria = Double.parseDouble(strings[0]);
		}catch(NumberFormatException e){
			throw new IllegalFunctionArgumentsException(e);
		}
		operand = strings[1];
	}

	@Override
	public double execute() {
		double res = 0;
		//equalsmethode gebruiken of kan je het wel als getal zien. Ga nu uit van
		//getal
		if (operand.equals("=")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] == criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("!=")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] != criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("<")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] < criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals(">")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] > criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("<=")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] <= criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals(">=")) {
            for (int i = 2; i < cells.length; i++) {
                    if (cells[i] >= criteria) {
                            res++;
                    }
            }
		}
		
		
		return res;
	}
}
	
