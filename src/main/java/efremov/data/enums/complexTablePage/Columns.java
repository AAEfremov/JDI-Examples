package efremov.data.enums.complexTablePage;

public enum Columns {

    COLUMN1("Column 1"),
    COLUMN2("Column 2"),
    COLUMN3("Column 3");

    private String column;

    Columns(String column) {
        this.column = column;
    }


    public String getColumn() {
        return column;
    }
}
