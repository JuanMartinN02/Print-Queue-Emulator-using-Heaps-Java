/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Description clase ListaHash para la tabla hash
 * @author Catalina Matheus
 * @version 22/11/2023
 */
public class ListHash {

    private NodoHash pFirst;
    private int size;

    public ListHash() {
        this.pFirst = null;
        this.size = 0;
    }

    /**
     * @Description funcion que indica si la lista está vacía
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public boolean isEmpty() {
        return this.pFirst == null;
    }

    public void appendLastNode(NodoHash nodo) {
        if (this.isEmpty()) {
            this.pFirst = nodo;
        } else {
            NodoHash aux = this.pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(nodo);

        }
        this.size++;
    }

    /**
     * @Description función que elimina el NodoHashespecificado con el nombre
     * del usuario y el documento pasado por parametro y lo retorna
     * @param username
     * @param doc
     * @author: Catalina Matheus, Reinaldo Reyes
     * @version 23/11/2023
     */
    public NodoHash delete(String username, String doc) {
        NodoHash ret = null;
        if (this.size == 1) {
            if (this.pFirst.getUsuario().getNombreUsuario().equals(username) && this.pFirst.getDoc().getNombre().equals(doc)) {
                ret = this.pFirst;
                this.pFirst = null;
                this.size--;

                return ret;
            }
        } else {
            if (!this.isEmpty()) {
                NodoHash auxPrev = this.pFirst;
                NodoHash auxActual = this.pFirst.getpNext();
                this.size--;
                if (auxPrev.getUsuario().getNombreUsuario().equals(username) && auxPrev.getDoc().getNombre().equals(doc)) {
                    ret = auxPrev;
                    this.pFirst = auxActual;
                    return ret;
                }

                while (auxActual != null) {
                    if (auxActual.getUsuario().getNombreUsuario().equals(username) && auxActual.getDoc().getNombre().equals(doc)) {
                        ret = auxActual;
                        if (auxActual.getpNext() == null) {
                            auxPrev.setpNext(null);
                        } else {
                            auxPrev.setpNext(auxActual.getpNext());
                        }
                        break;
                    }
                    auxPrev = auxPrev.getpNext();
                    auxActual = auxActual.getpNext();

                }
            }
        }
        return ret;

    }

    
    
    
    /**
     * @Description función que elimina del hashtable el documento que haya sido eliminado de la cola
     * @param documento
     * @author: Reinaldo Reyes
     * @version 24/11/2023
     */
    public void deletedoc(NodeMonticulo documento) {
        if (!this.isEmpty()) {
            NodoHash aux = this.getpFirst();
            NodoHash auxprev = null;
            while (aux != null) {
                if (aux.getApuntador() == documento) {
                    if (auxprev == null) {
                        if (aux.getpNext() == null) {
                            aux = null;
                            pFirst = null;
                            break;
                        } else {
                            auxprev = aux;
                            aux = aux.getpNext();
                            this.pFirst = aux;
                            auxprev.setpNext(null);
                            auxprev = null;
                            break;

                        }

                    }else{
                        if (aux.getpNext() == null) {
                            auxprev.setpNext(null);
                            aux = null;
                            break;
                        }else{
                            auxprev.setpNext(aux.getpNext());
                            aux.setpNext(null);
                            aux = null;
                            break;
                        }
                    }
                }

                auxprev = aux;
                aux = aux.getpNext();

            }
            this.size--;
        }

    }

    /**
     * @return the pFirst
     */
    public NodoHash getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoHash pFirst) {
        this.pFirst = pFirst;
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

}
