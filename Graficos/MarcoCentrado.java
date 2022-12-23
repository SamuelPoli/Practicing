package Graficos;

import java.awt.*;
import javax.swing.*;

public class MarcoCentrado {
    public static void main(String[] args) {
        MCentrado mimarco = new MCentrado();
        mimarco.iniciar();
    }
}

class MCentrado extends JFrame{
    
    /*Se puede incluir la misma información del
     * metodo iniciar en el constructor y en el main
     * ya no sería necesario llamar al metodo iniciar
     * sino solamente construir el objeto
     */
    public MCentrado(){
        
    }

    public void iniciar(){
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        int anchoPantalla = tamanoPantalla.width;
        int alturaPantalla = tamanoPantalla.height;
        setSize(anchoPantalla/2, alturaPantalla/2);
        setLocation(anchoPantalla/4, alturaPantalla/4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Marco Centrado");
        //Averiguar como cambiar direccion relativa
        Image miIcono=mipantalla.getImage("C:/Users/001TIC981/Documents/Practicing/Graficos/icono.png");
        setIconImage(miIcono);
    }
}