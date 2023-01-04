package Graficos.ProcesadorTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProcesadorTexto{

    public static void main(String[] args) {
        Marco_Texto marco = new Marco_Texto();
        marco.setVisible(true);

    }

    
    
}


class Marco_Texto extends JFrame{

    public Marco_Texto(){
        setBounds(300,300,200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Lamina_Texto());
        
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
        Eventos_Fuente evfte = new Eventos_Fuente();
        Eventos_estilo evest= new Eventos_estilo();
        Eventos_tam evtam = new Eventos_tam();
        courier.addActionListener(evfte);
        arial.addActionListener(evfte);
        verdana.addActionListener(evfte);
        negrita.addActionListener(evest);
        cursiva.addActionListener(evest);
        diez.addActionListener(evtam);
        catorce.addActionListener(evtam);
        dieciocho.addActionListener(evtam);
        veintecuatro.addActionListener(evtam);
        
    

        
    }

    
    private class Eventos_Fuente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem tipo = (JMenuItem) e.getSource();
            String t=tipo.getText();
           int est =  texto.getFont().getStyle();
           int tam =  texto.getFont().getSize();
           texto.setFont(new Font(t, est, tam));
           
        }
        
    }

    private class Eventos_estilo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem tipo = (JMenuItem) e.getSource();
            String t=tipo.getText();
           String nombre =  texto.getFont().getName();
           int tam =  texto.getFont().getSize();

          
           switch (t) {
            case "Negrita":
                texto.setFont(new Font(nombre, Font.BOLD, tam));
                break;
           
            case "Cursiva":
                texto.setFont(new Font(nombre, Font.ITALIC, tam));
                break;

           }
            
        }

    }

    private class Eventos_tam implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem tipo = (JMenuItem) e.getSource();
            String t=tipo.getText();
            
           int est =  texto.getFont().getStyle();
           String nombre =  texto.getFont().getName();

          
           switch (t) {
            case "10":
                texto.setFont(new Font(nombre, est, 10));
                break;
           
            case "14":
                texto.setFont(new Font(nombre, est, 14));
                break;

            case "18":
                texto.setFont(new Font(nombre, est, 18));
                break;

            case "24":
                texto.setFont(new Font(nombre, est, 24));
                break;

           }
            
        }

    }
}
