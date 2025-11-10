package fes.aragon.arbollistaarchivo.inicio;

import unam.fes.aragon.dinamicas.arboles.ArbolBinarioOrden;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArbolArchivo <E>{
    public ArbolBinarioArreglo<Integer> listaArbolCreado = new ArbolBinarioArreglo<>();
    public ArbolBinarioOrden<Integer> crearArbol(String nombreArchivo) throws Exception {
//        ManejoArchivos <String>  archivoIngresoDatosArbol = new ManejoArchivos<>();
        File file =new File(nombreArchivo);
        if (!file.exists()){
            throw new FileNotFoundException("Archivo n encontrao");
        }
        if (!file.canRead()){
            throw new RuntimeException("El archivo no es legible ");
        }


        try (FileReader archivo = new FileReader(nombreArchivo); BufferedReader lector =new BufferedReader(archivo)){

            String cadena;
            int lineapos=0;
            while ((cadena = lector.readLine()) != null){
                lineapos++;
                if(cadena.trim().isEmpty()){
                    continue;
                }
                String[]datoIndividual = cadena.split(" ");

                for (String s : datoIndividual) { //ojo aquí
                    if (!s.trim().isEmpty()){
                        try{
                            int valor = Integer.parseInt(s.trim());
                            listaArbolCreado.insertar(valor);

                        }catch (NumberFormatException e){
                            throw new RuntimeException("En el archivo hay valores nan");
                        }
                    }
                }
            }
            return listaArbolCreado.arbolBinarioCreado;
        } catch (Exception e) {
            throw new RuntimeException("Error en la lectura del archivo"+e.getMessage() );
        }
    }

    public int longitud(){
        return listaArbolCreado.longitud();
    }

    public Integer obtenerNodo(int indice){
        return listaArbolCreado.obtenerNodo(indice);
    }

}
