package loggerLibrary.appenders;

import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.layouts.interfaces.Layout;

public class ConsoleAppender implements Appender {
    private Layout layout;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
    }

    @Override
    public void append(String date, String reportLevel, String message) {
        System.out.println(this.layout.format(date, reportLevel, message));
    }
}
