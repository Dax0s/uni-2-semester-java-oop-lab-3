package org.example.lab.strategy;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logMessage(String message) {
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
