package Java.Archivos_Directorios.Proyecto;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;

public class Renombrador {
    public static void main(String[] args) {

        Marco VentanaPrograma = new Marco();
        VentanaPrograma.setVisible(true);  
    }
}

class Marco extends JFrame{

    public Marco(){
        setBounds(200,200,800,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Lamina lienzo = new Lamina();
        add(lienzo);
    }
}

class Lamina extends JPanel{

    private JButton boton;
    private JTextField Campo1, Campo2, Campo3;
    private JLabel Etiqueta1, Etiqueta2, Etiqueta3;
    private Box Caja1, Caja2, Caja3, Caja4;

    public Lamina(){
        setLayout(new GridLayout(4, 1));
        Caja1 = Box.createVerticalBox();
        Caja2 = Box.createVerticalBox();
        Caja3 = Box.createVerticalBox();
        Caja4 = Box.createVerticalBox();
        Etiqueta1 = new JLabel("Ingrese la ruta: ");
        Campo1 = new JTextField();
        Caja1.add(Etiqueta1);
        Caja1.add(Campo1);

        Etiqueta2 = new JLabel("Ingrese el numero del radicado: ");
        Campo2 = new JTextField();
        Caja2.add(Etiqueta2);
        Caja2.add(Campo2);

        Etiqueta3 = new JLabel("Ingrese el numero del consecutivo: ");
        Campo3 = new JTextField();
        Caja3.add(Etiqueta3);
        Caja3.add(Campo3);

        boton = new JButton("Aceptar");
        Caja4.add(boton);

        add(Caja1);
        add(Caja2);
        add(Caja3);
        add(Caja4);
    
        boton.addActionListener(new AccionBoton());

    }
    private class AccionBoton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String ruta=Campo1.getText();
        String radicado = Campo2.getText();
        String consecutivo = Campo3.getText();
        
        CambiaNombre.renombrar(ruta,radicado,consecutivo);
        
        }

    }
}

class CambiaNombre{

    public static void renombrar(String ruta, String radicado, String consecutiv){
        try{
        File ruta_modificar = new File(ruta);
        File[] nombres_archivos = ruta_modificar.listFiles();
        //System.out.println(ruta_modificar.getAbsolutePath());
        int consecutivo = Integer.parseInt(consecutiv);
        int rad = Integer.parseInt(radicado);
        for (File s : nombres_archivos) {
            String nuevo_nombre = ruta.concat(File.separator).concat(Integer.toString(rad)).concat("_").concat(Integer.toString(consecutivo)).concat("_").concat(s.getName());
            s.renameTo(new File(nuevo_nombre));
            //System.out.println(nuevo_nombre);
            consecutivo++;
            }
            JOptionPane.showMessageDialog(null, "Se han actualizado los nombres de los archivos indicados en la ruta");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido el siguiente error: "+e.getMessage());
        }
        
    }
}