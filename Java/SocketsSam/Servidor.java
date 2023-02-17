package Java.SocketsSam;

import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class Servidor {
    public static void main(String[] args) {
        MarcoServidor v = new MarcoServidor();
        v.setVisible(true);
    }
}

class MarcoServidor extends JFrame implements Runnable{
    private JTextArea area;
    private ArrayList<UsuariosConectados> listadoUsuarios;
    public MarcoServidor(){

        setBounds(300, 100, 250, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel lamina = new JPanel();
        lamina.setLayout(new BorderLayout());
        area = new JTextArea();
        lamina.add(area, BorderLayout.CENTER);
        add(lamina);
        listadoUsuarios = new ArrayList<UsuariosConectados>();
        Thread mihilo = new Thread(this);
        mihilo.start();
        Thread hilo2= new Thread(new HiloUsuarios());
        hilo2.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket socketServidor = new ServerSocket(9999);
            
            String nick, ip, mensaje;
            
            PaqueteEnvio paqueteRecibido;


            while(true){
                Socket misocket=socketServidor.accept();
                ObjectInputStream paquetedatos = new ObjectInputStream(misocket.getInputStream());
                paqueteRecibido = (PaqueteEnvio) paquetedatos.readObject();
                nick= paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();

                /*DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
                String mensaje = flujo_entrada.readUTF();
                area.append("\n"+mensaje);*/

                area.append("\n"+ nick +": "+mensaje+" para "+ip);
                
                Socket enviaDestinatario = new Socket(ip, 9090);
                ObjectOutputStream paquetereenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                paquetereenvio.writeObject(paqueteRecibido);
                
                
                paquetereenvio.close();
                enviaDestinatario.close();
                misocket.close();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public class HiloUsuarios implements Runnable{

        @Override
        public void run() {
            //Abrir socket server para recibir conexiones
            try{
            ServerSocket socketServidor2 = new ServerSocket(9090);
            UsuariosConectados usuario;
            //Recibir usuarios conectados y reenviarlos
            while (true) {
                Socket misocketUsuarios=socketServidor2.accept();
                ObjectInputStream infousuarios = new ObjectInputStream(misocketUsuarios.getInputStream());
                usuario = (UsuariosConectados) infousuarios.readObject();
                area.append("Ha iniciado sesión el usuario: "+usuario.getNick()+
                " "+usuario.getIp()+"\n");
            
                listadoUsuarios.add(usuario);
                for (UsuariosConectados e : listadoUsuarios) {
                System.out.println(e.getNick());
                Socket enviaUsuario = new Socket(e.getIp(), 9000);
                ObjectOutputStream paqueteUsuario = new ObjectOutputStream(enviaUsuario.getOutputStream());
                paqueteUsuario.writeObject(listadoUsuarios);
                enviaUsuario.close();
                paqueteUsuario.close();
                
            }
           
            misocketUsuarios.close();
            infousuarios.close();
            }
            
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            
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

