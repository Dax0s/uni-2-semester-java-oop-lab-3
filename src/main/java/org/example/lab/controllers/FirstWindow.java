package org.example.lab.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.lab.Singleton;
import org.example.lab.UserData;

import java.io.IOException;
import java.util.Objects;


public class FirstWindow {
    private final ObservableList<String> choicesList = FXCollections.observableArrayList("Konsolė", "Failas");

    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField decoratorFilename;
    @FXML
    private TextField decoratorMessage;
    @FXML
    private TextField strategyFilename;
    @FXML
    private TextField strategyMesssage;

    @FXML
    private ChoiceBox<String> choices;

    @FXML
    private void initialize() {
        choices.setItems(choicesList);
        choices.setValue(choicesList.get(0));
    }

    @FXML
    protected void onNextWindowClick(ActionEvent event) throws IOException {
        UserData userData = new UserData();

        userData.setDecoratorLogFilename(decoratorFilename.getText());
        userData.setDecoratorLogMessage(decoratorMessage.getText());
        userData.setStrategyLogFilename(strategyFilename.getText());
        userData.setStrategyLogMessage(strategyMesssage.getText());
        userData.setLoggerTarget(Objects.equals(choices.getValue(), "Konsolė") ? UserData.StrategyLoggerTarget.CONSOLE : UserData.StrategyLoggerTarget.FILE);

        Singleton instance = Singleton.getInstance();
        instance.setUserData(userData);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/lab/second-window.fxml"));
        BorderPane pane = loader.load();

        SecondWindow secondWindow = loader.getController();
        secondWindow.setPersonData(name.getText(), Integer.parseInt(age.getText()), Integer.parseInt(age.getText()) > 18 ? UserData.PersonType.ADULT : UserData.PersonType.KID);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
