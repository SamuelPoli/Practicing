package Graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;



public class pruebaImagenes {
    public static void main(String[] args) {
        marcoImagen mimarco = new marcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoImagen extends JFrame{
    public marcoImagen(){
        setTitle("Marco con Imagen");
        setBounds(750,300,300,200);
        LaminaConImagen miLamina = new LaminaConImagen();
        add(miLamina);
        
    }
}

class LaminaConImagen extends JPanel {

    //Cargar imagen en memoria mediante el constructor
    public LaminaConImagen(){
        //File miimagen = new File("C:/Users/001TIC981/Documents/Practicing/Graficos/icono.png");
        
        try {
            imagen=ImageIO.read(new File("C:/Users/001TIC981/Documents/Practicing/Graficos/pin2.png"));
        } catch (IOException e) {
            
            System.out.println("Error en carga de imagen");
        }
    }

    //Acá si se pinta la imagen
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int ancho = imagen.getWidth(this);
        int altura = imagen.getHeight(this);
        
        g.drawImage(imagen, 0, 0, null);
        for(int i=0; i<100; i++){
            for (int j = 0; j < 100; j++) {
                g.copyArea(0, 0, ancho, altura, ancho*i, altura*j);                
            }
        }

    }

    private Image imagen;
}