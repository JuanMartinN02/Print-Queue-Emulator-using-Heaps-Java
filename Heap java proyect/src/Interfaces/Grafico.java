/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import Estructuras.Monticulo;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author catalina
 */
public class Grafico extends JPanel{
    public Monticulo tree; 

    public Grafico(Monticulo tree) {
        this.tree = tree;
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g); 
        Draw(g, 0,0, this.getWidth()-25, 100); 
        
    }
    public int Draw(Graphics g,int index, int x0, int x1, int y ){
        String data = tree.getItems()[index].getData().getNombre(); 
        g.setFont(new Font("Tahoma", Font.BOLD, 20)); 
        FontMetrics fm = g.getFontMetrics(); 
        int n = (x0+x1)/2; 
        g.drawOval(n, y, 75, 30); // ajusta r!
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString(data, n+15, y+20);
        
        // lineas hijo izquierdo: 
        if(tree.hasLeftChild(index)){
            int hijoIzq = tree.getLeftChildIndex(index);
            int x2 = Draw(g, hijoIzq, x0,n,y+50); 
            g.drawLine(n+25, y+30, x2+25, y+50);
        }// lineas hijo derecho 
        if(tree.hasRightChild(index)){
            int hijoDer = tree.getRightChildIndex(index); 
            int x2 = Draw(g,hijoDer, n, x1, y +50); 
            g.drawLine(n+25, y+30, x2+25, y +50); 
        }
        return n; 
        
    }
    
    
}
