package nl.tudelft.excellence.application;

import nl.tudelft.excellence.application.table.MainDataModel;
import nl.tudelft.excellence.application.table.MainTable;
import nl.tudelft.excellence.exceptions.SaveNotNeededException;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.utilities.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class MainWindow extends JFrame{
    private static String fileName;
	private final int MODIFIER = Utility.getOS().equals("MAC") ? ActionEvent.META_MASK : ActionEvent.CTRL_MASK;
	private MainTable mainTable;
	private static MainWindow current;

	public MainWindow(){
		this(null);
	}

	public MainWindow(String fileName){
		current = this;
		MainWindow.fileName = fileName;
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
		fileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SpreadSheet.current!=null && SpreadSheet.current.hasUnsavedChanges()){
					if(MainWindow.onCloseSpreadsheet()){
						SpreadSheet.current = new SpreadSheet();
						mainTable.updateSpreadSheet();
						updateTitle();
					}
				}
			}
		});

        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, MODIFIER));
	    fileOpen.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event){
				File file = Utility.chooseFile(JFileChooser.OPEN_DIALOG);
			    if(file!=null){
				    fileName = file.getAbsolutePath();
					SpreadSheet.current = SpreadSheet.openFile(fileName);
				    mainTable.updateSpreadSheet();
				    updateTitle();
			    }
		    }
	    });

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, MODIFIER));
        fileSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(SpreadSheet.current!=null){
	                if(fileName==null || fileName.length()==0){
						File file = Utility.chooseFile(JFileChooser.SAVE_DIALOG);
		                if(file!=null){
			                fileName = file.getAbsolutePath();
		                } else {
			                return;
		                }
	                }
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
        
        JMenuItem fileSaveAs = new JMenuItem("Save As");
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, MODIFIER + ActionEvent.SHIFT_MASK));
        fileSaveAs.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
		        if (SpreadSheet.current != null) {
			        File file = Utility.chooseFile(JFileChooser.SAVE_DIALOG);
			        if(file!=null){
				        fileName = file.getAbsolutePath();
			        } else {
				        return;
			        }
			        try {
				        if (SpreadSheet.current.saveToFile(fileName, true)) {
					        showMessageDialog(null, "Successfully saved '" + fileName + "'", "", PLAIN_MESSAGE);
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
			    if(MainWindow.onCloseSpreadsheet())
				    System.exit(0);
		    }
	    });

	    this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
			    if(MainWindow.onCloseSpreadsheet())
				    System.exit(0);
		    }
	    });

        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileSaveAs);
        file.addSeparator();
        file.add(fileExit);

        menuBar.add(file);

        setJMenuBar(menuBar);

        /** Table - Body **/
        mainTable = new MainTable(new MainDataModel(SpreadSheet.current), getContentPane());

        setIconImages(new ArrayList<>(Arrays.asList(new Image[]{new ImageIcon(getClass().getResource("excellence-icon-small.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-medium.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-large.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-256.png")).getImage()})));
        updateTitle();
        setSize(750, 500);
        setLocationRelativeTo(null);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

	private static boolean onCloseSpreadsheet(){
		if(SpreadSheet.current!=null && SpreadSheet.current.hasUnsavedChanges()){
			Object[] options = {"Yes", "No", "Cancel"};
			int n = showOptionDialog(null,
					"Do you want to save changes"+(fileName==null || fileName.length()==0?"":" you made to " + fileName.substring(fileName.lastIndexOf("/") + 1)) + "?",
					"Excellence",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE,
					new ImageIcon(MainWindow.class.getResource("excellence-icon-medium.png")),
					options,
					options[2]);
			switch(n){
				case 0:
					if(fileName==null || fileName.length()==0){
						File file = Utility.chooseFile(JFileChooser.SAVE_DIALOG);
						if(file!=null){
							fileName = file.getAbsolutePath();
						} else {
							return false;
						}
					}
					try {
						if(SpreadSheet.current.saveToFile(fileName)){
							showMessageDialog(null, "Successfully saved '"+fileName+"'", "", INFORMATION_MESSAGE);
							return true;
						} else {
							showMessageDialog(null, "An error occurred during saving, please try again.", "Save failed!", ERROR_MESSAGE);
						}
					} catch (SaveNotNeededException ignore) {}
					break;
				case 1:
					return true;
				default:
					return false;
			}
		}
		return true;
	}

	public static void updateTitle(){
		boolean unsavedChanges = false;
		if(current!=null){
			if(SpreadSheet.current!=null && SpreadSheet.current.hasUnsavedChanges()){
				unsavedChanges = true;
			}
			current.setTitle("Excellence "+(unsavedChanges?"*":""));
		}
	}
}
