package nl.tudelft.excellence.application.table;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;

import javax.swing.*;
import java.awt.*;

public class MainCellEditor extends DefaultCellEditor {
    private SpreadSheet sheet;

    public MainCellEditor(SpreadSheet sheet){
        super(new JTextField());
        this.sheet = sheet;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        String rawData = null;
        if(sheetNotNull()){
            Cell cell = sheet.getCell(column+1, row+1); //Increment coords as JTable uses 0-indexed coordinates
            if(cell != null){
                rawData = cell.getRawData();
            }
        }
        value = rawData!=null ? rawData : value;
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    private boolean sheetNotNull(){
        return sheet!=null || (sheet = SpreadSheet.current)!=null;
    }
}