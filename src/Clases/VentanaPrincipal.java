/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import ClienteServidor.PaintCliente;
import ClienteServidor.PaintServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author yeisonryhn
 */
public class VentanaPrincipal extends JFrame {
    JPanel p;
    JButton clienteb, servidorb;
    public boolean cl=false,sr,boton,boton2,escuchar;    
    PaintCliente cliente;
    PaintServidor servidor;
    
    public VentanaPrincipal(){
        super.setTitle("Paint");
        crearMenu();
        
        boton=false;
        boton2=false;
        escuchar=true;
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        super.setBounds(0, 0, Constantes.WIDTH, Constantes.HEIGHT);
        super.setResizable(false);
        super.setVisible(true);  
        super.add(p);  
    }
    
    public void crearMenu(){

        p=new JPanel();
        p.setBounds(0, 0, Constantes.WIDTH,Constantes.HEIGHT);
        p.setVisible(true);
        p.setLayout(null);        
        clienteb=new JButton("Cliente");        
        clienteb.setBounds(130, 180,Constantes.WIDTHBUTTON, Constantes.HEIGTHBUTTON);
        clienteb.setVisible(true);        
        servidorb=new JButton("Servidor");
        servidorb.setBounds(330, 180,Constantes.WIDTHBUTTON, Constantes.HEIGTHBUTTON);
        servidorb.setVisible(true);
        
        clienteb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
               
                cliente= new PaintCliente();                
                removerBotones();
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                setSize(Constantes.WIDTH-87, Constantes.HEIGHT);       
                setTitle("Cliente");
                add(cliente);        
            }
        });      
        
        servidorb.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                servidor= new PaintServidor();
                removerBotones();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                setSize(Constantes.WIDTH+20, Constantes.HEIGHT);      
                setTitle("Servidor");
                add(servidor);
            }
        });   
        
        p.add(servidorb);
        p.add(clienteb);       
    }
    
    public void removerBotones(){
        p.setVisible(false);
        super.remove(p);
    }
    
}