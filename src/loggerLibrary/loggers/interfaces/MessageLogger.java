package loggerLibrary.loggers.interfaces;

import loggerLibrary.appenders.interfaces.Appender;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }


    @Override
    public void logInfo(String date, String message) {

    }

    @Override
    public void logWarning(String date, String message) {

    }

    @Override
    public void logError(String date, String message) {

    }

    @Override
    public void logCritical(String date, String message) {

    }

    @Override
    public void logFatal(String date, String message) {

    }
}
