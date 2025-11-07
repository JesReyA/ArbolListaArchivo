package fes.aragon.arbollistaarchivo.inicio;

import unam.fes.aragon.dinamicas.arboles.ArbolBinarioOrden;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArbolArchivo <E>{
    public ArbolBinarioOrden<Integer> crearArbol(String nombreArchivo) throws Exception {
        ManejoArchivos <String>  archivoIngresoDatosArbol = new ManejoArchivos<>();
        FileReader archivo;
        BufferedReader lector;
        String cadena;
        String[] datoIndividual;
        ArbolBinarioArreglo<Integer> listaArbolCreado = new ArbolBinarioArreglo<>();

        try{
            archivo = new FileReader(nombreArchivo);
            lector  = new BufferedReader(archivo);

            while ((cadena = lector.readLine()) != null){
                datoIndividual = cadena.split(" ");
                for (String s : datoIndividual) {
                    listaArbolCreado.insertar(Integer.parseInt(s));
                }
            }
            return listaArbolCreado.arbolBinarioCreado;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
