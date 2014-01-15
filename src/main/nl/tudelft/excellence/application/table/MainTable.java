package nl.tudelft.excellence.application.table;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.Container;

public class MainTable extends JTable {

    public MainTable(TableModel dataModel, Container container) {
        super(dataModel);

	    JScrollPane scrollPane = new JScrollPane(this);
	    JTable rowTable = new RowNumberTable(this);
	    scrollPane.setRowHeaderView(rowTable);
	    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER,
			    rowTable.getTableHeader());

	    this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	    container.add(scrollPane);

	    this.setDefaultEditor(Object.class, new MainCellEditor(SpreadSheet.current));
    }
}
