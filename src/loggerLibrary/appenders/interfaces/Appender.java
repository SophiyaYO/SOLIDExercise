package loggerLibrary.appenders.interfaces;

import loggerLibrary.enumerations.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);

    ReportLevel getReportLevel();
}
