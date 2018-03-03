package apppackage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class TextWriter {
    private List<String> listToWrite;
    private String outputFilePath = "C:\\Users\\to067914\\Documents\\ColorXLS\\output.txt";
    private Log log;
    private String elementName;

    TextWriter(List<String> listFromExcel) {
        this.listToWrite = listFromExcel;

        if(!listToWrite.isEmpty()) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {
                listToWrite.forEach(list -> {
                    try {
                        writer.write(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Empty list (List<String> listToWrite)");
            log = new Log();
            log.writeToLog(new Date() + " : Empty list (List<String> listToWrite)");
        }
    }

    public List<String> getListToWrite() {
        return listToWrite;
    }
}
