package loggerLibrary.customFiles.interfaces;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile implements File {
    private StringBuilder buffer;
    private FileWriter fileWriter;

    public LogFile() throws IOException {
        this.buffer = new StringBuilder();
        this.setFileWriter(System.getProperty("user.dir"));
    }

    public void setFileWriter(String path) throws IOException {
        this.fileWriter = new FileWriter(System.getProperty(path));
    }

    public void appendBuffer(String text) {
        this.buffer.append(text);
    }

    @Override
    public void write() {
        try {
            String text = buffer.toString();
            this.fileWriter.append(text);
            this.buffer = new StringBuilder();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int getSize() {
        int size = 0;

        for (Character chary : this.buffer.toString().toCharArray()) {
            if (Character.isAlphabetic(chary)) {
                size += chary;
            }
        }

        return size;
    }
}
