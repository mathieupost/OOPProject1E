
public class Functies_1 {

	public Functies_1() {
		// TODO Auto-generated constructor stub
	}
	
	public double average(double[] values){
		double res = values[0];
		for(int i=1;i<values.length;i++){
			res = (res + values[i])/2;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(average)

	}

}
