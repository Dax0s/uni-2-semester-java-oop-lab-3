package org.example.lab.decorator;

public class ConsoleLogger implements LogInterface {
    @Override
    public void logMessage(String message) {
        System.out.println(message);
    }
}
