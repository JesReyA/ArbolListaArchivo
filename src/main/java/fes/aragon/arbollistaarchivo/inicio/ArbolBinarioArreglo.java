package fes.aragon.arbollistaarchivo.inicio;

import unam.fes.aragon.dinamicas.arboles.ArbolBinarioOrden;
import unam.fes.aragon.dinamicas.listasimple.ListaSimple;

public class ArbolBinarioArreglo<E>{
    ListaSimple<E> arbolBinarioLista = new ListaSimple<>();
    ArbolBinarioOrden<E> arbolBinarioCreado = new ArbolBinarioOrden<>();
    private Integer indice;

    public ArbolBinarioArreglo(){
        indice = 0;
    }

    public void insertar(E dato){
        if(arbolBinarioLista.estaVacia()){
            arbolBinarioLista.agregarEnCola(dato);
        }
        else{
            indice = 0;
            while(true){
                verificarLongitud(indice);
                E actual = arbolBinarioLista.obtenerNodo(indice);
                if(actual == null){
                    break;
                }
                if ((Integer)dato > (Integer) actual) {
                    indice = (2 * indice) + 2; // Derecha
                } else {
                    indice = (2 * indice) + 1; // Izquierda
                }

            }
            arbolBinarioLista.asignar(dato, indice);
        }
    }

    public void verificarLongitud(Integer indice){
            while (arbolBinarioLista.getLongitud() <= indice) {
                arbolBinarioLista.agregarEnCola(null);
            }
    }

    //recorridos
    public void inorder(){

    }

    public void imprimir(){
        arbolBinarioLista.imprimirLista();
    }

    public E extraerDeListaArbol(int posicion){
        E dato = arbolBinarioLista.obtenerNodo(posicion);
        arbolBinarioLista.eliminarEnIndice(posicion);
        return dato;
    }

    public void borrar(){
        arbolBinarioLista.eliminarEnCabeza();
    }
    public int longitud (){
        return arbolBinarioLista.getLongitud();
    }

    public E obtenerNodo(int indice){
        return arbolBinarioLista.obtenerNodo(indice);
    }
}
