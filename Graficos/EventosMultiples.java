package Graficos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.FlowLayout;

public class EventosMultiples {
    public static void main(String[] args) throws Exception {
        Marco1 mimarco = new Marco1();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

class Marco1 extends JFrame{
    public Marco1(){
        setVisible(true);
        
        LaminaMultiple lamina = new LaminaMultiple();
        //FlowLayout disposicion = new FlowLayout(FlowLayout.RIGHT);
        //lamina.setLayout(disposicion);
        add(lamina);
        setBounds(600, 300, 500, 300);

    }
}

class LaminaMultiple extends JPanel{

    public LaminaMultiple(){
        setLayout(new BorderLayout());
        
        Icon icono = new ImageIcon("C:/Users/001TIC981/Documents/Practicing/Graficos/folderblackjava_93291.png");
        Accion cambiaAmarillo = new Accion("Amarillo", icono, Color.YELLOW);
        Accion cambiaAzul = new Accion("Azul", icono, Color.BLUE);
        Accion cambiaRojo = new Accion("Rojo", icono, Color.RED);

        add(new JButton(cambiaAmarillo), BorderLayout.NORTH);
        add(new JButton(cambiaAzul), BorderLayout.WEST);
        add(new JButton(cambiaRojo), BorderLayout.SOUTH);

        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
        mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("fondo_amarillo", cambiaAmarillo);
        mapaAccion.put("fondo_azul", cambiaAzul);
        mapaAccion.put("fondo_rojo", cambiaRojo);

    }

    private class Accion extends AbstractAction{

        public Accion(String nombre, Icon icono, Color color_fondo){
            putValue(NAME, nombre);
            putValue(LARGE_ICON_KEY, icono);
            putValue(SHORT_DESCRIPTION, "Cambia color a "+nombre);
            putValue("color_fondo", color_fondo);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            Color c = (Color) getValue("color_fondo");
            setBackground(c);
            System.out.println("Nombre: "+getValue(NAME)+" Descripcion: "+getValue(SHORT_DESCRIPTION));
            
        }

    }
}
