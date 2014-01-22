package nl.tudelft.excellence.application.table;

import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.*;

import javax.swing.table.AbstractTableModel;

public class MainDataModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private SpreadSheet sheet;
	
	public MainDataModel(SpreadSheet sheet){
		this.sheet = sheet;
	}
	
	@Override
	public int getRowCount() {
		return SpreadSheet.MAX_ROWS;
	}

	@Override
	public int getColumnCount() {
		return SpreadSheet.MAX_COLUMNS;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		++rowIndex; ++columnIndex; //Increment as JTable uses 0-indexed coordinates
		CellCoord coord = new CellCoord(columnIndex, rowIndex);
		if(sheetNotNull() && coord.isValid()){
			Cell cell = sheet.getCell(coord);
			if(cell!=null){
				return cell.getData();
			}
		}
		return "";
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		++rowIndex; ++columnIndex; //Increment as JTable uses 0-indexed coordinates
		CellCoord coord = new CellCoord(columnIndex, rowIndex);
		if(sheetNotNull() && coord.isValid() && aValue!=null && aValue instanceof String){
			String data = (String) aValue;
			if(data.length()==0){
				sheet.removeCell(coord);
			} else {
				Cell cell = sheet.getCell(coord);
				if(cell==null || !cell.getRawData().equals(data)){
					if (data.startsWith("=") && data.length()>1) {
						sheet.putCell(coord, new FunctionCell(data));
					} else {
						try {
							double number = Double.parseDouble(data);
							sheet.putCell(coord, new NumberCell(number));
						} catch (NumberFormatException e) {
							sheet.putCell(coord, new StringCell(data));
						}
					}
				}
			}
			this.fireTableDataChanged();
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return true;
	}
	
	private boolean sheetNotNull(){
		return sheet!=null || (sheet = SpreadSheet.current)!=null;
	}

	public void updateSpreadSheet(){
		sheet = SpreadSheet.current;
	}
}
