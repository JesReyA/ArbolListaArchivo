package fes.aragon.arbollistaarchivo.controller;

import fes.aragon.arbollistaarchivo.inicio.ArbolArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static java.lang.Math.pow;

public class Controller {
    @FXML
    Button buttonElegirArchivo;
    @FXML
    TextArea visualizacionArbol;

    FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("TXT", "*txt");
    ArbolArchivo nuevoArbol = new ArbolArchivo();
    File archivoElegido;

    @FXML
    public void handleElegirArchivo(ActionEvent e) throws Exception {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(ex1);
        archivoElegido = fileChooser.showOpenDialog(stage);
        if (archivoElegido != null) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Se eligió el archivo correctamente \n Presiona para obtener tu arbol");
            for(int i=0; i<nuevoArbol.longitud(); i++) {
                if (i + 1 == pow(2, i)) {
                    visualizacionArbol.appendText("\n");
                }
                visualizacionArbol.appendText(Integer.toString(nuevoArbol.obtenerNodo(i+1)));
            }
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
