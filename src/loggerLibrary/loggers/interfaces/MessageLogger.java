package loggerLibrary.loggers.interfaces;

import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.enumerations.ReportLevel;

import java.io.IOException;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }


    @Override
    public void logInfo(String date, String message) throws IOException {
       this.logMessage(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) throws IOException {
        this.logMessage(date, ReportLevel.WARNING, message);

    }

    @Override
    public void logError(String date, String message) throws IOException {
        this.logMessage(date, ReportLevel.ERROR, message);

    }

    @Override
    public void logCritical(String date, String message) throws IOException {
        this.logMessage(date, ReportLevel.CRITICAL, message);

    }

    @Override
    public void logFatal(String date, String message) throws IOException {
        this.logMessage(date, ReportLevel.FATAL, message);

    }

    private void logMessage(String date, ReportLevel reportLevel, String message) throws IOException {
        for (Appender appender : this.appenders) {
            if (appender.getReportLevel().compareTo(reportLevel) <= 0) {
                appender.append(date, reportLevel, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info\r\n");

        for (Appender appender : appenders) {
            builder.append(appender.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
