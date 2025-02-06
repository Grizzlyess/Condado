package com.condadofx.condado.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {
    public static void mostrarAlerta(Alert.AlertType alertType, String titulo, String conteudo) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(conteudo);
        alert.show();
    }
}
