import loggerLibrary.appenders.ConsoleAppender;
import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;
import loggerLibrary.layouts.simpleLayout;

public class Main {
    public static void main(String[] args) {

        Layout layout = new simpleLayout();

        Appender consoleAppender = new ConsoleAppender(layout);

        consoleAppender.append("Date", ReportLevel.INFO, "Break is wanted");
    }
}