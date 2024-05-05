package org.example.lab.decorator;

public class LogDecorator implements LogInterface {
    private LogInterface wrapee;

    public LogDecorator(LogInterface wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void logMessage(String message) {
        wrapee.logMessage(message);
    }
}
