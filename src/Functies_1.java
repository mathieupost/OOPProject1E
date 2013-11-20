import java.util.*;
//TODO: Commentaar

public class Functies_1 {

	public Functies_1() {
	
	}
	
	public static double Average(String[] values) throws NumberFormatException {
		double res = Double.parseDouble(values[0]);
		for (int i = 1; i < values.length; i++) {
			res = (res + Double.parseDouble(values[i]));
		}
		res /= values.length;
		return res;
	}

	// TODO: Count
	public static int Count() {
		int res = 0;
		return res;
	}

	// TODO: CountA
	public static int CountA() {
		int res = 0;
		return res;
	}

	// TODO: CountIf
	public static int CountIf() {
		int res = 0;
		return res;
	}

	// Vergelijkt 2 doubles
	public static String If(String logictest, String iftrue, String iffalse) {
		String[] split = logictest.split(" ");
		double a = Double.parseDouble(split[0]);
		double b = Double.parseDouble(split[2]);
		// System.out.println(a);
		// System.out.println(split[1]);
		// System.out.println(b);
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

	public int Int(String value) throws NumberFormatException {
		// rounds down
		return (int) Math.floor(Double.parseDouble(value));
	}

	public static boolean Islogical(String value) {
		return value.toLowerCase().equals("true")
				|| value.toLowerCase().equals("false");
	}

	public static boolean Iseven(String value) throws NumberFormatException {
		return Double.parseDouble(value) % 2 == 0;
	}

	public static boolean Isnumber(String value) {
		try { 
	        Double.parseDouble(value); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
	//TODO: LOWER

	public static void main(String[] args) {
		/*
		 * System.out.println(Iseven(1)); System.out.println(Iseven(2));
		 * System.out.println(Iseven(1337));
		 */
		/*
		 * System.out.println(Islogical("FALSE"));
		 * System.out.println(Islogical("\"FALSE\""));
		 */
		// double[] array1 = {2.5, 8.43, 1337.0, 1009.29};
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
