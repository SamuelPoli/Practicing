package Graficos;

import java.awt.*;
import javax.swing.*;

public class MarcoCentrado {
    public static void main(String[] args) {
        MCentrado mimarco = new MCentrado();
    }
}

class MCentrado extends JFrame{
    public MCentrado(){
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