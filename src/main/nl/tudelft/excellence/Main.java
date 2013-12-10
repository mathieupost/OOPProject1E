package nl.tudelft.excellence;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.FunctionManager;
import nl.tudelft.excellence.utilities.Utility;

import java.lang.reflect.Constructor;

public class Main {

	public static void main(String[] args) {
		System.out.println("SUM constructors:");
		for(Constructor<?> c: FunctionManager.getFunctionByName("SUM").getConstructors()){
			System.out.println("String:\t\t" + c.toString());
            System.out.println("Accepts variable number of args: "+(c.isVarArgs()?"yes":"no"));
			for(Class<?> cl: c.getParameterTypes()){
				System.out.println(cl.getSimpleName());
			}
		}
		
		String fileName = "";
		if(args.length>0){
			fileName = args[0];
		} else {
			System.out.println("Input file:");
			fileName = Utility.askString();
			if (fileName.equals("1")) fileName = "assets/spreadsheet.xml";
			else if (fileName.equals("2")) fileName = "spreadsheet.xml";
		}
		SpreadSheet.current = SpreadSheet.openFile(fileName);
		
		System.out.println(SpreadSheet.current.toString());
		
		System.out.println("\nSave again?");
		if(Utility.askConfirmation()){
			SpreadSheet.current.saveToFile(fileName);
		}
	}
	
}
