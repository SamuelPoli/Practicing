package Java.Graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class pruebaDibujo {
    public static void main(String[] args) {
        marcoConDibujos mimarco = new marcoConDibujos();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoConDibujos extends JFrame{
    public marcoConDibujos(){
        setTitle("Prueba de Dibujos");
        setSize(400, 400);
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
    }
}

class LaminaConFiguras extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /*g.drawRect(100, 50, 200, 200);
        g.drawLine(10, 10, 30, 20);
        g.drawArc(80, 90, 100, 150, 0, 180);*/
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,150);
        g2.draw(rectangulo);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);
        g2.draw(new Line2D.Double(100,100,300,250));
        double CentroenX=rectangulo.getCenterX();
        double CentroenY=rectangulo.getCenterY();
        double radio=rectangulo.getWidth()/2+30;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX+radio, CentroenY+radio);
        g2.draw(circulo);
    }
}