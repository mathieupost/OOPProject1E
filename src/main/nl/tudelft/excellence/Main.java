package nl.tudelft.excellence;
import java.util.HashMap;
import java.util.Map.Entry;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.Utility;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Class<? extends Object/*Function*/>> banaan = Utility.getFunctions();
		for(Entry<String, Class<? extends Object>> c: banaan.entrySet()){
			System.out.println(c.getKey());
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
