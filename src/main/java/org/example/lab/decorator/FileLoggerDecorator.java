package org.example.lab.decorator;

import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerDecorator extends LogDecorator {
    private final String filename;
    public FileLoggerDecorator(LogInterface source, String filename) {
        super(source);

        this.filename = filename;
    }

    @Override
    public void logMessage(String message) {
        logToFile(message);
        super.logMessage(message);
    }

    private void logToFile(String message) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(message);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
