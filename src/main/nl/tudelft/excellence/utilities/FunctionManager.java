package nl.tudelft.excellence.utilities;

import java.util.HashMap;

public class FunctionManager {
	private static HashMap<String, Class<? extends Object/*Function*/>> functionList = new HashMap<String, Class<? extends Object/*Function*/>>();
	
	static{
		functionList = Utility.getFunctions();
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Class<? extends Object/*Function*/> getFunctionByName(String name){
		return functionList.get(name/*.toUpperCase()*/);
	}
	
	
	
}
