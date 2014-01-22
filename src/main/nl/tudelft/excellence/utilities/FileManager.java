package nl.tudelft.excellence.utilities;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;
import nl.tudelft.excellence.spreadsheet.cells.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class FileManager {
	
	public static SpreadSheet parseXML(File file) {
		final TreeMap<CellCoord, Cell> grid = new TreeMap<CellCoord, Cell>();
		try {

			SAXParserFactory factory =  SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {
				boolean cell = false;
				String data = "";
				int row;
				int column;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

					if (qName.equalsIgnoreCase("CELL")) {
						cell = true;
						row = Integer.parseInt(attributes.getValue("row"));
						column = Integer.parseInt(attributes.getValue("column"));
					}
				}

				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if (cell) {
						CellCoord coord = new CellCoord(column,row);
						if (data.startsWith("=") && data.length()>1) {
							grid.put(coord, new FunctionCell(data));
						} else {
							try {
								double number = Double.parseDouble(data);
								grid.put(coord, new NumberCell(number));
							} catch (NumberFormatException e) {
								grid.put(coord, new StringCell(data));
							}
						}
						data = "";
						cell = false;
					}
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					if (cell) {
						data += new String(ch, start, length).replaceAll("\n|\t", "");
					}
				}


			};

			saxParser.parse(file, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SpreadSheet(grid);
	}
	
	public static boolean saveToFile(File file, String content){
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		writer.write(content);
		writer.close();
		return !writer.checkError();
	}
}
