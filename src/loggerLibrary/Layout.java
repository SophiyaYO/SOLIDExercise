package loggerLibrary;

public interface Layout {

    String format(String date, String reportLevel, String message);
}
