package loggerLibrary.appenders;

import loggerLibrary.enumerations.ReportLevel;
import loggerLibrary.layouts.interfaces.Layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketAppender extends AppenderImpl {
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;

    public SocketAppender(Layout layout) throws IOException {
        super(layout);
        InetAddress address = InetAddress.getLocalHost();
        this.startConnection("127.0.0.1", 21);
    }

    @Override
    public void startConnection(String ip, int port) throws IOException {
        client = new Socket(ip, port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    public String sendMessage(String message) throws IOException {
        out.println(message);
        String resp = in.readLine();
        return resp;
    }


    @Override
    public void append(String date, ReportLevel reportLevel, String message) throws IOException {
        this.sendMessage(this.format(date, reportLevel, message));
    }
}
