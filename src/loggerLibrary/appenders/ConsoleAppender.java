package loggerLibrary.appenders;

import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;

public class ConsoleAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    @Override
    public void append(String date, String reportLevel, String message) {
        System.out.println(this.layout.format(date, reportLevel, message));
    }
}
