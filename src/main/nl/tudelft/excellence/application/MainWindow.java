package nl.tudelft.excellence.application;

import nl.tudelft.excellence.application.table.MainCellEditor;
import nl.tudelft.excellence.application.table.MainDataModel;
import nl.tudelft.excellence.application.table.MainTable;
import nl.tudelft.excellence.application.table.RowNumberTable;
import nl.tudelft.excellence.exceptions.SaveNotNeededException;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.Utility;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class MainWindow extends JFrame{
    private static String fileName;
	private final int MODIFIER = Utility.getOS().equals("MAC") ? ActionEvent.META_MASK : ActionEvent.CTRL_MASK;
       public MainWindow(String fileName){
           MainWindow.fileName = fileName;
           System.setProperty("apple.laf.useScreenMenuBar", "true");
           System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Excellence");
           try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
               e.printStackTrace();
           }
           buildUI();
       }

    private void buildUI() {
        /** Menu Toolbar **/
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem fileNew = new JMenuItem("New");
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, MODIFIER));


        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, MODIFIER));

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, MODIFIER));
        fileSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(SpreadSheet.current!=null){
                    try {
						if(SpreadSheet.current.saveToFile(fileName)){
						    showMessageDialog(null, "Successfully saved '"+fileName+"'", "", PLAIN_MESSAGE);
						} else {
						    showMessageDialog(null, "An error occurred during saving, please try again.", "Save failed!", ERROR_MESSAGE);
						}
					} catch (SaveNotNeededException ignore) {}
                }
            }
        });

        JMenuItem fileExit = new JMenuItem("Exit"/*, iconExit*/);
        fileExit.setMnemonic(KeyEvent.VK_C);
        fileExit.setToolTipText("Exit application");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, MODIFIER));
	    fileExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
			    MainWindow.onExit();
		    }
	    });

	    this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
			    MainWindow.onExit();
		    }
	    });

        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        file.addSeparator();
        file.add(fileExit);

        menuBar.add(file);

        setJMenuBar(menuBar);

        /** Table - Body **/
        TableModel dataModel = new MainDataModel(SpreadSheet.current);

        MainTable mainTable = new MainTable(dataModel);
        JScrollPane scrollPane = new JScrollPane(mainTable);
        JTable rowTable = new RowNumberTable(mainTable);
        scrollPane.setRowHeaderView(rowTable);
        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
                rowTable.getTableHeader());

        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        getContentPane().add(scrollPane);

	    mainTable.setDefaultEditor(Object.class, new MainCellEditor(SpreadSheet.current));

        setIconImages(new ArrayList<>(Arrays.asList(new Image[]{new ImageIcon(getClass().getResource("excellence-icon-small.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-medium.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-large.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-256.png")).getImage()})));
                setTitle("Excellence - Alpha 0.1");
        setSize(600, 400);
        setLocationRelativeTo(null);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

	private static void onExit(){
		if(SpreadSheet.current!=null && SpreadSheet.current.hasUnsavedChanges()){
			Object[] options = {"Yes", "No", "Cancel"};
			int n = showOptionDialog(null,
					"Do you want to save changes you made to " + fileName.substring(fileName.lastIndexOf("/") + 1) + "?",
					"Excellence",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE,
					new ImageIcon(MainWindow.class.getResource("excellence-icon-medium.png")),
					options,
					options[2]);
			switch(n){
				case 0:
					try {
						if(SpreadSheet.current.saveToFile(fileName)){
							showMessageDialog(null, "Successfully saved '"+fileName+"'", "", INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							showMessageDialog(null, "An error occurred during saving, please try again.", "Save failed!", ERROR_MESSAGE);
						}
					} catch (SaveNotNeededException ignore) {}
					break;
				case 1:
					System.exit(0);
					break;
				default:
			}
		} else {
			System.exit(0);
		}
	}
}
