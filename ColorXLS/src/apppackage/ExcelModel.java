package apppackage;

public class ExcelModel {
    private String path = "C:\\Users\\%USERNAME%\\Documents\\ColorXLS\\file.xlsx";
    private String nameOfList = "List1";
    private String rowString = "";

    public String getPath() {
        return path;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public String getRowString() {
        return rowString;
    }

    public void setRowString(String rowString) {
        this.rowString = rowString;
    }
}
