package Java.Graficos;

import javax.swing.*;

public class CreandoMarcos {
    
    public static void main(String[] args) {
        miMarco marco = new miMarco();
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//lo mismo que colocar 3
    }
}

class miMarco extends JFrame{

    public miMarco(){
        //setSize(500,300);
        //setLocation(500, 300);
        setBounds(600, 300, 250, 250);
        //setResizable(false);
        //setExtendedState(MAXIMIZED_BOTH);
        setTitle("Mi ventana");
    }
}