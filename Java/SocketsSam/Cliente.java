package Java.SocketsSam;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


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
        String nick = JOptionPane.showInputDialog(this, "Ingrese nick");
        Lienzo l = new Lienzo(nick);
        add(l);
    }
}

class Lienzo extends JPanel implements Runnable{
    private JTextArea campochat;
    private JTextField campo, ip;
    private JLabel nick;
    private ArrayList<UsuariosConectados> usuarios;
    private JComboBox combo;

    public Lienzo(String nick){
        JLabel etiqueta = new JLabel("-Chat-");
        campochat = new JTextArea();
        campo = new JTextField(20);
        this.nick = new JLabel(nick);
        ip = new JTextField(10);
        combo = new JComboBox<UsuariosConectados>();
        JButton boton = new JButton("Enviar");
        add(this.nick);
        add(etiqueta);
        add(ip);
        add(campochat);
        add(campo);
        add(boton);
        add(combo);
        Socket misocket1;
        try {
            misocket1 = new Socket("192.168.0.7", 9090);
            UsuariosConectados info = new UsuariosConectados();
            info.setNick(this.nick.getText());
        
            String miIp = misocket1.getInetAddress().toString();
            System.out.println(info.getNick()+" "+
                miIp.substring(1));
            info.setIp(miIp);
        
            ObjectOutputStream infoUsuario = new ObjectOutputStream(misocket1.getOutputStream());
            infoUsuario.writeObject(info);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        boton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                campochat.append("\n" + Lienzo.this.nick.getText()+": "+ campo.getText());
                try {
                    Socket misocket = new Socket("192.168.0.7", 9999);
                    PaqueteEnvio datos = new PaqueteEnvio();
                    datos.setNick(Lienzo.this.nick.getText());
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
            ServerSocket servidor_usuarios = new ServerSocket(9000);
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

                //Recibir listado del servidor 
                Socket usuarios_serv=servidor_usuarios.accept();
                ObjectInputStream usuariosConect = new ObjectInputStream(usuarios_serv.getInputStream());
                usuarios = (ArrayList<UsuariosConectados>) usuariosConect.readObject();
                //añadir usuarios al combobox
                for (UsuariosConectados e : usuarios) {
                    combo.addItem(e.getNick());
                }

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