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
public class ListUsuario {

    private int size;
    private NodeUsuario pFirst;

    /**
     * @Descripcion: constructor de la clase ListUsuario
     * @author: Reinaldo Reyes 
     * @version 14/10/2023
     */
    public ListUsuario() {
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
    public void appendLast(NodeUsuario data) {
        // voy a agregar a la lista de primero 

        if (isEmpty()) {
            pFirst = data;
            size++;
        } else {
            if (!this.itExists(data.getNombreUsuario())) {
                NodeUsuario aux = pFirst;
                while (aux.getpNext() != null) {
                    aux = aux.getpNext();
                }
                aux.setpNext(data);
                size++;
            }

        }

    }

    /**
     * @Descripcion: metodo que agrega al inicio de la lista el nodo usuario pasado por parametro 
     * @param data 
     * @author: Reinaldo Reyes & Catalina Matheus 
     * @version 12/11/2023
     */
    public void appendFirst(NodeUsuario data) {
        // voy a gregar a la lista de ultimo

        if (isEmpty()) {
            pFirst = data;
            size++;
        } else {
            if (!this.itExists(data.getNombreUsuario())) {
                NodeUsuario aux;
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

        NodeUsuario aux;
        aux = pFirst;
        while (aux != null) {
            string += aux.getNombreUsuario() + ", " + aux.getTipoPrioridad() + "->";
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
            NodeUsuario aux;
            aux = pFirst;
            while (aux != null && found != true) {
                if (aux.getNombreUsuario() == data) {
                    found = true;
                } else {
                    aux = aux.getpNext();
                }
            }
        }
        return found;
    }

    /**
     * @Description funcion que elimina el primer nodo de la lista y retorna el nodo eliminado 
     * @return 
     * @auhtor Reinaldo Reyes
     * @version 12/11/2023
     */
    public NodeUsuario deleteFirst() {
        //elimina al comienzo de la lista 
        NodeUsuario aux = pFirst;
        NodeUsuario ret = this.pFirst;
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
            } else {
                NodeUsuario aux = pFirst;
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
        NodeUsuario aux = this.pFirst; 
        while(aux != null){
            if(aux.getNombreUsuario().equalsIgnoreCase(username)){
                existe = true; 
                return existe; 
            }aux = aux.getpNext(); 
        }
        
        return existe;
    }
    
    public NodeUsuario find(String username){
        NodeUsuario encontrado = null; 
        NodeUsuario aux = this.pFirst; 
        while(aux != null){
            if (aux.getNombreUsuario().equalsIgnoreCase(username)) {
                encontrado = aux; 
                return encontrado; 
            }
            
            aux = aux.getpNext(); 
        }
        
        return encontrado; 
    }
    
    
    public void deleteUser(String username){
//         eliminar de la lista cuando se pasa por parametro el dato      
        boolean exists = itExists(username); 
        boolean deleted = false; 
        if (!exists) {// no tengo nada que borrar
            System.out.println("No se encuentra en la lista, por ende, no se elimino");
        }else{
            if (isEmpty()) {
                System.out.println("La lista está vacia por ende no se puede eliminar lo pedido");   
            }else{
                NodeUsuario aux; 
                aux = pFirst; 
                if (pFirst.getNombreUsuario().equals(username)) {// quiere decir que es el primero
                    deleteFirst(); 
                }else{ // está en otra posición de la lista
                    while(!deleted){
                        if (aux.getpNext().getNombreUsuario().equals(username)) {// se encontro
                            NodeUsuario aux2 = aux.getpNext().getpNext(); 
                            aux.setpNext(aux2);
                            deleted = true;
                            System.out.println("Se elimino el nodo con exito!"); 
                        } else{
                            aux = aux.getpNext(); 
                        } 
                    }
                  size --;   
                }
                    
            }
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
    public NodeUsuario getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodeUsuario pFirst) {
        this.pFirst = pFirst;
    }

}
