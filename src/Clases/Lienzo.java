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
    
    public int x=-1, xf=-1, y=-1, yf=-1,xc=-1,yc=-1;//Coordenadas x es la posicion inicial x, xf la final x y xc es la posicion solo para el clickeo sin drag del mouse
    public boolean pintando,cliente;//la bandera cliente la hice con el fin de que funcione el mismo lienzo para el cliente y el servidor
    public int c=1;
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
        
        if(c==0){
            g2.setStroke(new BasicStroke(10));
            g2.setColor(Color.WHITE);
        }else g2.setStroke(new BasicStroke(2));
        
        if(c==1){
            g2.setColor(Color.BLACK);
        }else if(c==2){
            g2.setColor(Color.RED);
        }else if(c==3){
            g2.setColor(Color.BLUE);
        }else if(c==4){
            g2.setColor(Color.YELLOW);
        }else if(c==5){
            g2.setColor(Color.GREEN);
        }else if(c==6){
            g2.setColor(Color.magenta);
        }
        
        if(x!=-1 && xf!=-1){            
            g2.drawLine(x, y, xf, yf);            
        }
        if(!pintando){
            g2.fillOval(xc, yc, 4, 4);
            pintando=true;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {//evento click del mouse
        if(cliente){
            pintando = false;
            xc=e.getX();
            yc=e.getY();
            sendData();
            paint(this.getGraphics());            
            xc=-1;
            yc=-1;
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
            sendData();
            paint(this.getGraphics());
        }       
    }   
    
    @Override
    public void mouseDragged(MouseEvent e) {//evento de arrastre depues de haber clickado
        if (cliente){
            xf=e.getX();
            yf=e.getY();
            sendData();
            paint(this.getGraphics());
            x=e.getX();
            y=e.getY();
            sendData();
        }        
    }
    public void sendData(){
        try {        
                Socket socketCliente= new Socket("localhost",8081);
                DataOutputStream mensaje = new DataOutputStream(socketCliente.getOutputStream()); 
                mensaje.writeUTF(x+","+y+","+xf+","+yf+","+xc+","+yc+","+pintando+","+c);
                mensaje.close();                                 
            }catch (IOException ex) {
                System.out.println("No se ha conectado mensaje de error: "+ex.getMessage());
            }
    }
    
     @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
     @Override
    public void mouseMoved(MouseEvent e) {
    }      
}