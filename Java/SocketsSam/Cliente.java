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

class Lienzo extends JPanel implements Runnable{
    private JTextArea campochat;
    private JTextField campo, nick, ip;

    public Lienzo(){
        JLabel etiqueta = new JLabel("-Chat-");
        campochat = new JTextArea();
        campo = new JTextField(20);
        nick = new JTextField();
        ip = new JTextField();
        JButton boton = new JButton("Enviar");
        add(nick);
        add(etiqueta);
        add(ip);
        add(campochat);
        add(campo);
        add(boton);
        boton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                campochat.append("\n" + nick.getText()+": "+ campo.getText());
                try {
                    Socket misocket = new Socket("192.168.0.7", 9999);
                    PaqueteEnvio datos = new PaqueteEnvio();
                    datos.setNick(nick.getText());
                    datos.setIp(ip.getText());
                    datos.setMensaje(campo.getText());
                    ObjectOutputStream paquetedatos = new ObjectOutputStream(misocket.getOutputStream());
                    paquetedatos.writeObject(datos);
                    
                /*    DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                    flujo_salida.writeUTF(campo.getText());
                    flujo_salida.close();*/
                    paquetedatos.close();
                    misocket.close();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                } 
                
            }

        });
        Thread mihilo = new Thread(this);
        mihilo.start();

    }

    @Override
    public void run() {
        try {
            ServerSocket servidor_cliente = new ServerSocket(9090);
            String nick, ip, mensaje;
            PaqueteEnvio paqueteRecibido;

            while(true){
                Socket cliente=servidor_cliente.accept();
                ObjectInputStream paquetedatos = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) paquetedatos.readObject();
                nick= paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();
                campochat.append("\n"+ nick +": "+mensaje);
                cliente.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

class PaqueteEnvio implements Serializable{
    
    private String nick, ip, mensaje;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}