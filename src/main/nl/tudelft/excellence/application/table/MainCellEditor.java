package nl.tudelft.excellence.application.table;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;

import javax.swing.*;
import java.awt.*;

public class MainCellEditor extends DefaultCellEditor {
    public MainCellEditor(){
        super(new JTextField());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        String rawData = null;
        if(SpreadSheet.current!=null){
            Cell cell = SpreadSheet.current.getCell(column+1, row+1); //Increment coords as JTable uses 0-indexed coordinates
            if(cell != null){
                rawData = cell.getRawData();
            }
        }
        value = rawData!=null ? rawData : value;
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }
}