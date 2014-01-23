package nl.tudelft.excellence.utilities;

import nl.tudelft.excellence.functions.Function;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Utility {
	private static final JFileChooser fc = new JFileChooser();

	static {
		fc.setFileFilter(new FileNameExtensionFilter("All Excellence files (*.xml, *.excellence)", "xml", "excellence"));
	}

	/**
	 * Get an array of all the Function classes available
	 *
	 * @return The array of Function classes
	 */
	public static HashMap<String, Class<? extends Function>> getFunctions() {
		HashMap<String, Class<? extends Function>> functionList = new HashMap<String, Class<? extends Function>>();
		try {
			for (Class<?> c : getClassesInPackage("nl.tudelft.excellence.functions", ".*(Test|Function)")) {
				if (Function.class.isAssignableFrom(c)) {
					functionList.put(c.getSimpleName(), c.asSubclass(Function.class));
				}
			}
		} catch (Exception ignored) {}
		return functionList;
	}



	/**
	 * Get if a String is a number or not
	 *
	 * @param in The input to check
	 * @return Whether or not the input is a number
	 */
	public static boolean isNumber(String in) {
		try {
			Double.parseDouble(in);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Get if a String is a boolean or not
	 *
	 * @param in The input to check
	 * @return Whether or not the input is a boolean
	 */
	public static boolean isBoolean(String in) {
		return in.equalsIgnoreCase("true") || in.equalsIgnoreCase("false");
	}


	public static String getOS() {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("os x")) {
			return "MAC";
		} else if (os.contains("win")) {
			return "WIN";
		}
		return "";
	}

	public static String getValue(String value) {
		CellCoord coord = new CellCoord(value);
		Cell cell = SpreadSheet.current.getCell(coord);
		if (cell != null)
			return cell.getData();
		return value;
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
	 * Adapted from http://snippets.dzone.com/posts/show/4831 and extended to support use of JAR files
	 *
	 * @param packageName The base package
	 * @param exclusionRegex an optional class name pattern.
	 * @return The classes
	 */
	public static Class[] getClassesInPackage(String packageName, String exclusionRegex) {
		Pattern regex = null;
		if (exclusionRegex != null) regex = Pattern.compile(exclusionRegex);
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			assert classLoader != null;
			String path = packageName.replace('.', '/');
			Enumeration<URL> resources = classLoader.getResources(path);
			List<String> dirs = new ArrayList<String>();
			while (resources.hasMoreElements()) {
				URL resource = resources.nextElement();
				dirs.add(resource.getFile());
			}
			TreeSet<String> classes = new TreeSet<String>();
			for (String directory : dirs) {
				classes.addAll(findClasses(directory, packageName, regex));
			}
			ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
			for (String clazz : classes) {
				classList.add(Class.forName(clazz));
			}
			return classList.toArray(new Class[classes.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Recursive method used to find all classes in a given path (directory or zip file url).
	 * Directories are searched recursively.
	 * Adapted from http://snippets.dzone.com/posts/show/4831 and extended to support use of JAR files
	 *
	 * @param path The base directory or url from which to search.
	 * @param packageName The package name for classes found inside the base directory
	 * @param exclusionRegex an optional class name pattern. e.g. .*Test
	 * @return The classes
	 */
	private static TreeSet findClasses(String path, String packageName, Pattern exclusionRegex) throws Exception {
		TreeSet classes = new TreeSet();
		if (path.startsWith("file:") && path.contains("!")) {
			String[] split = path.split("!");
			URL jar = new URL(split[0]);
			ZipInputStream zip = new ZipInputStream(jar.openStream());
			ZipEntry entry;
			while ((entry = zip.getNextEntry()) != null) {
				if (entry.getName().endsWith(".class")) {
					String className = entry.getName().replaceAll("[$].*", "").replaceAll("[.]class", "").replace('/', '.');
					if (className.startsWith(packageName) && (exclusionRegex == null || !exclusionRegex.matcher(className).matches()))
						classes.add(className);
				}
			}
		}
		File dir = new File(path);
		if (!dir.exists()) {
			return classes;
		}
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file.getAbsolutePath(), packageName + "." + file.getName(), exclusionRegex));
			} else if (file.getName().endsWith(".class")) {
				String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
				if (exclusionRegex == null || !exclusionRegex.matcher(className).matches()) classes.add(className);
			}
		}
		return classes;
	}

	/**
	 * Make the user select a file to save to/open
	 *
	 * @param dialogType The dialogType (JFileChooser.OPEN_DIALOG or JFileChooser.SAVE_DIALOG)
	 * @return The user selected File or null if the user cancelled/closed the dialog
	 */
	public static File chooseFile(int dialogType) {
		switch (dialogType) {
			case JFileChooser.SAVE_DIALOG:
				if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					return fc.getSelectedFile();
				}
				break;
			case JFileChooser.OPEN_DIALOG:
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					return fc.getSelectedFile();
				}
				break;
			default:
		}
		return null;
	}

	public static String escapeXML(String input) {
		return input
				.replaceAll("&", "&amp;")
				.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;")
				.replaceAll("\'", "&apos;")
				.replaceAll("\"", "&quot;");
	}
}
