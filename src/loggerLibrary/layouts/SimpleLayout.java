package loggerLibrary.layouts;

import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s",
                date,
                reportLevel.toString(),
                message);
    }
}

