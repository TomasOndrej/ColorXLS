package apppackage;

import java.util.ArrayList;
import java.util.List;

public class CSVModel {
    private List<String> listOfAllCSVFile;
    private List<Integer> rowNumber = new ArrayList<Integer>();
    private String outputFilePath = "C:\\Users\\%USERNAME%\\Documents\\ColorXLS\\file.csv";
    int counter = 1;

    public CSVModel(){}

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public List<String> getListOfAllCSVFile() {
        return listOfAllCSVFile;
    }

    public void setListOfAllCSVFile(List<String> listOfAllCSVFile) {
        this.listOfAllCSVFile = listOfAllCSVFile;
        this.listOfAllCSVFile.forEach(i -> System.out.println(counter++));
    }

    public List<Integer> getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(List<Integer> rowNumber) {
        this.rowNumber = rowNumber;
    }
}
