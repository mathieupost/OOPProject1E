//import java.util.*;
//TODO: Comments

public class Functies_1 {

	public Functies_1() {

	}
	
	// DONE
	// Cel parser takes care of additional functionality (arrays, references to numbers)
	public static double average(double a, double... values){
		double res = a;
		for (int i = 0; i < values.length; i++) {
			res = (res + values[i]);
		}
		res /= (values.length+1);
		return res;
	}

	// TODO: Implement when working with cell coördinates
	// Count cells in range that contain numbers
	public static int count() {
		int res = 0;
		return res;
	}

	// TODO: Implement when working with cell coördinates
	// Count cells in range that are not empty
	public static int countA() {
		int res = 0;
		return res;
	}

	// TODO: Implement when working with cell coördinates
	// Count cells in range that meet a given condition
	public static int countIf() {
		int res = 0;
		return res;
	}
	
	// DONE
	// Compares 2 doubles
	public static String testIf(String logictest, String iftrue, String iffalse) {
		String[] split = logictest.split(" ");
		double a = Double.parseDouble(split[0]);
		double b = Double.parseDouble(split[2]);
		if (split[1].equals("=")) {
			if (a == b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals("<")) {
			if (a < b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals(">")) {
			if (a > b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals(">=")) {
			if (a >= b) {
				return iftrue;
			} else {
				return iffalse;
			}
		} else if (split[1].equals("<=")) {
			if (a <= b) {
				return iftrue;
			} else {
				return iffalse;
			}
		}
		return iffalse;
	}
	
	// DONE
	// Rounds down
	public int makeInt(double value){		
		return (int) Math.floor(value);
	}
	
	// DONE
	// Checks if String is a logical value
	public static boolean isLogical(String value) {
		return value.toLowerCase().equals("true")
				|| value.toLowerCase().equals("false");
	}

	public static boolean isEven(String value) throws NumberFormatException {
		return Double.parseDouble(value) % 2 == 0;
	}

	public static boolean isNumber(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static String lower(String value) {
		return value.toLowerCase();
	}

	// TODO: ignores locigal values and text
	public static Double max(double[] values) {
		double res = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] > res) {
				res = values[i];
			}
		}
		return res;
	}
	
	public static double median(double[] values){
		double res = 0;
		if(values.length %2==0){
			double a = Math.ceil(values.length);
		}
		else if(values.length %2 != 0){
			
		}
		return res;
	}

	public static void main(String[] args) {
		//System.out.println(average(6,8));
		//System.out.println(average(6,9));
		//System.out.println(average(1,3,5));
		/*
		 * System.out.println(Iseven(1)); System.out.println(Iseven(2));
		 * System.out.println(Iseven(1337));
		 */
		/*
		 * System.out.println(Islogical("FALSE"));
		 * System.out.println(Islogical("\"FALSE\""));
		 */
		// double[] array1 = {2.5, 8.43, 1337.0, 1009.29};
		// System.out.println(max(array1));
		// System.out.println(Average(array1));
		/*
		 * System.out.println(If("13.6 < 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.6 > 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.6 = 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.7 = 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.7 <= 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.7 >= 13.7","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.7 >= 13.6","Het is waar!","Het is niet waar!"
		 * ));
		 * System.out.println(If("13.7 <= 13.6","Het is waar!","Het is niet waar!"
		 * ));
		 */

	}

}
