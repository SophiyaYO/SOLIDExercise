import loggerLibrary.appenders.ConsoleAppender;
import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;
import loggerLibrary.layouts.SimpleLayout;
import loggerLibrary.loggers.interfaces.Logger;
import loggerLibrary.loggers.interfaces.MessageLogger;

public class Main {
    public static void main(String[] args) {

        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        consoleAppender.setReportLevel(ReportLevel.ERROR);

        Logger logger = new MessageLogger(consoleAppender);

        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");

    }
}