package Graficos;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoEventosV2 implements ActionListener {

    private JFrame marco = new JFrame();
    private JPanel lamina = new JPanel();;
    private JButton botonAmarillo = new JButton("Amarillo");
    private JButton botonAzul = new JButton("Azul");
    private JButton botonRojo = new JButton("Rojo");

    public void iniciar(){
        marco.setVisible(true);
        marco.setBounds(200, 200, 200, 200);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        marco.add(lamina);
        lamina.add(botonAmarillo);
        lamina.add(botonAzul);
        lamina.add(botonRojo);
        botonAmarillo.addActionListener(this);
        botonAzul.addActionListener(this);
        botonRojo.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==botonAmarillo)
            lamina.setBackground(Color.YELLOW);
        else if(e.getSource()==botonAzul)
            lamina.setBackground(Color.BLUE);
        else 
            lamina.setBackground(Color.RED);
            
        
    }

    public static void main(String[] args) {
        MarcoEventosV2 mimarco = new MarcoEventosV2();
        mimarco.iniciar();
        
    }
    
}
