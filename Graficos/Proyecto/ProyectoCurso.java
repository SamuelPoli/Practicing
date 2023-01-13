package Graficos.Proyecto;

import javax.swing.*;

import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;




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
    private JRadioButton[] botones;
    

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

        botones=new JRadioButton[23];

        crea_boton("Mensaje", 1, 0);
        crea_boton("Confirmar", 1, 1);
        crea_boton("Opción", 1, 2);
        crea_boton("Entrada", 1, 3);
        
        crea_boton("ERROR_MESSAGE", 2, 4);
        crea_boton("INFORMATION_MESSAGE", 2, 5);
        crea_boton("WARNING_MESSAGE", 2, 6);
        crea_boton("QUESTION_MESSAGE", 2, 7);
        crea_boton("PLAIN_MESSAGE", 2, 8);

        crea_boton("Cadena", 3, 9);
        crea_boton("Icono", 3, 10);
        crea_boton("Componente", 3, 11);
        crea_boton("Otros", 3, 12);
        crea_boton("Object[]", 3, 13);

        crea_boton("DEFAULT_OPTION", 4, 14);
        crea_boton("YES_NO_OPTION", 4, 15);
        crea_boton("YES_NO_CANCEL_OPTION", 4, 16);
        crea_boton("OK_CANCEL_OPTION", 4, 17);

        crea_boton("String[]", 5, 18);
        crea_boton("Icon[]", 5, 19);
        crea_boton("Object[]", 5, 20);

        crea_boton("Campo de texto", 6, 21);
        crea_boton("Combo", 6, 22);
        

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

    private JRadioButton crea_boton (String nombre, int grupo, int num){

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
        botones[num]=boton;
        return boton;

    }

    private class Accion extends JOptionPane implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showConfirmDialog(null, "Vas bien"); 

            int contador = 1;
            String op1 ="", op2="", op3="", op4="", op5="", op6="";
            for (JRadioButton b : botones) {

                if(b.isSelected()){
                    if(contador==1){
                        op1=b.getText();
                        contador++;
                    } else if(contador==2){
                        op2=b.getText();
                        contador++;
                    }else if(contador==3){
                        op3=b.getText();
                        contador++;
                    }else if(contador==4){
                        op4=b.getText();
                        contador++;
                    }else if(contador==5){
                        op5=b.getText();
                        contador++;
                    }else if(contador==6){
                        op6=b.getText();
                    }
                }
            
            }
            
            int tipo = 0;
            switch (op2) {
                case "ERROR_MESSAGE":
                    tipo = 0;
                    break;
                case "INFORMATION_MESSAGE":
                    tipo=1;
                    break;
                case "WARNING_MESSAGE":
                    tipo=2;
                    break;
                case "QUESTION_MESSAGE":
                    tipo=3;
                    break;
                case "PLAIN_MESSAGE":
                    tipo = 4;
                    break;

            }
            Object mensaje = null;
            JPanel panel = new JPanel();
            Date fecha = new Date();
            panel.setBackground(Color.BLACK);
            switch (op3) {
                case "Cadena":
                    mensaje = "Mensaje";
                    break;
                case "Icono":
                    mensaje = "Todavia no hay icono";
                    break;
                case "Componente":
                    mensaje = panel;
                    break;
                case "Otros":
                    mensaje = fecha;
                    break;
                case "Object[]":
                    Object[] objeto = {"Mensaje","Todavia no hay icono",panel,fecha};
                    mensaje = objeto;
                    break;

            }

            int confirmar = 0;
            switch (op4) {
                case "DEFAULT_OPTION":
                    confirmar = 0;
                    break;
                case "YES_NO_OPTION":
                    confirmar=1;
                    break;
                case "YES_NO_CANCEL_OPTION":
                    confirmar=2;
                    break;
                case "OK_CANCEL_OPTION":
                    confirmar=3;
                    break;
                

            }

            Object[] opcion = null;
            switch (op5) {
                case "String[]":
                    String[] opciones={"Amarillo", "Azul","Rojo"};
                    opcion = opciones;
                    break;
                case "Icon[]":

                    opcion=null;
                    break;
                case "Object[]":
                    Object[] opcionesO={"Hola",panel,fecha};
                    opcion=opcionesO;
                    break;
                

            }

            String[] items = {"Amarillo", "Azul","Rojo"};
            //JComboBox combo = new JComboBox(items);

            switch (op1) {
                case "Mensaje":
                    JOptionPane.showMessageDialog(null, mensaje, op1, tipo);
                    break;
                case "Confirmar":
                    JOptionPane.showConfirmDialog(null, mensaje, op1, confirmar,tipo);
                    break;
                case "Opción":
                    JOptionPane.showOptionDialog(null, mensaje, op1, confirmar, tipo,
                    null, opcion, null);
                    break;
                case "Entrada":
                    if(op6.equals("Campo de texto"))
                    JOptionPane.showInputDialog(null, mensaje, op1, tipo);
                    if(op6.equals("Combo"))
                    JOptionPane.showInputDialog(null, mensaje, op1, tipo,null,items,null);
                    break;
            }
        }

    }
}