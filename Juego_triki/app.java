package Juego_triki;

import javax.swing.JOptionPane;

public class app {
    public static void main(String[] args) {
        

        String jugador1 = JOptionPane.showInputDialog(null, "Ingrese nombre del jugador 1");
        String jugador2 = JOptionPane.showInputDialog(null, "Ingrese nombre del jugador 2");

        
        interfaz juego = new interfaz();
        juego.iniciar();
    }
}
