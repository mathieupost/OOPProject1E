package nl.tudelft.excellence.utilities;
import nl.tudelft.excellence.spreadsheet.cells.*;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
				String data;
				long row;
				long column;

				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					System.out.println("Element: " + qName);

					if (qName.equalsIgnoreCase("CELL")) {
						cell = true;
						row = Long.parseLong(attributes.getValue("row"));
						column = Long.parseLong(attributes.getValue("column"));
					}
				}

				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if (cell) {
						CellCoord coord = new CellCoord(column,row);
						if (data.startsWith("=")) {
							grid.put(coord, new FunctionCell(data));
						} else {
							try {
								Double.parseDouble(data);
								grid.put(coord, new NumberCell(data));
							} catch (NumberFormatException e) {
								grid.put(coord, new StringCell(data));
							}
						}
						cell = false;
					}
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					if (cell) {
						data = new String(ch, start, length).replaceAll("\n|\t", "");
						System.out.println("Content: " + data);
					}
				}


			};

			saxParser.parse(file, handler);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		return true;
	}
}
