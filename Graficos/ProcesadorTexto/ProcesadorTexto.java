package Graficos.ProcesadorTexto;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.*;
import java.awt.event.*;

public class ProcesadorTexto{

    public static void main(String[] args) {
        Marco_Texto marco = new Marco_Texto();

    }

    
    
}


class Marco_Texto extends JFrame{

    public Marco_Texto(){
        setBounds(300,300,200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Lamina_Texto());
        setVisible(true);
    }

}

class Lamina_Texto extends JPanel{

    private JMenuBar barra;
    private JTextPane texto;
    private JMenu fuente, estilo, tamano;
    private JMenuItem courier, arial, verdana, negrita, cursiva, diez, catorce, dieciocho, veintecuatro;

    public Lamina_Texto(){

        setLayout(new BorderLayout());
        barra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamano = new JMenu("Tamaño");
        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamano);
        courier = new JMenuItem("Courier");
        arial = new JMenuItem("Arial");
        verdana = new JMenuItem("Verdana");
        negrita = new JMenuItem("Negrita");
        cursiva = new JMenuItem("Cursiva");
        diez = new JMenuItem("10");
        catorce = new JMenuItem("14");
        dieciocho = new JMenuItem("18");
        veintecuatro = new JMenuItem("24");
        fuente.add(courier);
        fuente.add(arial);
        fuente.add(verdana);
        estilo.add(negrita);
        estilo.add(cursiva);
        tamano.add(diez);
        tamano.add(catorce);
        tamano.add(dieciocho);
        tamano.add(veintecuatro);
        texto = new JTextPane();
        add(barra, BorderLayout.NORTH);
        add(texto, BorderLayout.CENTER);
        courier.addActionListener(new Eventos_Fuente());
        arial.addActionListener(new Eventos_Fuente());
        verdana.addActionListener(new Eventos_Fuente());
        
    

        
    }

    private class Eventos_Fuente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String tipo = e.getSource().toString();
            
           int est =  texto.getFont().getStyle();
           int tam =  texto.getFont().getSize();

           System.out.println("t: "+tipo+" e: "+est+" t: "+tam);
          /* 
           switch (tipo) {
            case "courier":
                texto.setFont(new Font("Courier", est, tam));
                break;
           
            case "arial":
                texto.setFont(new Font("Arial", est, tam));
                break;

            case "verdana":
                texto.setFont(new Font("Verdana", est, tam));
                break;
           }
         */   
        }
        
    }

    private class Eventos_estilo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String estilo_var = (String)e.getSource();
            
           String nombre =  texto.getFont().getName();
           int tam =  texto.getFont().getSize();

          
           switch (estilo_var) {
            case "negrita":
                texto.setFont(new Font(nombre, Font.BOLD, tam));
                break;
           
            case "cursiva":
                texto.setFont(new Font(nombre, Font.ITALIC, tam));
                break;

           }
            
        }

    }

    private class Eventos_tam implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String taman = (String)e.getSource();
            
           int est =  texto.getFont().getStyle();
           String nombre =  texto.getFont().getName();

          
           switch (taman) {
            case "diez":
                texto.setFont(new Font(nombre, est, 10));
                break;
           
            case "catorce":
                texto.setFont(new Font(nombre, est, 14));
                break;

            case "dieciocho":
                texto.setFont(new Font(nombre, est, 18));
                break;

            case "veintecuatro":
                texto.setFont(new Font(nombre, est, 24));
                break;

           }
            
        }

    }
}
