/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
     * @Descripcion: NodoUsuario
     * @author Juan Martin
     * @version: 08/11/2023
     */
public class NodeUsuario {

    private String nombreUsuario;
    private String tipoPrioridad;
    private ListDocumento documentos;
    private NodeUsuario pNext;
    
    /**
     * @Descripcion: NodoUsuario Constructor
     * @author Juan Martin
     * @version: 08/11/2023
     */
    public NodeUsuario(String nombreUsuario, String tipoPrioridad) {
        this.nombreUsuario = nombreUsuario;
        this.tipoPrioridad = tipoPrioridad;
        this.documentos = new ListDocumento();
        this.pNext =null;
    }
    
    public NodeUsuario() {
        this.nombreUsuario = null;
        this.tipoPrioridad = null;
        this.documentos = new ListDocumento();
        this.pNext =null;
    }
    

    public NodeUsuario getpNext() {
        return pNext;
    }

    public void setpNext(NodeUsuario pNext) {
        this.pNext = pNext;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipoPrioridad() {
        return tipoPrioridad;
    }

    public void setTipoPrioridad(String tipoPrioridad) {
        this.tipoPrioridad = tipoPrioridad;
    }

    public ListDocumento getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ListDocumento documentos) {
        this.documentos = documentos;
    }
}
