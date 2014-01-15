package nl.tudelft.excellence.spreadsheet;
import nl.tudelft.excellence.exceptions.SaveNotNeededException;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.utilities.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.SortedMap;


public class SpreadSheet {
	public static final int MAX_ROWS = 25;
	public static final int MAX_COLUMNS = 15;
	public static SpreadSheet current;
	private final SortedMap<CellCoord, Cell> sheet;
	private boolean unsavedChanges = false;
	
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
	public Cell getCell(int column, int row){
		return getCell(new CellCoord(column, row));
	}
	
	/**
	 * Get the Cell object on a given CellCoordinate (synchronizes on sheet)
	 * @param coord The Coordinate of the Cell to retrieve
	 * @return The Cell at the requested CellCoord
	 */
	public Cell getCell(CellCoord coord){
		if(coord.isValid()){
			synchronized(sheet){
				return sheet.get(coord);
			}
		}
		return null;
	}

	public Cell[] getCells(String from, String to) {
		ArrayList<Cell> cellArrayList = new ArrayList<>();
		CellCoord fromCoord = new CellCoord(from);
		CellCoord toCoord = new CellCoord(to);
		if (fromCoord.isValid() && toCoord.isValid()) {
			int fromCollumn = fromCoord.getColumn();
			int fromRow = fromCoord.getRow();
			int toCollumn = toCoord.getColumn();
			int toRow = toCoord.getRow();

			for (int col = fromCollumn; col <= toCollumn; col++) {
				for (int row = fromRow; row <= toRow; row++) {
					cellArrayList.add(this.getCell(col, row));
				}
			}
		} else return null;

		Cell[] cells = new Cell[cellArrayList.size()];
		for (int i = 0; i < cellArrayList.size(); i++) {
			cells[i] = cellArrayList.get(i);
		}

		return cells;
	}
	
	/**
	 * Put the Cell at the given CellCoord (synchronizes on sheet)
	 * Overrides a Cell if one was already present at CellCoord
	 * @param coord The Coordinate to put the Cell at
	 * @param cell The Cell to put at the requested CellCoord
	 */
	public void putCell(CellCoord coord, Cell cell){
		if(coord.isValid()){
			synchronized(sheet){
				sheet.put(coord, cell);
				unsavedChanges = true;
			}
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
	 * @throws SaveNotNeededException When it wasn't necessary to save the spreadsheet
	 */
	public boolean saveToFile(String fileName) throws SaveNotNeededException {
		return saveToFile(fileName, false);
	}

	/**
	 * Save the SpreadSheet to the output file
	 * @param fileName The name of/path to the file to save to
	 * @param forceSave Save even if there are no unsaved changes.
	 * @return Whether or not the file was successfully saved
	 * @throws SaveNotNeededException When it wasn't necessary and forceSave is false to save the spreadsheet
	 */
	public boolean saveToFile(String fileName, boolean forceSave) throws SaveNotNeededException{
		if(!forceSave && !unsavedChanges){
			throw new SaveNotNeededException(fileName);
		}
		
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
		;
		
		return !(unsavedChanges = !FileManager.saveToFile(file, this.serialize()));
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

    public int getRowCount(){
        try{
            return sheet.lastKey().getRow();
        } catch (NoSuchElementException e){
            return 1;
        }
    }

    public int getColumnCount(){
        int count = 1;
        for(CellCoord c: sheet.keySet()){
            if(c.getColumn()>count)
                count = c.getColumn();
        }
        return count;
    }
    
    public boolean hasUnsavedChanges(){
    	return unsavedChanges;
    }
}
