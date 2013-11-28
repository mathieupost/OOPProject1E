package nl.tudelft.excellence.spreadsheet;
import java.io.File;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.utilities.FileManager;


public class SpreadSheet {
	public static SpreadSheet current;
	private SortedMap<CellCoord, Cell> sheet;
	
	public SpreadSheet(SortedMap<CellCoord, Cell> sheet) {
		this.sheet = Collections.synchronizedSortedMap(sheet);
	}
	
	public Cell getCell(CellCoord coord){
		synchronized(sheet){
			return sheet.get(coord);
		}
	}
	
	public SortedMap<CellCoord, Cell> getCells(CellCoord from, CellCoord to){
		//TODO Implement an efficient way to get a 'partial sheet'
		return new TreeMap<CellCoord, Cell>();
	}
	
	public static SpreadSheet openFile(String fileName){
		if(fileName==null){
			//TODO Report error to user in a proper way. (FI: by throwing a (custom) exception)
			System.out.println("File Name should not be null, what are you even trying to do?");
			return null;
		}
		
		
		
		File file = new File(fileName);
		if(!file.exists() || !file.canRead()){
			//TODO Report problem to the user.
		}

		return FileManager.parseXML(file);
	}
	
	public boolean saveToFile(String fileName){
		if(fileName==null){
			//TODO Report error to user in a proper way. (FI: by throwing a (custom) exception)
			System.out.println("File Name should not be null, what are you even trying to do?");
			return false;
		}
		
		
		
		File file = new File(fileName);
		file.mkdirs();
		if(!file.canWrite()){
			//TODO Report problem to the user.
			return false;
		}
		
		return FileManager.saveToFile(file, this.serialize());
	}
	
	public String serialize(){
		String result = "<?xml version=\"1.0\"?>\n<SPREADSHEET>\n";
		for(Entry<CellCoord, Cell> entry: sheet.entrySet()){
			result += "\t<CELL "+entry.getKey().serialize()+">\n";
			result += "\t"+entry.getValue().serialize()+"\n";
			result += "\t</CELL>\n";
		}
		return result + "</SPREADSHEET>";		
	}
	
	public String toString(){
		String result = "SpreadSheet toString output:\n==============================================\n";
		for(Entry<CellCoord, Cell> cell: sheet.entrySet()){
			result += "Coord:\t(" + cell.getKey().getColumn() + ", " + cell.getKey().getRow() + ")\n";
			result += "Content:\t'" + cell.getValue().getRawData() + "'\n\n";
		}
		return result;
	}

}
