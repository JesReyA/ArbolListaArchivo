package fes.aragon.arbollistaarchivo.controller;

import fes.aragon.arbollistaarchivo.inicio.ArbolArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Controller {
    @FXML
    Button buttonElegirArchivo, obtenerArbol;

    FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("TXT", "*txt");
    ArbolArchivo nuevoArbol = new ArbolArchivo();
    File archivoElegido;

    @FXML
    public void handleElegirArchivo(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        fileChooser.getExtensionFilters().addAll(ex1);
        archivoElegido = fileChooser.showOpenDialog(stage);
        if(archivoElegido != null){
            mostrarAlerta(Alert.AlertType .INFORMATION, "Éxito", "Se eligió el archivo correctamente \n Presiona para obtener tu arbol");
            obtenerArbol.setDisable(false);
        }
    }

    @FXML
    public void handleObtenerArbol(ActionEvent event) throws Exception {
        nuevoArbol.crearArbol(archivoElegido.getAbsolutePath());
    }


    private  void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
