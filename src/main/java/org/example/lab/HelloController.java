package org.example.lab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.lab.decorator.ConsoleLogger;
import org.example.lab.decorator.FileLoggerDecorator;
import org.example.lab.decorator.LogDecorator;
import org.example.lab.decorator.LogInterface;
import org.example.lab.factory_method.AdultCreator;
import org.example.lab.factory_method.KidCreator;
import org.example.lab.factory_method.PersonCreator;
import org.example.lab.strategy.FileLogger;
import org.example.lab.strategy.Logger;
import org.example.lab.strategy.LoggerContext;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        // Factory method
        PersonCreator creator = new KidCreator();

        creator.speak("Vytas", 18);
        creator = new AdultCreator();
        creator.speak("Domas", 19);

        // Decorator
        LogDecorator decorator = new FileLoggerDecorator(new ConsoleLogger(), "log_decorator.txt");

        decorator.logMessage("Test message decorator");

        // Strategy
        LoggerContext context = new LoggerContext();
        int strategyOption = 0;
        Logger logger;

        if (strategyOption == 1) {
            logger = new org.example.lab.strategy.ConsoleLogger();
        } else {
            logger = new FileLogger("log_strategy.txt");
        }

        context.logMessage(logger, "Test message strategy");
    }
}