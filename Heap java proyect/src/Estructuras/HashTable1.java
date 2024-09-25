/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * @Description clase HashTable
 * @author Catalina Matheus
 * @version 22/11/2023
 */
public class HashTable1 {

    private ListHash[] table;
    private int size;

    public HashTable1() {
        this.size = 11;
        this.table = new ListHash[this.size];
        for (int i = 0; i < 10; i++) {
            this.table[i] = new ListHash();
        }

    }

    /**
     * @Description funcion que retorna la posicion donde se inserto una nueva
     * entrada a la tabla dado los parametros ingresados
     * @param usuario
     * @param doc
     * @param contadorTiempo
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public int hashFunctionInsert(NodeUsuario usuario, NodeDocumento doc, int contadorTiempo, NodeMonticulo apun) {
        // se va a insertar en base al nombre del usuario entonces cuando se quiera eliminar un doc, se busca el usuario y de ahi se puede encotrar el doc
        int index = -1;
        // creamos el nodo hash 
        NodoHash nodito = new NodoHash(usuario, doc, contadorTiempo, apun);
        String username = nodito.getUsuario().getNombreUsuario();
        int contador = 0; // para sacar el valor ascii del username
        for (int i = 0; i < username.length(); i++) {
            contador += username.charAt(i);

        }

        index = contador % 11; // el indice en la tabla hash donde tiene que estar el nodito 
        this.getTable()[index].appendLastNode(nodito);

        return index;
    }

    /**
     * @Description funcion que retorna el indice donde se encuentra el usuario
     * pasado por parametro
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version 14/11/2023
     */
    public int hashFunctionFinder(String username) {
        int index = -1;
        int contador = 0; // para sacar el valor ascii del username
        for (int i = 0; i < username.length(); i++) {
            contador += username.charAt(i);

        }
        index = contador % 11;
        if (this.table[index] != null) {
            return index;

        }

        return -1;
    }

    /**
     * @Description funcion que retorna el nodo hash dado el usuario y el nombre
     * del documento
     * @param username
     * @param doc
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public NodoHash findDoc(String username, String doc) {
        int index = this.hashFunctionFinder(username); // para encontrar el indice donde se supone que tiene que estar el doc 
        NodoHash nodito = null;
        if (index >= 0) {
            if (this.table == null) {
                return nodito;
            } else {
                NodoHash aux = this.table[index].getpFirst();
                while (aux != null) {
                    if (aux.getUsuario().getNombreUsuario().equals(username) && aux.getDoc().getNombre().equals(doc)) {
                        nodito = aux;
                        return nodito;
                    }

                    aux = aux.getpNext();
                }

            }
        }
        return nodito;
    }

    /**
     * @Description funcion que retorna la etiqueta de tiempo del documento del
     * usuario pasado por parametro
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version 14/11/2023
     */
    public int findTimerDoc(String username, String doc) {
        int time = -1;
        NodoHash nodito = this.findDoc(username, doc);
        if (nodito != null) {
            time = nodito.getEtiquetaTiempo();
        }
        return time;
    }

    /**
     * @Description funcion que retorna una lista con todos los usuarios que
     * tienen documentos en la cola para imprimir
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public List<String> printUsers() {
        List<String> listaU = new List();
        for (int i = 0; i < 11; i++) {
            if (this.table[i] != null) {
                NodoHash aux = this.table[i].getpFirst();
                while (aux != null) {
                    if (!listaU.existe(aux.getUsuario().getNombreUsuario())) {
                        listaU.appendLast(aux.getUsuario().getNombreUsuario());
                    }
                    aux = aux.getpNext();
                }
            }

        }
        return listaU;
    }

    public void EliminateDoc(NodeMonticulo documento) {
        for (int i = 0; i < 11; i++) {
            if (this.table[i] != null) {
                ListHash intento = this.table[i];
                intento.deletedoc(documento);
                    }
                }
            }

        
    

    /**
     * @Description funcion que elimina y retorna todas las entradas en la tabla
     * que pertenezcan al usuario pasado por parametro
     * @param username
     * @return
     * @author: Catalina Matheus
     * @version 22/11/2023
     */
    public ListHash deleteInTableAll(String username) {

        ListHash listaRet = new ListHash();
        NodoHash nodito = null;
        int index = this.hashFunctionFinder(username);
        if (index >= 0) {
            if (this.table[index] != null) {
                NodoHash aux = this.table[index].getpFirst();
                while (aux != null) {
                    if (aux.getUsuario().getNombreUsuario().equals(username)) {
                        listaRet.appendLastNode(aux);
                        this.table[index].delete(aux.getUsuario().getNombreUsuario(), aux.getDoc().getNombre());
                    }
                    aux = aux.getpNext();

                }

            }

        }
        return listaRet;
    }

    /**
     * @Description funcion que retorna una lista con todos los nombres de los
     * documentos que un usuario tiene en la cola de impresiǿn
     * @param username
     * @return
     * @auhtor: Catalina Matheus
     * @version 22/11/2023
     */
    public List<String> findDocsOfUser(String username) {
        List<String> listRet = new List();
        int index = this.hashFunctionFinder(username);
        if (index >= 0) {
            if (this.table[index] != null) {
                NodoHash aux = this.table[index].getpFirst();
                while (aux != null) {
                    if (aux.getUsuario().getNombreUsuario().equals(username)) {
                        listRet.appendLast(aux.getDoc().getNombre());
                    }
                    aux = aux.getpNext();
                }
            }
        }

        return listRet;
    }

    /**
     * @Description función que elimina la entrada especificada por parametro y
     * lo devuelve
     * @param username
     * @param nombreDoc
     * @return
     * @author: Catalina Matheus
     * @version: 22/11/2023
     */
    public NodoHash deleteInTable(String username, String nombreDoc) {
        NodoHash nodito = null;
        int index = this.hashFunctionFinder(username);
        if (index >= 0) {
            ListHash ki = this.table[index];
            nodito = this.table[index].delete(username, nombreDoc);

        }

        return nodito;
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
     * @return the table
     */
    public ListHash[] getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(ListHash[] table) {
        this.table = table;
    }

}
