package nl.tudelft.excellence.utilities;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utility {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Asks the user a String that has to be on of the possible options
	 * @param options The options the user is able to input
	 * @return One of the String options chosen by the user
	 */
	public static String askString(String... options){
		String result = null;
		List<String> optList = Arrays.asList(options);
		String error = "Ongeldige invoer.";
		if(optList.size()>0){
			error += " De mogelijk opties zijn: (";
			for(String opt: optList){
				error += opt+"/";
			}
			error = error.substring(0, error.length()-1) + ")";
		}
		while(result==null){
			try{
				result = sc.next();
			} catch (InputMismatchException e){
				sc.nextLine();
				System.out.println(error);
				result = null;
				continue;
			}
			if(optList.size()>0 && !optList.contains(result)){
				System.out.println(error);
				result = null;
			}
		}
		return result;
	}
	
	/**
	 * Confirm for instance if the user wants to proceed with something.
	 * <b>Note:</b> This is the same as calling askString("y", "n") and checking if the answer is "y"
	 * @return Whether or not the user wants to proceed/agrees
	 */
	public static boolean askConfirmation(){
		return askString("y", "n").equals("y");
	}
	
	/**
	 * Get an array of all the Function classes available
	 * @return The array of Function classes
	 */
	public static HashMap<String, Class<? extends Object/*Function*/>> getFunctions(){ //TODO Change result to Function Classes Array
		HashMap<String, Class<? extends Object/*Function*/>> functionList = new HashMap<String, Class<? extends Object/*Function*/>>();
		try {
			for(Class<? extends Object/*Function*/> c: getClasses("nl.tudelft.excellence.functions")){
				functionList.put(c.getSimpleName(), c);
			}
		} catch (ClassNotFoundException | IOException e) {}
		return functionList;
	}
	
	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static ArrayList<Class<? extends Object>> getClasses(String packageName)
	        throws ClassNotFoundException, IOException {
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    assert classLoader != null;
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    ArrayList<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();
	    for (File directory : dirs) {
	        classes.addAll(findClasses(directory, packageName));
	    }
	    return classes;
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private static List<Class<? extends Object>> findClasses(File directory, String packageName) throws ClassNotFoundException {
	    List<Class<? extends Object>> classes = new ArrayList<Class<? extends Object>>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        } else if (file.getName().endsWith(".class") && !file.getName().matches("(Test|Function).class")) {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}
	
	/**
	 * Get if a String is a number or not
	 * @param in The input to check
	 * @return Whether or not the input is a number
	 */
	public static boolean isNumber(String in){
		try{
			Double.parseDouble(in);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	/**
	 * Get if a String is a boolean or not
	 * @param in The input to check
	 * @return Whether or not the input is a boolean
	 */
	public static boolean isBoolean(String in){
		try{
			Boolean.parseBoolean(in);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
}
