/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

 /**
 *@Descripcion: NodoMonticulo
 * @author Juan Martin
 * @version: 08/11/2023
 */
public class NodeMonticulo {
    private int prioridad; //Prioridad del nodo (tiempo en cola)
    private NodeDocumento data;
    /**
 *@Descripcion: constructor NodoMonticulo
 * @author Juan Martin
 * @version: 08/11/2023
 */
    public NodeMonticulo(int prioridad, NodeDocumento data){
        this.prioridad = prioridad;
        this.data = data;
        
    }
    public NodeMonticulo(int prioridad){
        this.prioridad = prioridad;
        this.data = null;

        
    }


    

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public NodeDocumento getData() {
        return data;
    }

    public void setData(NodeDocumento data) {
        this.data = data;
    }
}
