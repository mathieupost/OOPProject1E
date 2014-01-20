package nl.tudelft.excellence.application.table;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

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

	    this.setDefaultEditor(Object.class, new MainCellEditor());
    }

	public void updateSpreadSheet(){
		if(this.dataModel instanceof MainDataModel){
			MainDataModel model = ((MainDataModel) this.dataModel);
			model.updateSpreadSheet();
			model.fireTableDataChanged();
		}
	}
}
