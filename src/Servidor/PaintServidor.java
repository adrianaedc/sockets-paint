/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Yeison
 */
public class PaintServidor extends JFrame {

    public PaintServidor() {
        super("PaintServidor");
        super.setBounds(300,300, 460, 460);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBackground(Color.gray);
        //panel.setSize(450,450);
        //panel.setBackground(Color.red);
        //panel.setVisible(true);
        //super.add(panel);
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        PaintServidor obj;
        
        obj=new PaintServidor();
        
        
        
        System.out.println("Hola");
    }

}
