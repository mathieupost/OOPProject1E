package nl.tudelft.excellence;

import nl.tudelft.excellence.application.MainWindow;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.Utility;

import javax.swing.*;

public class Main {
    public static MainWindow app;

	public static void main(String[] args) {
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


        final String finalFileName = fileName;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app = new MainWindow(finalFileName);
                app.setVisible(true);
            }
        });
    }

}
