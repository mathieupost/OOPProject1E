
public class Functies_2 {

	public static void main(String[] args) {
		System.out.println(Sum("3","4"));
		System.out.println(Sqrt("2"));
		System.out.println(Sign("30"));
		System.out.println(Sign("0"));
		System.out.println(Sign("-30"));
		System.out.println(Roundup("47587.2453475", "0"));

	}
	
	public static double Sumif(){
		return 0.0;
	}
	
	public static double Sum(String a, String b){
		double c = Double.parseDouble(a);
		double d = Double.parseDouble(b);
		return c + d;
	}
	
	public static double Sqrt(String x){
		double a = Double.parseDouble(x);
		return Math.sqrt(a);
	}
	
	public static double Sign(String x){
		double a = Double.parseDouble(x);
		if(a > 0.0){
			return 1.0;
		}
		
		else if(a == 0.0){
			return 0.0;
		}
		
		else{
			return -1.0;
		}
	}
	
	public static double Roundup(String x, String digits){
		double a = Double.parseDouble(x);
		double b = Double.parseDouble(digits);
		double round = Math.pow(10, b);
		return (double)Math.round(a * round)/round;
	}
	
	public static double Rounddown(String x, String digits){
		double a = Double.parseDouble(x);
		double b = Double.parseDouble(digits);
		double round = Math.pow(10, b);
		return (double)Math.round(a * round)/round;
		
	}

}
