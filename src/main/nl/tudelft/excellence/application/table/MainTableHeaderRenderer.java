package nl.tudelft.excellence.application.table;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainTableHeaderRenderer extends JLabel implements TableCellRenderer {
	private final boolean usedForCells;

	public MainTableHeaderRenderer(boolean usedForCells) {
		this.usedForCells = usedForCells;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
		JTableHeader header = table.getTableHeader();
		Color bgColor = Color.getHSBColor(0.18956046f, 0.9191919f, 0.7764706f);

		table.setGridColor(Color.GRAY);

		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.WHITE);
		setFont(getFont().deriveFont(Font.BOLD));

		if(usedForCells){
			setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, table.getGridColor()));
			table.setBackground(bgColor);
			header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, table.getGridColor()));
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(true);
		} else {
			setBorder(BorderFactory.createMatteBorder(1, 0, 2, 1, table.getGridColor()));
			header.setResizingAllowed(true);
			header.setBackground(bgColor);
			header.setReorderingAllowed(false);
		}


		setText(value.toString());
		return this;
	}

}