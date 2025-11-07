package fes.aragon.arbollistaarchivo.inicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ventana.class.getResource("/fes/aragon/arbollistaarchivo/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/fes/aragon/arbollistaarchivo/css/styles.css").toExternalForm());
        stage.setTitle("Arbol con Lista");
        stage.setScene(scene);
        stage.show();
    }
}
