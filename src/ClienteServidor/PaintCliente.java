/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import Clases.*;
import Clases.Lienzo;
import Clases.VentanaPrincipal;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Yeison
 */
public class PaintCliente extends JPanel{

    JPanel panel;
    Lienzo lienzo;
    JButton borrar;
    JColorChooser colores;
    public PaintCliente(){      
        super.setBounds(0, 0,480, 480);
        super.setVisible(true);
        super.setLayout(null);
        lienzo=new Lienzo(true);
        super.add(lienzo);        
        borrar= new JButton("Borrar");
        borrar.setBounds(Constantes.HEIGHT-10, 10,80, 40);
        borrar.setVisible(true);
        colores= new JColorChooser();
        colores.setBounds(Constantes.HEIGHT-10, 110,80, 40);
        colores.setVisible(true);
        super.add(colores);
        super.add(borrar);
    }

    
    
    
    
    
    
    
    
}
