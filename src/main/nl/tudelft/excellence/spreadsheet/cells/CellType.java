package nl.tudelft.excellence.spreadsheet.cells;

import java.util.HashMap;

public enum CellType {
	NUMBER(NumberCell.class),
	STRING(StringCell.class),
	FUNCTION(FunctionCell.class);
	
	private static HashMap<String, CellType> NAME_MAP = new HashMap<String, CellType>();
	private static HashMap<Class<? extends Cell>, CellType> CLASS_MAP = new HashMap<Class<? extends Cell>, CellType>();
	private Class<? extends Cell> c;
	
	static {
		for(CellType type: CellType.values()){
			NAME_MAP.put(type.toString(), type);
			CLASS_MAP.put(type.c, type);
		}
	}
	
	private CellType(Class<? extends Cell> c){
		this.c = c;
	}
	
	/**
	 * Get the CellType from a String containing the name (<b>not</b> case sensitive)
	 * @param name The Name of the CellType
	 * @return The CellType belonging to name
	 */
	public static CellType fromName(String name) {
		return NAME_MAP.get(name.toUpperCase());
	}
	
	/**
	 * Get the CellType from a Class that extends Cell
	 * @param cl The Class to get the CellType of
	 * @return The CellType linked to cl
	 */
	public static CellType fromClass(Class<? extends Cell> cl){
		return CLASS_MAP.get(cl);
	}
}
