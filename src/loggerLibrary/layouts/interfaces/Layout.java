package loggerLibrary.layouts.interfaces;

import loggerLibrary.enumerations.ReportLevel;

public interface Layout {

    String format(String date, ReportLevel reportLevel, String message);
}
