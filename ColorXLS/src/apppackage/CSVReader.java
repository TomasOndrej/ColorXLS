package apppackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader {
    private String path;
    private int rowNumberFinal = 0;
    private Stream<String> stream;
    private CSVModel model = new CSVModel();
    private List<String> list = new ArrayList<String>();
    private List<Integer> rowNumberArray = new ArrayList<Integer>();

    public CSVReader(String path) {
        this.path = path;
    }

    public int findLastElementOnRow(String elementName) {
        int rowNumber = 1;

        try {
            stream = Files.lines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        list = stream.collect(Collectors.toList());
        for(String item : list) {
            if(item.matches("(.*)"+elementName+"(.*)")) {
                rowNumberFinal = rowNumber;
            }
            rowNumber++;
        }
        rowNumberArray.add(rowNumberFinal);
        return rowNumberFinal;
    }

    /**
     * Vraci csv soubor v Listu
     */
    public List<String> joinToList(List<String> list) {
        String.join(";", list);
        return list;
    }

    public List<String> getList() {
        return list;
    }

    public List<Integer> getRowNumberArray() {
        return rowNumberArray;
    }
}
