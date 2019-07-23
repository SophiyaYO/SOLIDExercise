package loggerLibrary.layouts;

import loggerLibrary.layouts.interfaces.Layout;

public class simpleLayout implements Layout {

    @Override
    public String format(String date, String reportLevel, String message) {
        return String.format("%s - %s - %s",
                date,
                reportLevel,
                message);
    }
}

