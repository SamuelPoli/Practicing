package Graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


public class pruebaDibujo3 {
    public static void main(String[] args) {
        marcoConFuente mimarco = new marcoConFuente();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcoConFuente extends JFrame{
    public marcoConFuente(){
        setTitle("Prueba de Fuente");
        setSize(400, 400);
        LaminaConFuente miLamina = new LaminaConFuente();
        add(miLamina);
        
        //Color por defecto de la lamina
        //Tener en cuenta que en el metodo paintComponent
        //se está coloreando nuevamente
        miLamina.setForeground(Color.ORANGE);
    }
}

class LaminaConFuente extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Font mifuente = new Font("Times new Roman", Font.BOLD, 26);
        g2.setFont(mifuente);
        g2.setColor(Color.YELLOW);
        g2.drawString("Hola malparido", 100, 100);
        
        g2.setFont(new Font("Arial", Font.ITALIC, 8));
        g2.setColor(new Color(150, 80, 50).brighter());
        g2.drawString("Curso de Java", 150, 200);

    }
}