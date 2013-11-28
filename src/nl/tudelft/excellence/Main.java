package nl.tudelft.excellence;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.Utility;

public class Main {

	public static void main(String[] args) {
		String fileName = "";
		if(args.length>0){
			fileName = args[0];
		} else {
			System.out.println("Input file:");
			fileName = Utility.askString();
			if (fileName.equals("1")) fileName = "assets/spreadsheet.xml";
		}
		SpreadSheet.current = SpreadSheet.openFile(fileName);
		
		System.out.println(SpreadSheet.current.toString());
		
		System.out.println("\nSave again?");
		if(Utility.askConfirmation()){
			SpreadSheet.current.saveToFile(fileName);
		}
	}
	
	
}
