package apppackage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Log {
    private String textToLog;
    private String outputLogPath = "C:\\Users\\to067914\\Documents\\ColorXLS\\log.txt";
    private Log log;

    public Log() {}

    public void writeToLog(String textToLog) {
        this.textToLog = textToLog;

        if(!this.textToLog.isEmpty()) {
            try {
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputLogPath));
                writer.write(this.textToLog);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Empty string");
        }
    }
}
