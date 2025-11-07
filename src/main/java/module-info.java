module fes.aragon.arbollistaarchivo {
    requires javafx.controls;
    requires javafx.fxml;
    requires Herramientas;


    opens fes.aragon.arbollistaarchivo to javafx.fxml;
    exports fes.aragon.arbollistaarchivo;
    exports fes.aragon.arbollistaarchivo.controller;
    opens fes.aragon.arbollistaarchivo.controller to javafx.fxml;
    exports fes.aragon.arbollistaarchivo.inicio;
    opens fes.aragon.arbollistaarchivo.inicio to javafx.fxml;
}