import loggerLibrary.appenders.ConsoleAppender;
import loggerLibrary.appenders.FileAppender;
import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.customFiles.interfaces.File;
import loggerLibrary.customFiles.interfaces.LogFile;
import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;
import loggerLibrary.layouts.SimpleLayout;
import loggerLibrary.loggers.interfaces.Logger;
import loggerLibrary.loggers.interfaces.MessageLogger;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        System.out.println(file.getSize());
    }
}