module org.example.lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.lab to javafx.fxml;
    exports org.example.lab;

    opens org.example.lab.controllers to javafx.fxml;
    exports org.example.lab.controllers;
}