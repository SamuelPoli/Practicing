package Java.SocketsSam;

import javax.swing.*;

import java.io.*;
import java.net.*;
import java.awt.*;

public class Servidor {
    public static void main(String[] args) {
        MarcoServidor v = new MarcoServidor();
        v.setVisible(true);
    }
}

class MarcoServidor extends JFrame implements Runnable{
    private JTextArea area;
    public MarcoServidor(){

        setBounds(300, 100, 250, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel lamina = new JPanel();
        lamina.setLayout(new BorderLayout());
        area = new JTextArea();
        lamina.add(area, BorderLayout.CENTER);
        add(lamina);
        Thread mihilo = new Thread(this);
        mihilo.start();
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
}
