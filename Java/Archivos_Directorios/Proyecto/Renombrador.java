package Java.Archivos_Directorios.Proyecto;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Renombrador {
    public static void main(String[] args) {

        Marco VentanaPrograma = new Marco();
        VentanaPrograma.setVisible(true);

        
    }
}

class Marco extends JFrame{

    public Marco(){
        setBounds(200,200,500,300);
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
    
        boton.adddactionlistener(new AccionBoton());

    }
    private class AccionBoton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        String ruta=Campo1.gettext();
        String radicado = Campo2.gettext();
        String consecutivo = Campo3.gettext();

        CambiaNombre.renombrar(ruta,radicado,consecutiv);   
            
        }

    }
}

class CambiaNombre{

private static renombrar(String ruta, String radicado, String consecutiv){
}
}