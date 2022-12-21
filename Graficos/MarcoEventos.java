package Graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MarcoEventos {
    
    public static void main(String[] args) {
        MarcoConTexto mimarco = new MarcoConTexto();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoConTexto extends JFrame{
    public MarcoConTexto(){
        setVisible(true);
        setBounds(600, 300, 250, 250);
        LaminaBotones milamina = new LaminaBotones();
        add(milamina);
    }
}

class LaminaBotones extends JPanel implements ActionListener{

    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");

    public LaminaBotones(){
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        //1 Objeto Evento: Action
        //2 Objeto Fuente: botonAzul
        //3 Objeto Listener: this
        botonAzul.addActionListener(this);
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object botonPulsado=e.getSource();

        if(botonPulsado==botonAzul)
            setBackground(Color.BLUE);
        else if (botonPulsado==botonAmarillo)
            setBackground(Color.YELLOW);
        else
            setBackground(Color.RED);
        
        
    }

}