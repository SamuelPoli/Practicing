package Java.SocketsSam;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class Cliente {
    public static void main(String[] args) {
        Marco v = new Marco();
        v.setVisible(true);
    }
   
}   

class Marco extends JFrame{

    public Marco(){

        setBounds(100, 100, 250, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lienzo l = new Lienzo();
        add(l);
    }
}

class Lienzo extends JPanel{
    public Lienzo(){
        JLabel etiqueta = new JLabel("Cliente");
        JTextField campo = new JTextField(20);
        JButton boton = new JButton("Enviar");
        add(etiqueta);
        add(campo);
        add(boton);
        boton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket misocket = new Socket("192.168.0.7", 9999);
                    DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                    flujo_salida.writeUTF(campo.getText());
                    flujo_salida.close();
                    misocket.close();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                } 
                
            }

        });

    }
}