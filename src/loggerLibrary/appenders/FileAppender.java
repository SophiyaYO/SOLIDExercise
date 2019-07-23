package loggerLibrary.appenders;

import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;

public class FileAppender extends AppenderImpl {
    protected FileAppender(Layout layout) {
        super(layout);
    }

    protected FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {

    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {

    }
}
