package nl.tudelft.excellence.spreadsheet.cells;

public class StringCell extends Cell {

    /**
     * Create a new StringCell Object
     *
     * @param rawData The raw String present in the cell
     */
    public StringCell(String rawData) {
        super(rawData);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || !(other instanceof StringCell))
            return false;

        StringCell that = (StringCell) other;
        return this.getData().equals(that.getData());
    }

    /**
     * Get the String present in the cell
     *
     * @return The String present in the cell
     */
    @Override
    public String getData() {
        //The extra space serves as a hacky way of making sure the data cannot be interpreted as a CellCoord if used in a function.
        return (getRawData().startsWith(" ") ? "" : " ") + getRawData();
    }

}
