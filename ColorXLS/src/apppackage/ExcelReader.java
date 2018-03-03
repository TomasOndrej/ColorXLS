package apppackage;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExcelReader {
    private TextDesigner designer;
    private List<String> resultList = new ArrayList<String>();

    public ExcelReader(String path, String nameOfList) {
        try {
            File file = new File(path);
            FileInputStream filestream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(filestream);
            XSSFSheet sheet = wb.getSheet(nameOfList);
            XSSFCellStyle cs = sheet.getRow(0).getCell(0).getCellStyle();
            String color = cs.getFillForegroundColorColor().getARGBHex();
            boolean b = false;
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (isColorOrange(sheet, cs, row, cell, color) && row.getRowNum() > 1) {
                        resultList.add(printCellValue(cell));
                        resultList.add(";");
                        b = true;
                    }
                    else {
                        b = false;
                    }
                }
                if(b) {
                    resultList.add("\n");
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private boolean isColorOrange(XSSFSheet sheet, XSSFCellStyle cs, Row row, Cell cell, String color) {
        if(!Objects.isNull(color)) {
            cs = sheet.getRow(row.getRowNum()).getCell(cell.getColumnIndex()).getCellStyle();
            color = cs.getFillForegroundXSSFColor() == null ? "Empty color" : cs.getFillForegroundColorColor().getARGBHex();

            return color.contains("FFC000");
        }

        return false;
    }

    private String printCellValue(Cell cell) {
        String strCellValue = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    strCellValue = cell.toString();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(
                                "dd.MM.yyyy");
                        strCellValue = dateFormat.format(cell.getDateCellValue());
                        designer = new TextDesigner();
                        strCellValue = designer.clearDate(strCellValue);
                    } else {
                        strCellValue = String.valueOf(((int) cell.getNumericCellValue()));

                    }
                    break;
                case BOOLEAN:
                    strCellValue = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    strCellValue = "";
                    break;
            }

        }

        return strCellValue;
    }

    /**
     * Vraci bunky z excelu, ktere jsou oranzove (FFC000)
     */
    public List<String> getResultList() {
        return resultList;
    }

    /**
     * Vraci spojene bunky do retezce
     * TODO: nutno upravit
     */
    public String getResultListRow() {
        return String.join(";", resultList);
    }
}
