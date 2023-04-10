package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class LoadProperties {
    private static final String path = "/Users/diyaadinesh/Documents/Karthick/Selenium/Flipkart/src/test/resources/chrome-setup.properties";

    public static void loadChromeSetup() {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] prop = line.split("=");
                System.setProperty(prop[0], prop[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
