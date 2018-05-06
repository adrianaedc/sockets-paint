/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import Clases.Lienzo;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.StringTokenizer;
import javax.swing.*;

/**
 *
 * @author Yeison
 */
public class PaintServidor extends JPanel implements Runnable{
    
    Lienzo lienzo;
    String cadena;
    Thread hiloEscucha;   
    
    public PaintServidor() {        
        super.setBounds(0, 0, 480, 480);
        super.setVisible(true);
        super.setLayout(null);
        lienzo=new Lienzo(false);   
        super.add(lienzo);
        hiloEscucha= new Thread(this);
        hiloEscucha.start();
    }
       
    

    @Override
    public void run() {
        try {
            ServerSocket servidor=new ServerSocket(8081);
            while(true){
                
                Socket miSocket= servidor.accept();            
                DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                cadena= flujoEntrada.readUTF();
                StringTokenizer tok=new StringTokenizer(cadena, ",");
                //System.out.println("Cantidad de Tokens: "+tok.countTokens());
                lienzo.x=Integer.parseInt(tok.nextToken());
                lienzo.y=Integer.parseInt(tok.nextToken());
                lienzo.xf=Integer.parseInt(tok.nextToken());
                lienzo.yf=Integer.parseInt(tok.nextToken());
                lienzo.xc=Integer.parseInt(tok.nextToken());
                lienzo.yc=Integer.parseInt(tok.nextToken());
                lienzo.pintando=Boolean.parseBoolean(tok.nextToken());
                //System.out.println("Coordenadas"+cadena);
                lienzo.paint(lienzo.getGraphics());
                miSocket.close();
            }            
                    
            //System.out.println("Estoy escuchando");
        } catch (IOException ex) {
            System.out.println("No se pudo conectar mensaje: " +ex.getMessage());
        }
        }
}