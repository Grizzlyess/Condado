module com.condadofx.condado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.condadofx.condado to javafx.fxml;
    opens com.condadofx.condado.model.entities to javafx.base;
    exports com.condadofx.condado;
    exports com.condadofx.condado.controllers;
    opens com.condadofx.condado.controllers to javafx.fxml;
}