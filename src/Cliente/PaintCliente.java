/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Clases.Lienzo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.*;

/**
 *
 * @author Yeison
 */
public class PaintCliente extends JFrame{

    /**
     * @param args the command line arguments
     */    
    JPanel panel;
    Lienzo lienzo;

    public PaintCliente(){      
        super("Cliente");        
        super.setBounds(0, 0, 480, 490);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setLayout(null);
        lienzo=new Lienzo(true);   
        super.add(lienzo);
       
    }
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        PaintCliente obj;
        
        obj=new PaintCliente();
                
        
        System.out.println("Hola");
    }
    
}
