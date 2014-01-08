package nl.tudelft.excellence.application;

import nl.tudelft.excellence.application.table.MainTable;
import nl.tudelft.excellence.application.table.RowNumberTable;
import nl.tudelft.excellence.application.table.model.MainDataModel;
import nl.tudelft.excellence.exceptions.SaveNotNeededException;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.JOptionPane.*;

public class MainWindow extends JFrame{
    private String fileName;
       public MainWindow(String fileName){
           this.fileName = fileName;
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
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));
        fileNew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                
            }
        });

        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK));

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));
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
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                ActionEvent.CTRL_MASK));

        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
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

        setIconImages(new ArrayList<>(Arrays.asList(new Image[]{new ImageIcon(getClass().getResource("excellence-icon-small.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-medium.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-large.png")).getImage(), new ImageIcon(getClass().getResource("excellence-icon-256.png")).getImage()})));
                setTitle("Excellence - Alpha 0.1");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
