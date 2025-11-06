module fes.aragon.arbollistaarchivo {
    requires javafx.controls;
    requires javafx.fxml;


    opens fes.aragon.arbollistaarchivo to javafx.fxml;
    exports fes.aragon.arbollistaarchivo;
}