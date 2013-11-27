package nl.tudelft.excellence.spreadsheet;

import java.util.HashMap;

public enum CellDataType {
	NUMBER,
	STRING,
	FUNCTION;
	
	private static HashMap<String, CellDataType> NAME_MAP = new HashMap<String, CellDataType>();
	
	static {
		for(CellDataType type: CellDataType.values()){
			NAME_MAP.put(type.toString(), type);
		}
	}
	
	public static CellDataType fromName(String name) {
		return NAME_MAP.get(name.toUpperCase());
	}
}
