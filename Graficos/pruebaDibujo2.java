package Graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class pruebaDibujo2 {
    public static void main(String[] args) {
        marcoConColor mimarco = new marcoConColor();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoConColor extends JFrame{
    public marcoConColor(){
        setTitle("Prueba de Color");
        setSize(400, 400);
        LaminaConColor miLamina = new LaminaConColor();
        add(miLamina);
        miLamina.setBackground(SystemColor.window);
    }
}

class LaminaConColor extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /*g.drawRect(100, 50, 200, 200);
        g.drawLine(10, 10, 30, 20);
        g.drawArc(80, 90, 100, 150, 0, 180);*/
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
        //Colorea el borde
        g2.setPaint(Color.ORANGE);
        g2.draw(rectangulo);
        //establecer color con constructor RGB
        //el brigther y darker se puede aplicar varias veces
        //con fill colorea el relleno
        g2.setPaint(new Color(109,172,59).brighter());
        g2.fill(rectangulo);

        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        //establecer color predeterminado en la clase Color
        g2.setPaint(Color.RED);
        g2.fill(elipse);
        
    }
}