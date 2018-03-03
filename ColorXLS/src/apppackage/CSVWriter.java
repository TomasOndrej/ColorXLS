package apppackage;

import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    private int rowNumber;

    public CSVWriter() {}

    public CSVWriter(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void writeToCSV(List<String> listOfAllCSVFile, List<String> textToWrite, List<Integer> rowNumber) {
        List<String> finalList = new ArrayList<String>();
        String local = "";

        for (String i : textToWrite) {
            if(!i.equals("\n")) {
                local += i;
            }
            else {
                finalList.add(local);
                local = "";
            }
        }

        if(ifElementExists(listOfAllCSVFile, textToWrite)) {
            /**
             * Varianta toho, kdy je řádek v excelu fialový, záznam v csv souboru již existuje a je nutné ho nahradit(metoda list.set(index,string))
             */

        }
        else {
            int counter = 0;
            for (String s : finalList) {
                listOfAllCSVFile.add(rowNumber.get(counter) + 1*counter, s);
                counter++;
            }
            listOfAllCSVFile.forEach(i -> System.out.println(i));
        }
    }

    private boolean ifElementExists(List<String> listOfAllCSVFile, List<String> textToWrite) {
        List<String> dslamNameList = new ArrayList<String>();
        textToWrite.forEach(i ->  {
            if(i.contains("L-11") || i.contains("L-51")) {
                dslamNameList.add(i);
            }
        });

        dslamNameList.forEach(i -> System.out.println(i));

        listOfAllCSVFile.forEach(i -> {
            // TODO if(i.contains(" forEach:dslamNameList "))
            //  return true
        });

        return false;
    }
}
