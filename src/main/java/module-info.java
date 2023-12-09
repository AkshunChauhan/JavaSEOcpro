module com.example.sco {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;

    opens com.example.sco to javafx.fxml;
    exports com.example.sco;
    //exports controllers;
    //opens controllers to javafx.fxml;



}
