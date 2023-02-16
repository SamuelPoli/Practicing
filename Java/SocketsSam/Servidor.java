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
    }

    @Override
    public void run() {
        try {
            ServerSocket socketServidor = new ServerSocket(9999);
            ServerSocket socketServidor2 = new ServerSocket(9090);
            String nick, ip, mensaje;
            UsuariosConectados usuario;
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
                
                //Recibir usuarios conectados y reenviarlos
                Socket misocketUsuarios=socketServidor2.accept();
                ObjectInputStream infousuarios = new ObjectInputStream(misocketUsuarios.getInputStream());
                usuario = (UsuariosConectados) infousuarios.readObject();
                
                listadoUsuarios.add(usuario);
                
                for (UsuariosConectados e : listadoUsuarios) {
                    Socket enviaUsuario = new Socket(e.getIp(), 9000);
                    ObjectOutputStream paqueteUsuario = new ObjectOutputStream(enviaUsuario.getOutputStream());
                    paqueteUsuario.writeObject(listadoUsuarios);
                    enviaUsuario.close();
                    paqueteUsuario.close();
                }

                paquetereenvio.close();
                enviaDestinatario.close();
                misocket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
