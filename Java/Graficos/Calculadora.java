package Java.Graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {
    public static void main(String[] args) {
        marcoCalculadora micalculadora = new marcoCalculadora();
        micalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        micalculadora.setVisible(true);
    
    }

    
}

class marcoCalculadora extends JFrame{

    public marcoCalculadora(){
        setTitle("Calculadora");
        //setBounds(500, 300, 450, 300);
        lamina1Calculadora milamina = new lamina1Calculadora();
        add(milamina);
        pack();
        
    }
}

class lamina1Calculadora extends JPanel{
    public lamina1Calculadora(){
        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);
        lamina2 = new JPanel();
        lamina2.setLayout(new GridLayout(4,4));
        /* Agregar botones manualmente 
        JButton boton1 = new JButton("1");
        lamina2.add(boton1);
        JButton boton2 = new JButton("2");
        lamina2.add(boton2);
        */
        ponerBoton("7");
        ponerBoton("8");
        ponerBoton("9");
        ponerBoton("/");
        ponerBoton("4");
        ponerBoton("5");
        ponerBoton("6");
        ponerBoton("*");
        ponerBoton("1");
        ponerBoton("2");
        ponerBoton("3");
        ponerBoton("-");
        ponerBoton("0");
        ponerBoton(".");
        ponerBoton("=");
        ponerBoton("+");
        add(lamina2, BorderLayout.CENTER);

    }

    private void ponerBoton(String rotulo){
        JButton boton = new JButton(rotulo);
        InsertarNumero cambianumero = new InsertarNumero();
        boton.addActionListener(cambianumero);
        lamina2.add(boton);
    }

    private class InsertarNumero implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String entrada = e.getActionCommand();
            pantalla.setText(entrada);
        }

    }

    private JPanel lamina2;
    private JButton pantalla;
}

