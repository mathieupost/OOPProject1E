package nl.tudelft.excellence.utilities;
import nl.tudelft.excellence.spreadsheet.cells.Cell;
import nl.tudelft.excellence.spreadsheet.cells.CellCoord;
import nl.tudelft.excellence.spreadsheet.SpreadSheet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
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
						grid.put(new CellCoord(column, row), new Cell(data));
					}
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					if (cell) {
						data = new String(ch, start, length).replaceAll("\n|\t", "");
						System.out.println("Content: " + data);
						cell = false;
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
}
