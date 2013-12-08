package nl.tudelft.excellence.functions;

/**
 * Count how many cells in a given range meet a given logical condition
 * <b>Syntax:</b> COUNTIF(double criteria, String criteria_operand, double...cells
 */
public class COUNTIF extends NumberFunction{

	private double[] cells;
	private double criteria;
	private String operand;
	
	public COUNTIF(double criteria1, String criteria_operand, double...strings){
		cells = new double[strings.length];
		for(int i = 0; i < strings.length; i++){
			cells[i] = strings[i];
		}
		
		criteria = criteria1;
		operand = criteria_operand;
	}

	@Override
	public double execute() {
		double res = 0;
		//equalsmethode gebruiken of kan je het wel als getal zien. Ga nu uit van
		//getal
		if (operand.equals("=")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] == criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("!=")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] != criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("<")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] < criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals(">")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] > criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals("<=")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] <= criteria) {
                            res++;
                    }
            }
		}
		if (operand.equals(">=")) {
            for (int i = 0; i < cells.length; i++) {
                    if (cells[i] >= criteria) {
                            res++;
                    }
            }
		}
		
		
		return res;
	}
}
	
