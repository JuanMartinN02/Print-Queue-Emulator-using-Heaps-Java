/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import Estructuras.Monticulo;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Catalina Matheus 
 */
public class GUI extends JFrame {
        private JPanel contentPane;
        public  Monticulo tree;
        public Grafico drawer;
        
        public GUI(Monticulo tree){
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            setBounds(100,100,1500, 900); 
            
            contentPane = new JPanel(); 
            contentPane.setBorder(new EmptyBorder(5,5,5,5)); 
            contentPane.setLayout(new BorderLayout(0,0)); 
            drawer = new Grafico(tree); 
            
            contentPane.add(drawer); 
            this.setLayout(new BorderLayout()); 
            setContentPane(contentPane); 
            this.tree = tree; 
            setVisible(true); 
        }
        
        
}
