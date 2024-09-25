/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Nombre: List
 * @Descripcion: clase Lista con todos los métodos y funciones elementales
 * @author Catalina Matheus
 * @param <T>
 * @version: 14/10/2023
 */
public class ListDocumento {

    private int size;
    private NodeDocumento pFirst;

    /**
     * @Descripcion: constructor de la clase ListUsuario
     * @author: Reinaldo Reyes
     * @version 14/10/2023
     */
    public ListDocumento() {
        pFirst = null;
        this.size = 0;
    }

    /**
     * @Descripcion: funcion que retorna si la lista esta vacia
     * @return
     * @author: Reinaldo Reyes
     * @version 14/10/2023
     */
    public boolean isEmpty() {
        // me va a decir si la lista esta vacia 
        return pFirst == null;
    }

    /**
     * @Descripcion : metodo que agrega al final de la lista el nodo usuario
     * @param data
     * @author: Reinaldo Reyes & Catalina Matheus
     * @version 12/11/2023
     */
    public void appendLast(NodeDocumento data) {
        // voy a agregar a la lista de primero 

        if (isEmpty()) {
            pFirst = data;
            size++;
        } else {
            if (!this.itExists(data.getNombre())) {
                NodeDocumento aux = pFirst;
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                }
                aux.setpNext(data);
                size++;
            }

        }

    }

    /**
     * @Descripcion: metodo que agrega al inicio de la lista el nodo usuario
     * pasado por parametro
     * @param data
     * @author: Reinaldo Reyes & Catalina Matheus
     * @version 12/11/2023
     */
    public void appendFirst(NodeDocumento data) {
        // voy a gregar a la lista de ultimo

        if (isEmpty()) {
            pFirst = data;
            size++;
        } else {
            if (!this.itExists(data.getNombre())) {
                NodeDocumento aux;
                aux = pFirst;
                data.setpNext(aux);
                pFirst = data;
                size++;
            }

        }

    }

    /**
     * @Descripcion: metodo que imprime la lista
     * @author: Reinaldo Reyes
     * @version 12/11/2023
     */
    public void print() {
        // voy a imprimir la lista 
        String string = "";

        NodeDocumento aux;
        aux = pFirst;
        while (aux != null) {
            string += aux.getNombre() + ", " + aux.getTipo() + ", " + aux.getTamano() + "->";
            aux = aux.getpNext();
        }
        string += "//";
        System.out.println(string);
    }

    /**
     * @Description función que retorna si un string existe dentro de la lista
     * @param data
     * @return
     * @author: Reinaldo Reyes
     * @version 12/11/2023
     */
    public boolean exists(String data) {
        // te dice si existe o no un objeto en la lista
        boolean found = false;
        if (isEmpty()) {
            return found;
        } else {
            NodeDocumento aux;
            aux = pFirst;
            while (aux != null && found != true) {
                if (aux.getNombre() == data) {
                    found = true;
                } else {
                    aux = aux.getpNext();
                }
            }
        }
        return found;
    }

    /**
     * @Description funcion que elimina el primer nodo de la lista y retorna el
     * nodo eliminado
     * @return
     * @auhtor Reinaldo Reyes
     * @version 12/11/2023
     */
    public NodeDocumento deleteFirst() {
        //elimina al comienzo de la lista 
        NodeDocumento aux = pFirst;
        NodeDocumento ret = this.pFirst;
        if (!isEmpty()) {
            if (size == 1) {
                pFirst = null;
            } else {
                pFirst = aux.getpNext();
            }
            size--;
        }
        return ret;

    }

    /**
     * @Description metodo que elimina el ultimo nodo de la lista
     * @author: Reinaldo Reyes
     * @version 12/11/2023
     */
    public void deleteLast() {
        //elimina el nodo al final de la lista
        if (isEmpty()) {// no hay nada que eliminar
            System.out.println("La lista está vacia. Por ende, no se borró nada");
        } else {
            if (size == 1) {// solo hay 1 elemento en la lista
                pFirst = null;
                size--;
                System.out.println("Se logró eliminar con exito el nodo.");
            } else {
                NodeDocumento aux = pFirst;
                while (aux.getpNext().getpNext() != null) {
                    aux = aux.getpNext();
                }
                aux.setpNext(null);
                size--;
                System.out.println("Se logró eliminar con exito el nodo.");
            }
        }

    }

    /**
     * @Description verifica si el username existe en la lista
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version 12/11/2023
     */
    public boolean itExists(String username) {
        boolean existe = false;
        NodeDocumento aux = this.pFirst;
        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(username)) {
                existe = true;
                return existe;
            }
            aux = aux.getpNext();
        }

        return existe;
    }

    public NodeDocumento find(String username) {
        NodeDocumento encontrado = null;
        NodeDocumento aux = this.pFirst;
        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(username)) {
                encontrado = aux;
                return encontrado;
            }

            aux = aux.getpNext();
        }

        return encontrado;
    }

    public void Encola(String username) {
        NodeDocumento aux = this.pFirst;
        while (aux != null) {
            if (aux.getNombre().equalsIgnoreCase(username)) {
                aux.setEnCola(true);

            }

            aux = aux.getpNext();
        }

    }

    public void findEliminate(String username) {
        NodeDocumento auxnext = null;
        NodeDocumento aux = this.pFirst;
        NodeDocumento auxlast = this.pFirst;
        if (size != 1) {
            
            if (!this.pFirst.getNombre().equalsIgnoreCase(username)) {
                while (aux != null) {
                    if (aux.getNombre().equalsIgnoreCase(username)) {
                        auxnext = aux.getpNext();
                        auxlast.setpNext(auxnext);
                        aux.setpNext(null);
                        aux = null;
                        break;
                    }
                    auxlast = aux;
                    aux = aux.getpNext();
                }
            } else {
                pFirst = aux.getpNext();
                aux = null;

            }
        } else {
            
            this.deleteFirst();
        }

    }
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the pFirst
     */
    public NodeDocumento getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodeDocumento pFirst) {
        this.pFirst = pFirst;
    }

}
