package nl.tudelft.excellence.application.table;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainTable extends JTable {

    public MainTable(TableModel dataModel) {
        super(dataModel);
    }
}
