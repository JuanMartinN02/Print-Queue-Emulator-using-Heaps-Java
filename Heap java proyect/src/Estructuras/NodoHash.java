/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *@Description: clase NodoHash (que es el objeto que se ingresara en la tabla hash)
 * @author Catalina Matheus 
 * @version 14/11/2023
 */
public class NodoHash {
    
    private NodeUsuario usuario; 
    private int etiquetaTiempo; 
    private NodeDocumento doc; 
    private NodeMonticulo apuntador;
    private NodoHash pNext; // cuando ocurra una colision se inserta el nodo al lado
    

    /**
     * @Description: constructor clase NodoHash
     * @param usuario
     * @param doc
     * @param etiquetaTiempo 
     * @author: Catalina Matheus 
     * @version 14/11/2023
     */
    public NodoHash(NodeUsuario usuario, NodeDocumento doc, int etiquetaTiempo, NodeMonticulo apuntador) {
        this.usuario = usuario;
        this.doc = doc;
        this.etiquetaTiempo = etiquetaTiempo; 
        this.apuntador = apuntador;
        this.pNext = null; 
        
    }

    /**
     * @return the usuario
     */
    public NodeUsuario getUsuario() {
        return usuario;
    }

    public NodeMonticulo getApuntador() {
        return apuntador;
    }

    public void setApuntador(NodeMonticulo apuntador) {
        this.apuntador = apuntador;
    }
    
    
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(NodeUsuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the etiquetaTiempo
     */
    public int getEtiquetaTiempo() {
        return etiquetaTiempo;
    }

    /**
     * @param etiquetaTiempo the etiquetaTiempo to set
     */
    public void setEtiquetaTiempo(int etiquetaTiempo) {
        this.etiquetaTiempo = etiquetaTiempo;
    }

    /**
     * @return the doc
     */
    public NodeDocumento getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(NodeDocumento doc) {
        this.doc = doc;
    }

    /**
     * @return the pNext
     */
    public NodoHash getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoHash pNext) {
        this.pNext = pNext;
    }
    
    
    
    
    
}
