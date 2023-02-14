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
            while(true){
                Socket misocket=socketServidor.accept();
                DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
                String mensaje = flujo_entrada.readUTF();
                area.append("\n"+mensaje);
                misocket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
