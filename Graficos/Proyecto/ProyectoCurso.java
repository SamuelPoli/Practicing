package Graficos.Proyecto;

import javax.swing.*;

import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;



public class ProyectoCurso {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true); 

    }
}

class Ventana extends JFrame{

    public Ventana(){
        setBounds(200, 200, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Prueba de dialogos");
        Lienzo lienzo = new Lienzo();
        add(lienzo);
    }
}

class Lienzo extends JPanel{

    private JButton boton;
    private ButtonGroup grupo1, grupo2 , grupo3 , grupo4 , grupo5, grupo6;
    private Box caja1, caja2, caja3, caja4, caja5, caja6;
    

    public Lienzo(){
        setLayout(new BorderLayout());

        /*------------------------------ */
        JPanel lienzo1 = new JPanel();
        add(lienzo1, BorderLayout.CENTER);
        lienzo1.setLayout(new GridLayout(2,3));
        
        grupo1= new ButtonGroup();
        grupo2= new ButtonGroup();
        grupo3= new ButtonGroup();
        grupo4= new ButtonGroup();
        grupo5= new ButtonGroup();
        grupo6= new ButtonGroup();
        caja1 = Box.createVerticalBox();
        caja1.setBorder(new TitledBorder("Tipo"));
        caja2 = Box.createVerticalBox();
        caja2.setBorder(new TitledBorder("Tipo de mensaje"));
        caja3 = Box.createVerticalBox();
        caja3.setBorder(new TitledBorder("Mensaje"));
        caja4 = Box.createVerticalBox();
        caja4.setBorder(new TitledBorder("Confirmar"));
        caja5 = Box.createVerticalBox();
        caja5.setBorder(new TitledBorder("Opcion"));
        caja6 = Box.createVerticalBox();
        caja6.setBorder(new TitledBorder("Entrada"));

        crea_boton("Mensaje", 1);
        crea_boton("Confirmar", 1);
        crea_boton("Opción", 1);
        crea_boton("Entrada", 1);
        
        crea_boton("ERROR_MESSAGE", 2);
        crea_boton("INFORMATION_MESSAGE", 2);
        crea_boton("WARNING_MESSAGE", 2);
        crea_boton("QUESTION_MESSAGE", 2);
        crea_boton("PLAIN_MESSAGE", 2);

        crea_boton("Cadena", 3);
        crea_boton("Icono", 3);
        crea_boton("Componente", 3);
        crea_boton("Otros", 3);
        crea_boton("Object", 3);

        crea_boton("DEFAULT_OPTION", 4);
        crea_boton("YES_NO_OPTION", 4);
        crea_boton("YES_NO_CANCEL_OPTION", 4);
        crea_boton("OK_CANCEL_OPTION", 4);

        crea_boton("String", 5);
        crea_boton("Icon", 5);
        crea_boton("Object", 5);

        crea_boton("Campo de texto", 6);
        crea_boton("Combo", 6);
        

        lienzo1.add(caja1);
        lienzo1.add(caja2);
        lienzo1.add(caja3);
        lienzo1.add(caja4);
        lienzo1.add(caja5);
        lienzo1.add(caja6);

        
        


        JPanel lienzo2 = new JPanel();
        boton = new JButton("Aceptar");
        Accion accion = new Accion();
        boton.addActionListener(accion);
        lienzo2.add(boton);
        add(lienzo2, BorderLayout.SOUTH);
    }

    private JRadioButton crea_boton (String nombre, int grupo){

        JRadioButton boton = new JRadioButton(nombre);
        switch (grupo) {
            case 1:
                grupo1.add(boton);
                caja1.add(boton);
                break;
            case 2:
                grupo2.add(boton);
                caja2.add(boton);
                break;
            case 3:
                grupo3.add(boton);
                caja3.add(boton);
                break;
            case 4:
                grupo4.add(boton);
                caja4.add(boton);
                break;
            case 5:
                grupo5.add(boton);
                caja5.add(boton);
                break;
            case 6:
                grupo6.add(boton);
                caja6.add(boton);
                break;
        
            
        }
        return boton;

    }

    private class Accion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(null, "Vas bien");            
        }

    }
}