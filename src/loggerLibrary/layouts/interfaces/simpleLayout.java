package loggerLibrary.layouts.interfaces;

public class simpleLayout implements Layout {

    public simpleLayout() {

    }

    @Override
    public String format(String date, String reportLevel, String message) {
        return String.format("%s - %s - %s",
                date,
                reportLevel,
                message);
    }
}

