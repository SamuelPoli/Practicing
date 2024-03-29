package Java.SocketsSam;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class ClienteProfe {
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
    private JTextField campo;
    private JLabel nick;
    private ArrayList<UsuariosConectados> usuarios, lista2;
    private JComboBox combo;
    private UsuariosConectados info;

    public Lienzo(String nick){
        JLabel etiqueta = new JLabel("-Chat-");
        campochat = new JTextArea();
        campo = new JTextField(20);
        this.nick = new JLabel(nick);
      
        combo = new JComboBox<String>();
        JButton boton = new JButton("Enviar");
        add(this.nick);
        add(etiqueta);
        add(combo);
        add(campochat);
        add(campo);
        add(boton);
        
        lista2 = new ArrayList<UsuariosConectados>();
        Socket misocket1;
        try {
            misocket1 = new Socket("10.1.0.4", 9090);
            info = new UsuariosConectados();
            info.setNick(this.nick.getText());
        
            String miIp = misocket1.getLocalAddress().toString();
            System.out.println(info.getNick()+" "+
                miIp.substring(1));
            info.setIp(miIp.substring(1));
        
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
                String nickSeleccion = (String) combo.getSelectedItem();
                String ipEnvio="";
                for (UsuariosConectados x : lista2) {
                    if(nickSeleccion.equalsIgnoreCase(x.getNick())){
                        ipEnvio=x.getIp();
                    }
                }
                try {
                    Socket misocket = new Socket("10.1.0.4", 9999);
                    PaqueteEnvio datos = new PaqueteEnvio();
                    datos.setNick(Lienzo.this.nick.getText());
                    datos.setIp(ipEnvio);
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
        Thread hilo2 = new Thread(new HiloUsuarios());
        hilo2.start();

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

    public class HiloUsuarios implements Runnable {

        @Override
        public void run() {
            try {
            //Socket que va a estar recibiendo la lista de usuarios conectados
            ServerSocket servidor_usuarios = new ServerSocket(9000);
            
            //Recibir listado del servidor 
            while(true){    
                Socket usuarios_serv=servidor_usuarios.accept();
                ObjectInputStream usuariosConect = new ObjectInputStream(usuarios_serv.getInputStream());
                usuarios = (ArrayList<UsuariosConectados>) usuariosConect.readObject();

                //Evaluar si la lista está vacía y añadir los usuarios
                if(lista2.size()==0){
                    for (UsuariosConectados e : usuarios) {
                        if(e.getNick()!=Lienzo.this.nick.getText()){
                            lista2.add(e);
                        }
                    }
                }else{
                //Si la lista no está vacía comienza a comparar si los usuarios ya están añadidos
                // y añade solo los usuarios que no coincidan
                for (UsuariosConectados e : usuarios) {
                    for (UsuariosConectados i : lista2) {
                        if(e.getNick()!=i.getNick()){
                            lista2.add(e);
                        }
                    }
                }}
                
                //añadir usuarios al combobox
                for (UsuariosConectados e : lista2) {
                    if(e.getNick().equals(Lienzo.this.nick.getText()))
                    return;
                    else{
                    
                    combo.addItem(e.getNick());
                    
                    }
                }

                usuariosConect.close();
                usuarios_serv.close();
            }
            } catch (Exception e) {
                
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