/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import Clases.*;
import Clases.Lienzo;
import Clases.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Yeison
 */
public class PaintCliente extends JPanel{

    JPanel panel;
    Lienzo lienzo;
    JButton borrar, rojo, azul, amarillo, verde, negro, marron;
    public PaintCliente(){      
        super.setBounds(0, 0,480, 480);
        super.setVisible(true);
        super.setLayout(null);
        lienzo=new Lienzo(true);
        super.add(lienzo);        
        borrar= new JButton("Borrar");
        borrar.setBounds(Constantes.HEIGHT-10, 10,100, 40);
        borrar.setVisible(true);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=0;
            }
        });
        super.add(borrar);
        negro= new JButton("Negro");
        negro.setBounds(Constantes.HEIGHT-10, 110,100, 20);
        negro.setVisible(true);
        negro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=1;
            }
        });
        super.add(negro);
        rojo= new JButton("Rojo");
        rojo.setBounds(Constantes.HEIGHT-10, 140,100, 20);
        rojo.setVisible(true);
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=2;
            }
        });
        super.add(rojo);
        azul= new JButton("Azul");
        azul.setBounds(Constantes.HEIGHT-10, 170,100, 20);
        azul.setVisible(true);
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=3;
            }
        });
        super.add(azul);
        amarillo= new JButton("Amarillo");
        amarillo.setBounds(Constantes.HEIGHT-10, 200,100, 20);
        amarillo.setVisible(true);
        amarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=4;
            }
        });
        super.add(amarillo);
        verde= new JButton("Verde");
        verde.setBounds(Constantes.HEIGHT-10, 230,100, 20);
        verde.setVisible(true);
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=5;
            }
        });
        super.add(verde);
        
        marron= new JButton("Fucsia");
        marron.setBounds(Constantes.HEIGHT-10, 260,100, 20);
        marron.setVisible(true);
        marron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.c=6;
            }
        });
        super.add(marron);
    }

    
    
    
    
    
    
    
    
}
