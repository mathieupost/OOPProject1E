
public class Functies {

	public static void main(String[] args) {
		/*System.out.println(sum(3,4));
		System.out.println(sqrt(2));
		System.out.println(sign(30));
		System.out.println(sign(0));
		System.out.println(sign(-30));
		System.out.println(roundUp(47587.2453475, 4));
		System.out.println(roundDown(47587.2453475, -1));
		System.out.println(proper("hAllo ik ben Wilbert"));
		System.out.println(isEven(2.9999));*/
		System.out.println(median(3,5,10,15));

	}

	/**
	 * Takes a series of doubles and calculates the arithmetic mean
	 * At least one double is required
	 * @param a 1st double to be used in calculation
	 * @param values other doubles to be used in calculation
	 * @return the mean of given doubles
	 */
	public static double average(double a, double... values){
		double res = a;
		for (int i = 0; i < values.length; i++) {
			res = (res + values[i]);
		}
		res /= (values.length+1);
		return res;
	}

	// TODO: Implement when working with cell coördinates
	/**
	 * Counts how many cells in a given range contain numbers
	 * @return how many cells in a given range contain numbers
	 */
	public static int count() {
		int res = 0;
		return res;
	}

	// TODO: Implement when working with cell coördinates
	/**
	 * Count how many cells in a given range are not empty
	 * @return how many cells in a given range are not empty
	 */
	public static int countA() {
		int res = 0;
		return res;
	}

	// TODO: Implement when working with cell coordinates
	/**
	 * Count how many cells in a given range meet a given logical condition
	 * @return how many cells in a given range meet a given logical condition
	 */
	public static int countIf() {
		int res = 0;
		return res;
	}

	/**
	 * Converts a String into a logical condition and tests that condition
	 * Returns a given String if the test returns true, returns another given String if the test returns false
	 * @param logictest String representation of a logical condition, e.g. "1 < 2" or "6 = 6"
	 * @param iftrue String which is to be returned if the logical condition returns true
	 * @param iffalse String which is to be returned if the logical condition returns false
	 * @return
	 */
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

	/**
	 * Rounds a double down and converts that to an integer
	 * @param value double to be rounded down
	 * @return result of the rounded down double
	 */
	public int makeInt(double value){		
		return (int) Math.floor(value);
	}

	/**
	 * Checks if a given String is a representation of a logical value
	 * @param String wich is to be checked
	 * @return value true if String is "true","false","TRUE","FALSE" or a variation of uppercase and lowercase. Returns false if the String is anything else
	 */
	//TODO: implement other types of logical expressions, e.g. "4>5"
	public static boolean isLogical(String value) {
		return value.toLowerCase().equals("true")
				|| value.toLowerCase().equals("false");
	}
	
	/**
	 * Checks if a given double is an even number
	 * @param value double which is to be checked
	 * @return true if given double is an even number, false if it is uneven
	 */
	public static boolean isEven(double value){
		return (int) value % 2 == 0;
	}

	/**
	 * Checks if a given String is a number
	 * @param value the String which is to be checked
	 * @return true if String is representative of a number, false if it is not
	 */
	public static boolean isNumber(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Converts a String into all lowercase letters
	 * @param value String which is to be converted
	 * @return converted String, in all lowercase
	 */
	public static String lower(String value) {
		return value.toLowerCase();
	}

	// TODO: ignores logical values and text
	/**
	 * Calculates the maximum value of a given number of doubles
	 * @param a the first double
	 * @param values the rest of the doubles
	 * @return maximum of given doubles
	 */
	public static Double max(double a, double... values) {
		double res = a;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > res) {
				res = values[i];
			}
		}
		return res;
	}

	/**
	 * Takes a series of doubles and calculates the arithmetic median
	 * @param values series of Double to be used in calculation
	 * @return arithmetic median of given series of doubles
	 */
	public static double median(double... values){
		double res = 0;
		if(values.length %2==0){
			int a = (int) values.length/2-1;
			int b = (int) values.length/2;
			res = (values[a]+values[b])/2;
		}
		else if(values.length %2 != 0){
			int a = (values.length-1)/2;
			res = values[a];
		}
		return res;
	}

	/**
	 * Returns the sum of double a and double b
	 * @param a 1st variable
	 * @param b 2nd variable
	 * @return sum
	 */
	public static double sum(double a, double b, double... values){
		double result = a + b;
		for(double value: values){
			result += value;
		}
		return result;
	}

	/**
	 * Returns the square root of double x
	 * @param x variable
	 * @return square root
	 */
	public static double sqrt(double x){
		return Math.sqrt(x);
	}

	/**
	 * Returns 1.0 when double x > 0, 0.0 when x = 0 and -1.0 when x < 0
	 * @param x variable
	 * @return sign
	 */
	public static double sign(double x){
		if(x > 0.0){
			return 1.0;
		}

		else if(x == 0.0){
			return 0.0;
		}

		else{
			return -1.0;
		}
	}

	/**
	 * Rounds up double x away from zero, at digits amount of digits
	 * @param x number
	 * @param digits amount of digits
	 * @return roundup x
	 */
	public static double roundUp(double x, double digits){
		x *= Math.pow(10, digits);
		x++;
		x = (int)x;
		x /= Math.pow(10, digits);
		return x;
	}

	/**
	 * Rounds down x to zero, at digits amount of digits
	 * @param x number
	 * @param digits amount of digits
	 * @return rounddown x
	 */
	public static double roundDown(double x, double digits){
		x *= Math.pow(10, digits);
		x = (int)x;
		x /= Math.pow(10, digits);
		return x;

	}
	/**
	 * Converts a text string to proper case; the first letter in each word in uppercase, and all other letters to lowercase.
	 * @param s input String
	 * @return proper case String
	 */
	public static String proper(String s){
		StringBuilder b = new StringBuilder(s.toLowerCase());
		int i = 0;
		do {
			b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
			i =  b.indexOf(" ", i) + 1;
		} while (i > 0 && i < b.length());
		return b.toString();
	}

	/**
	 * Multiplies all numbers given as arguments
	 * @param a 1st variable
	 * @param b 2nd variable
	 * @param values all other values
	 * @return product of all arguments
	 */
	public static double product(double a, double b, double... values){
		double result = a * b;
		for(double value: values){
			result *= value;
		}
		return result;
	}
	
	/**
	 * Returns a raised to the power b
	 * @param a base
	 * @param b exponent
	 * @return result
	 */
	public static double power(double a, double b){
		return Math.pow(a, b);
	}
	
	/**
	 * returns a mod b
	 * @param a number
	 * @param b divisor
	 * @return remainder
	 */
	public static double mod(double a, double b){
		return a%b;
	}
	
	/**
	 * 
	 * @param a
	 * @param values
	 * @return
	 */
	public static double min(double a, double... values){
		double min = a;
		for(double value: values){
			if(value < a){
				min = value;
			}
		}
		return min;
	}
	
	/*TODO:
	sumIf
	or
	not
	*/

}
