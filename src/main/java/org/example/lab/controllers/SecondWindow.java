package org.example.lab.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.lab.Singleton;
import org.example.lab.UserData;
import org.example.lab.UserData.StrategyLoggerTarget;
import org.example.lab.UserData.PersonType;
import org.example.lab.decorator.ConsoleLogger;
import org.example.lab.decorator.FileLoggerDecorator;
import org.example.lab.decorator.LogDecorator;
import org.example.lab.factory_method.AdultCreator;
import org.example.lab.factory_method.KidCreator;
import org.example.lab.factory_method.PersonCreator;
import org.example.lab.strategy.FileLogger;
import org.example.lab.strategy.Logger;
import org.example.lab.strategy.LoggerContext;

public class SecondWindow {
    @FXML
    private Label personNameFx;
    @FXML
    private Label personAgeFx;

    private String personName;
    private int personAge;
    private PersonType personType;

    public void setPersonData(String name, int age, PersonType personType) {
        this.personName = name;
        this.personAge = age;
        this.personType = personType;

        personNameFx.setText("Vardas: " + name);
        personAgeFx.setText("Amžius: " + age);
    }

    @FXML
    protected void onLogDataClick() {
        Singleton instance = Singleton.getInstance();
        UserData userData = instance.getUserData();

        // Factory method
        PersonCreator creator;
        if (personType == PersonType.KID) {
            creator = new KidCreator();
        } else {
            creator = new AdultCreator();
        }

        creator.speak(personName, personAge);

        // Decorator
        LogDecorator decorator = new FileLoggerDecorator(new ConsoleLogger(), userData.getDecoratorLogFilename());

        decorator.logMessage(userData.getDecoratorLogMessage());

        // Strategy
        LoggerContext context = new LoggerContext();
        Logger logger;

        if (userData.getLoggerTarget() == StrategyLoggerTarget.CONSOLE) {
            logger = new org.example.lab.strategy.ConsoleLogger();
        } else {
            logger = new FileLogger(userData.getStrategyLogFilename());
        }

        context.logMessage(logger, userData.getStrategyLogMessage());
    }
}
