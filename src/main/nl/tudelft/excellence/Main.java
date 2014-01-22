package nl.tudelft.excellence;

import nl.tudelft.excellence.application.MainWindow;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;

import javax.swing.*;

public class Main {
    public static MainWindow app;
	static{
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Excellence");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
        SpreadSheet.current = new SpreadSheet();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app = new MainWindow();
                app.setVisible(true);
            }
        });
    }

}
