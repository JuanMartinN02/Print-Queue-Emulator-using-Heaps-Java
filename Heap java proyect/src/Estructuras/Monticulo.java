/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.Arrays;

/**
 *
 * @author reina
 */
public class Monticulo {
//    private NodeMonticulo root;

    private int capacity;
    private int size;
    NodeMonticulo[] items;

    /**
     * @Descripcion: constructor de la clase monticulo
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     */
    public Monticulo() {
        this.capacity = 10;
        this.size = 0;
        this.items = new NodeMonticulo[capacity];
    }

    /**
     * @Descripcion: retorna el indice del hijo izquierdo del padre dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @param parentindex
     */
    public int getLeftChildIndex(int parentindex) {
        return 2 * parentindex + 1;
    }

    /**
     * @Descripcion: retorna el indice del hijo derecho del padre dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @param parentindex
     */
    public int getRightChildIndex(int parentindex) {
        return 2 * parentindex + 2;
    }

    /**
     * @Descripcion: retorna el indice del padre del hijo dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @param childindex
     */
    public int getParentdIndex(int childindex) {
        return (childindex - 1) / 2;
    }

    /**
     * @Descripcion: retorna un booleano diciendo si tiene o no hijo izquierdo
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: boolean
     * @param index
     */
    public boolean hasLeftChild(int index) {
        return this.getLeftChildIndex(index) < size;
    }

    /**
     * @Descripcion: retorna un booleano diciendo si tiene o no hijo derecho
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: boolean
     */
    public boolean hasRightChild(int index) {
        return this.getRightChildIndex(index) < size;
    }

    /**
     * @Descripcion: retorna un booleano diciendo si tiene o no padre
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: boolean
     * @param index
     */
    public boolean hasParent(int index) {
        return this.getParentdIndex(index) >= 0;
    }

    /**
     * @Descripcion: retorna el hijo izquierdo del indice dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: NodeMonticulo
     * @param index
     */
    public NodeMonticulo leftChild(int index) {
        return items[this.getLeftChildIndex(index)];

    }

    /**
     * @Descripcion: retorna el hijo derecho del indice dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: NodeMonticulo
     * @param index
     */
    public NodeMonticulo rightChild(int index) {
        return items[this.getRightChildIndex(index)];

    }

    /**
     * @Descripcion: retorna el padre del indice dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: NodeMonticulo
     * @param index
     */
    public NodeMonticulo parent(int index) {
        return items[this.getParentdIndex(index)];

    }

    /**
     * @Descripcion: intercambia las posicion de un indice dado por el otro
     * indice dado
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @param indexOne, indexTwo
     */
    public void swap(int indexOne, int indexTwo) {
        NodeMonticulo temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    /**
     * @Descripcion: cuando la capidad esta llena, crea un array nuevo con los
     * datos anteriores pero el doble de capacidad
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     */
    public void aumentCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * @Descripcion: retorna el la cima del arbol
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: NodeMonticulo
     */
    public NodeMonticulo peek() {
        if (size == 0) {
            return null;
        }
        return items[0];
    }

    /**
     * @Descripcion: elimina la el nodo con menor prioridad y lo intercambia por
     * el ultimo nodo del array y usa heapifyDown para seguir la estructura
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @return: NodeMonticulo
     */
    public NodeMonticulo eliminar_min() {
        if (size == 0) {
            return null;
        }
        NodeMonticulo item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;

    }

    /**
     * @Descripcion: agrega el nodo dado al final y lo coloca en la posicion
     * correcta usando heapifyUp
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     * @param item
     */
    public void insertar(NodeMonticulo item) {

        this.aumentCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    /**
     * @Descripcion: ordena con la estructura de un monticulo binario desde el
     * ultimo dato agregado hasta que siga con la estructura
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     */
    public void heapifyUp() {
        int index = size - 1;
        while (this.hasParent(index) && (this.parent(index).getPrioridad() > items[index].getPrioridad())) {
            this.swap(this.getParentdIndex(index), index);
            index = this.getParentdIndex(index);
        }

    }

    /**
     * @Descripcion: Retorna el indice del nodo que le den
     * @param intento
     * @return int
     * @version: 23/11/2023
     * @author: Reinaldo Reyes
     */
    public int indexofselect(NodeMonticulo intento) {
        int indice = 0;
        NodeMonticulo te = null;
        NodeMonticulo[] array = new NodeMonticulo[size];
        int contador = 0;
        while (size != 0) {
            te = this.eliminar_min();
            array[contador] = te;
            if (intento == te) {
                indice = contador;
            }
            contador++;

        }
        for (int i = 0; i < array.length; i++) {
            this.insertar(array[i]);
        }

        return indice;
    }

    /**
     * @Descripcion: ordena con la estructura de un monticulo binario desde el
     * nodo dado hasta que siga con la estructura
     * @param intento
     * @version: 23/11/2023
     * @author: Reinaldo Reyes
     */
    public void heapifyUpIndex(NodeMonticulo intento) {
        int index = this.indexofselect(intento);
        while (this.hasParent(index) && (this.parent(index).getPrioridad() > items[index].getPrioridad())) {
            this.swap(this.getParentdIndex(index), index);
            index = this.getParentdIndex(index);
        }

    }

    /**
     * @Descripcion: ordena con la estructura de un monticulo binario desde el
     * primer dato del array hasta que se logre arreglar la estructura del
     * monticulo
     * @version: 09/11/2023
     * @author: Reinaldo Reyes
     */
    public void heapifyDown() {
        int index = 0;
        while (this.hasLeftChild(index)) {
            int smallChildindex = this.getLeftChildIndex(index);
            if (this.hasRightChild(index) && (this.rightChild(index).getPrioridad() < this.leftChild(index).getPrioridad())) {
                smallChildindex = this.getRightChildIndex(index);
            }

            if (items[index].getPrioridad() < items[smallChildindex].getPrioridad()) {
                break;
            } else {
                this.swap(index, smallChildindex);
            }
            index = smallChildindex;

        }
    }

    /**
     * @Descripcion: retorna el nodo que este al final de la cola
     * @param actual, lista, num
     * @return NodeMonticulo
     * @version: 17/11/2023
     * @author: Reinaldo Reyes
     */
    public NodeMonticulo LastNode(NodeMonticulo actual, NodeMonticulo[] lista, int num) {
        if (size != 0) {
            actual = this.eliminar_min();
            lista[num] = actual;
            this.LastNode(actual, lista, num + 1);
            this.insertar(actual);
        }

        return lista[lista.length - 1];

    }

    /**
     * @Descripcion: le pone la menor prioridad al nodo deseado
     * @param actual, nombre
     * @version: 17/11/2023
     * @author: Reinaldo Reyes
     */
    public void eliminar_doc(NodeMonticulo actual, String nombre) {
        NodeMonticulo[] lista = new NodeMonticulo[this.size];
        int fijo = size;
        for (int i = 0; i < fijo; i++) {
            if (actual.getData().getNombre().equals(nombre)) {
                actual.setPrioridad(0);
                lista[i] = actual;
                break;
            } else {
                actual = this.eliminar_min();
                lista[i] = actual;
            }

        }
        for (int i = 0; i < lista.length; i++) {
            this.insertar(lista[i]);
        }

    }

    /**
     * @Description funcion que retorna un string con todos los ids de los
     * documentos
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public String imprimirCola() {
        String print = "";
        NodeMonticulo te = null;
        NodeMonticulo[] array = new NodeMonticulo[size];
        int contador = 0;
        while (size != 0) {
            te = this.eliminar_min();
            array[contador] = te;
            contador++;
            print += te.getData().getNombre() + " " + te.getPrioridad() + ", ";
        }
        for (int i = 0; i < array.length; i++) {
            this.insertar(array[i]);
        }

        return print;
    }
//    

    public boolean isEmpty() {
        return items[0] == null;

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodeMonticulo[] getItems() {
        return items;
    }

    public void setItems(NodeMonticulo[] items) {
        this.items = items;
    }

}
