package loggerLibrary.appenders.interfaces;

public interface Appender {
    void append(String date, String reportLevel, String message);
}
