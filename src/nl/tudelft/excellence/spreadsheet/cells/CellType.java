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
	
	public static CellType fromName(String name) {
		return NAME_MAP.get(name.toUpperCase());
	}
	
	public static CellType fromClass(Class<? extends Cell> cl){
		return CLASS_MAP.get(cl);
	}
}
