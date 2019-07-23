package loggerLibrary.appenders;

import loggerLibrary.appenders.interfaces.Appender;
import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.setReportLevel(reportLevel);
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected String format(String date, ReportLevel reportLevel, String message) {
      return this.layout.format(date, reportLevel, message);
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
}
