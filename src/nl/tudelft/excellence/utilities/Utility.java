package nl.tudelft.excellence.utilities;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utility {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * Asks the user a String that has to be on of the possible options
	 * @param options The options the user is able to input
	 * @return One of the String options chosen by the user
	 */
	public static String askString(String... options){
		String result = null;
		List<String> optList = Arrays.asList(options);
		String error = "Ongeldige invoer.";
		if(optList.size()>0){
			error += " De mogelijk opties zijn: (";
			for(String opt: optList){
				error += opt+"/";
			}
			error = error.substring(0, error.length()-1) + ")";
		}
		while(result==null){
			try{
				result = sc.next();
			} catch (InputMismatchException e){
				sc.nextLine();
				System.out.println(error);
				result = null;
				continue;
			}
			if(optList.size()>0 && !optList.contains(result)){
				System.out.println(error);
				result = null;
			}
		}
		return result;
	}
	
	public static boolean askConfirmation(){
		return askString("y", "n").equals("y");
	}
}
