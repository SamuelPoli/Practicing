package Graficos;

import javax.swing.JFrame;
import java.awt.event.*;

public class Eventos_ventana {
    
    public static void main(String[] args) {
        MarcoVentana mimarco = new MarcoVentana();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setTitle("Ventana 1");
        mimarco.setBounds(200, 300, 500, 350);
        MarcoVentana mimarco2 = new MarcoVentana();
        mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mimarco2.setTitle("Ventana 2");
        mimarco2.setBounds(800, 300, 500, 350);
    }
}

class MarcoVentana extends JFrame{
    public MarcoVentana(){
        setVisible(true);
        //setBounds(100,100,250,250);
        
        //M_Ventana oyente = new M_Ventana();
        /*Acá se especifica una clase diferente
        la cual estará a la escucha y realizará los 
        eventos por lo cual no se añade el evento con 
        this, aunque también hay que tener en cuenta
        que no estamos añadiendo un boton que desencadene 
        una accion sino utilizando los eventos de la
        ventana
        */
        //addWindowListener(oyente);
        addWindowListener(new M_Ventana());
          
    }
}

/*Usando clase adaptadora para no tener que implementar todos
los metodos de la interfaz*/
class M_Ventana extends WindowAdapter{
    public void windowIconified(WindowEvent e) {
        
        System.out.println("Ventana minimizada");
    }
}
/*implementando la interfaz completa
class M_Ventana implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana abierta");
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando ventana");
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("La ventana ha sido cerrada");
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
        System.out.println("Ventana minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana restaurada");
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        System.out.println("Ventana Activada");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
       System.out.println("Ventana desactivada");
        
    }

}
*/