package nl.tudelft.excellence.spreadsheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.utilities.FileManager;

import java.io.File;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedMap;


public class SpreadSheet {
	public static SpreadSheet current;
	private final SortedMap<CellCoord, Cell> sheet;
	
	/**
	 * Create a new SpreadSheet object with sheet as (base) structure
	 * @param sheet A Map of cell coordinates and cells that make up the spreadsheet.
	 */
	public SpreadSheet(SortedMap<CellCoord, Cell> sheet) {
		this.sheet = Collections.synchronizedSortedMap(sheet);
	}
	
	/**
	 * Get the Cell object at a given postion (synchronizes on sheet)
	 * @param column The column of the Cell
	 * @param row The row of the Cell
	 * @return The Cell at the requested position
	 */
	public Cell getCell(long column, long row){
		return getCell(new CellCoord(column, row));
	}
	
	/**
	 * Get the Cell object on a given CellCoordinate (synchronizes on sheet)
	 * @param coord The Coordinate of the Cell to retrieve
	 * @return The Cell at the requested CellCoord
	 */
	public Cell getCell(CellCoord coord){
		synchronized(sheet){
			return sheet.get(coord);
		}
	}
	
	/**
	 * Put the Cell at the given CellCoord (synchronizes on sheet)
	 * Overrides a Cell if one was already present at CellCoord
	 * @param coord The Coordinate to put the Cell at
	 * @param cell The Cell to put at the requested CellCoord
	 */
	public void putCell(CellCoord coord, Cell cell){
		synchronized(sheet){
			sheet.put(coord, cell);
		}
	}
	
	/**
	 * Build a SpreadSheet object by parsing an input file
	 * @param fileName The name of/path to the file to read
	 * @return A new SpreadSheet object parsed from the file
	 */
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
	
	/**
	 * Save the SpreadSheet to the output file
	 * @param fileName The name of/path to the file to save to
	 * @return Whether or not the file was successfully saved
	 */
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
	
	/**
	 * Get a serialized version of this SpreadSheet that can be parsed to a SpreadSheet object
	 * @return A String representation of this SpreadSheet
	 */
	public String serialize(){
		String result = "<?xml version=\"1.0\"?>\n<SPREADSHEET>\n";
		for(Entry<CellCoord, Cell> entry: sheet.entrySet()){
			result += "\t<CELL "+entry.getKey().serialize()+">\n";
			result += "\t"+entry.getValue().serialize()+"\n";
			result += "\t</CELL>\n";
		}
		return result + "</SPREADSHEET>";		
	}

    @Override
    public boolean equals(Object other){
        if(this==other)
            return true;

        if(other==null || !(other instanceof SpreadSheet))
            return false;

        SpreadSheet that = (SpreadSheet) other;
        if(this.sheet.size()!=that.sheet.size())
            return false;

        for(Entry<CellCoord, Cell> entry: this.sheet.entrySet()){
            if(!(that.sheet.containsKey(entry.getKey()) && entry.getValue().equals(that.sheet.get(entry.getKey())))){
                return false;
            }
        }
        return true;
    }

	@Override
	public String toString(){
		String result = "SpreadSheet toString output:\n==============================================\n";
		for(Entry<CellCoord, Cell> cell: sheet.entrySet()){
			result += "Coord:\t(" + cell.getKey().getColumn() + ", " + cell.getKey().getRow() + ")\n";
			result += "Content:'" + cell.getValue().getRawData() + "'\n\n";
		}
		return result;
    }
}
