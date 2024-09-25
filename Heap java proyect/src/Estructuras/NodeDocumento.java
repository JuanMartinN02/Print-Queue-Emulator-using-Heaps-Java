/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 * @Descripcion: NodoDocumento
 * @author Juan Martin
 * @version: 08/11/2023
 */
public class NodeDocumento {

    private String nombre;
    private int tamano;
    private String tipo;
    private NodeDocumento pNext;
    private boolean enCola;

    /**
     * @Descripcion: constructorNodoDocumento
     * @author Juan Martin
     * @version: 08/11/2023
     */
    public NodeDocumento(String nombre, int tamano, String tipo) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.tipo = tipo;
        this.pNext = null;
        this.enCola = false;
    }

    public NodeDocumento getpNext() {
        return pNext;
    }

    public void setpNext(NodeDocumento pNext) {
        this.pNext = pNext;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEnCola() {
        return enCola;
    }

    public void setEnCola(boolean enCola) {
        this.enCola = enCola;
    }
}
