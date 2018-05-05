/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yeison
 */
public class Lienzo extends Canvas implements MouseListener, MouseMotionListener {
    
    int x=-1, xf=-1, y=-1, yf=-1,xc=-1,yc=-1;//Coordenadas x es la posicion inicial x, xf la final x y xc es la posicion solo para el clickeo sin drag del mouse
    boolean pintando,cliente;//la bandera cliente la hice con el fin de que funcione el mismo lienzo para el cliente y el servidor
    
    public Lienzo(boolean cliente) {//Constructor
        
        this.cliente=cliente;
        super.setBounds(5,5,460,450);
        super.setBackground(Color.white);
        super.addMouseListener(this);
        addMouseMotionListener(this);
        super.setVisible(true);
    }
    
    @Override
    public void paint( Graphics g){//metodo paint del canvas
        Graphics2D g2= (Graphics2D) g; 
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);
        System.out.println("Pintando "+pintando);
        if(x!=-1 && xf!=-1){            
            g2.drawLine(x, y, xf, yf);            
        }
        if(!pintando){
            g2.drawRect(xc, yc, 0, 0);
            pintando=true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {//evento click del mouse
        if(cliente){
            /*try {
                Socket socketCliente= new Socket("localhost",8081);

                DataOutputStream mensaje = new DataOutputStream(socketCliente.getOutputStream());
                mensaje.writeUTF(xc+","+yc);*/
                 pintando = false;
            xc=e.getX();
            yc=e.getY();
            System.out.println("Presionado");
            paint(this.getGraphics());  
               /* mensaje.close();
            } catch (IOException ex) {
                System.out.println("No se ha conectado mensaje de error: "+ex.getMessage());
            }*/
        }      
    }

    @Override
    public void mousePressed(MouseEvent e) {//evento cuando se deja presionado el click
        if(cliente){
            x=e.getX();
            y=e.getY();       
            paint(this.getGraphics());
        }        
    }

    @Override
    public void mouseReleased(MouseEvent e) {//evento cuando se suelta el click
        if(cliente){
            x=-1;
            xf=-1;
            paint(this.getGraphics());
        }       
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {//evento de arrastre depues de haber clickado
        if (cliente){
            xf=e.getX();
            yf=e.getY();
            paint(this.getGraphics());
            x=e.getX();
            y=e.getY();
        }        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    
    
}
