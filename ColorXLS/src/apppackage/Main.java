package apppackage;

public class Main {

    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);

        ExcelModel excelModel = new ExcelModel();
        ExcelReader excel = new ExcelReader(excelModel.getPath(), excelModel.getNameOfList());
        TextWriter writer = new TextWriter(excel.getResultList());
        CSVModel csvModel = new CSVModel();
        CSVReader csvReader = new CSVReader(csvModel.getOutputFilePath());
        CSVWriter csvWriter = new CSVWriter();


        for (String i : writer.getListToWrite()) {
            if(i.contains("PWR")) {
                csvWriter = new CSVWriter(csvReader.findLastElementOnRow(i));
                excelModel.setRowString(excelModel.getRowString().concat(excel.getResultListRow()));
            }
        }

        csvModel.setListOfAllCSVFile(csvReader.getList());
        csvModel.setRowNumber(csvReader.getRowNumberArray());
        csvWriter.writeToCSV(csvModel.getListOfAllCSVFile(), writer.getListToWrite(), csvModel.getRowNumber());
    }
}
