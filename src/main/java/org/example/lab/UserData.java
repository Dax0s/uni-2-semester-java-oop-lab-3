package org.example.lab;
public class UserData {

    public enum PersonType {
        ADULT,
        KID
    }

    public enum StrategyLoggerTarget {
        FILE,
        CONSOLE
    }

    // Factory info
    private PersonType personType;
    private String personName;
    private int personAge;

    // Decorator info
    private String decoratorLogFilename;
    private String decoratorLogMessage;

    // Strategy info
    private StrategyLoggerTarget loggerTarget;
    private String strategyLogFilename;
    private String strategyLogMessage;

    public UserData() {}

    public UserData(PersonType personType, String personName, int personAge, String decoratorLogFilename, String decoratorLogMessage, StrategyLoggerTarget loggerTarget, String strategyLogFilename, String strategyLogMessage) {
        this.personType = personType;
        this.personName = personName;
        this.personAge = personAge;
        this.decoratorLogFilename = decoratorLogFilename;
        this.decoratorLogMessage = decoratorLogMessage;
        this.loggerTarget = loggerTarget;
        this.strategyLogFilename = strategyLogFilename;
        this.strategyLogMessage = strategyLogMessage;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getDecoratorLogFilename() {
        return decoratorLogFilename;
    }

    public void setDecoratorLogFilename(String decoratorLogFilename) {
        this.decoratorLogFilename = decoratorLogFilename;
    }

    public String getDecoratorLogMessage() {
        return decoratorLogMessage;
    }

    public void setDecoratorLogMessage(String decoratorLogMessage) {
        this.decoratorLogMessage = decoratorLogMessage;
    }

    public StrategyLoggerTarget getLoggerTarget() {
        return loggerTarget;
    }

    public void setLoggerTarget(StrategyLoggerTarget loggerTarget) {
        this.loggerTarget = loggerTarget;
    }

    public String getStrategyLogFilename() {
        return strategyLogFilename;
    }

    public void setStrategyLogFilename(String strategyLogFilename) {
        this.strategyLogFilename = strategyLogFilename;
    }

    public String getStrategyLogMessage() {
        return strategyLogMessage;
    }

    public void setStrategyLogMessage(String strategyLogMessage) {
        this.strategyLogMessage = strategyLogMessage;
    }
}
