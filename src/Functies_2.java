
public class Functies_2 {

	public static void main(String[] args) {
		System.out.println(Sum(3,4));
		System.out.println(Sqrt(2));
		System.out.println(Sign(30));
		System.out.println(Sign(0));
		System.out.println(Sign(-30));
		System.out.println(Roundup(4.2453475, 5));

	}
	
	public static double Sumif(){
		return 0.0;
	}
	
	public static double Sum(double a, double b){
		return a + b;
	}
	
	public static double Sqrt(double x){
		return Math.sqrt(x);
	}
	
	public static double Sign(double x){
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
	
	public static double Roundup(double x, int digits){
		double round = Math.pow(10, digits);
		return (double)Math.round(x * round)/round;
	}

}
