import loggerLibrary.layouts.interfaces.Layout;
import loggerLibrary.layouts.interfaces.simpleLayout;

public class Main {
    public static void main(String[] args) {

        Layout layout = new simpleLayout();

        System.out.println(
                layout.format(
                "3/31/2015 5:33:07 PM",
                "ERROR",
                "Error parsing request"));
    }
}