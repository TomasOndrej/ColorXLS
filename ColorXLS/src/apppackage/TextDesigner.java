package apppackage;

public class TextDesigner {

    public TextDesigner() {}

    public String clearDate(String strCellValue) {
        // 04.08.2015 -> 4.8.2015
        // 19.02.2015 -> 19.2.2015

        String local = strCellValue;

        if(local.matches("0.*"))
            local =  local.substring(1);

        if(local.matches("\\d[.]0.*")) {
            local = local.substring(0, 2) + local.substring(3);
        }
        else if(local.matches("\\d\\d[.]0.*")) {
            local = local.substring(0, 3) + local.substring(4);
        }

        return local;
    }
}
