
public class Functies {

	public static void main(String[] args) {
		System.out.println(sum(3,4));
		System.out.println(sqrt(2));
		System.out.println(sign(30));
		System.out.println(sign(0));
		System.out.println(sign(-30));
		System.out.println(roundUp(47587.2453475, 4));
		System.out.println(roundDown(47587.2453475, -1));
		System.out.println(proper("hAllo ik ben Wilbert"));

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
		
		/*TODO:
		sumIf
		product
		power
		or
		not
		mod
		min*/


}
