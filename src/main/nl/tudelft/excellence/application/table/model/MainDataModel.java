package nl.tudelft.excellence.application.table.model;

import javax.swing.table.AbstractTableModel;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.spreadsheet.cells.FunctionCell;
import nl.tudelft.excellence.spreadsheet.cells.NumberCell;
import nl.tudelft.excellence.spreadsheet.cells.StringCell;

public class MainDataModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private SpreadSheet sheet;
	
	public MainDataModel(SpreadSheet sheet){
		this.sheet = sheet;
	}
	
	@Override
	public int getRowCount() {
		return sheetNotNull()?sheet.getRowCount():1;
	}

	@Override
	public int getColumnCount() {
		return sheetNotNull()?sheet.getColumnCount():1;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		++rowIndex; ++columnIndex; //Increment as JTable uses 0-indexed coordinates
		CellCoord coord = new CellCoord(columnIndex, rowIndex);
		if(sheetNotNull() && coord.isValid()){
			return sheet.getCell(coord).getData();
		}
		return "";
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		++rowIndex; ++columnIndex; //Increment as JTable uses 0-indexed coordinates
		CellCoord coord = new CellCoord(columnIndex, rowIndex);
		if(sheetNotNull() && coord.isValid() && aValue!=null && aValue instanceof String){
			String data = (String) aValue;
			Cell cell = sheet.getCell(coord), newCell;
			if(cell!=null && !cell.getRawData().equals(data)){
				
				if (data.startsWith("=") && data.length()>1) {
					sheet.putCell(coord, newCell = new FunctionCell(data));
				} else {
					try {
						double number = Double.parseDouble(data);
						sheet.putCell(coord, newCell = new NumberCell(number));
					} catch (NumberFormatException e) {
						sheet.putCell(coord, newCell = new StringCell(data));
					}
				}
				cell.notifyObservers(newCell);
			}
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return true;
	}
	
	private boolean sheetNotNull(){
		return sheet!=null || (sheet = SpreadSheet.current)!=null;
	}
}