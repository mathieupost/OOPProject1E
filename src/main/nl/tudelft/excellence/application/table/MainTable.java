package nl.tudelft.excellence.application.table;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainTable extends JTable {

    public MainTable(TableModel dataModel) {
        super(dataModel);

        addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("tableCellEditor".equals(evt.getPropertyName())) {
                    if (isEditing())
                        processEditingStarted();
                    else
                        processEditingStopped();
                }
            }
        });
    }

    private void processEditingStarted(){
       //TODO Change function output to function source
    }

    private void processEditingStopped(){
       //TODO
    }
}
