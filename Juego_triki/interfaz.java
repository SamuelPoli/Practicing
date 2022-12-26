package Juego_triki;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class interfaz {
    
    private JFrame marco;

    public void iniciar(){
        marco = new JFrame();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina lamina = new Lamina();
        marco.add(lamina);
        marco.setBounds(200, 200, 250, 250);
       

    }

    private class Lamina extends JPanel implements ActionListener{

        private JButton boton1;
        private JButton boton2;
        private JButton boton3;
        private JButton boton4;
        private JButton boton5;
        private JButton boton6;
        private JButton boton7;
        private JButton boton8;
        private JButton boton9;
        
        public Lamina(){
            setLayout(new GridLayout(3,3));
            boton1 = new JButton();
            boton2 = new JButton();
            boton3 = new JButton();
            boton4 = new JButton();
            boton5 = new JButton();
            boton6 = new JButton();
            boton7 = new JButton();
            boton8 = new JButton();
            boton9 = new JButton();
            add(boton1);
            add(boton2);
            add(boton3);
            add(boton4);
            add(boton5);
            add(boton6);
            add(boton7);
            add(boton8);
            add(boton9);
            boton1.addActionListener(this);
            boton2.addActionListener(this);
            boton3.addActionListener(this);
            boton4.addActionListener(this);
            boton5.addActionListener(this);
            boton6.addActionListener(this);
            boton7.addActionListener(this);
            boton8.addActionListener(this);
            boton9.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Funciona correctamente "+e.getSource().toString());
        }

    }
}
