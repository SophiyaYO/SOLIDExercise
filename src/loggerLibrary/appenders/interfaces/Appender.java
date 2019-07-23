package loggerLibrary.appenders.interfaces;

import loggerLibrary.enumerations.ReportLevel;

public interface Appender {
    void append(String date, String reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
