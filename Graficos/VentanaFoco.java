package Graficos;

import javax.swing.JFrame;
import java.awt.event.*;

/* En esta clase creamos dos ventanas haciendo uso de una sola clase
 * por lo cual dicha clase extiende JFrame y a su vez implementa la interfaz
 * WindowFocusListener
 * Creamos un metodo iniciar el cual instancia dos objetos de tipo VentanaFoco
 * por lo cual heredan los metodos de JFrame y permiten acceder a dichos metodos para
 * convertirlos en ventanas
 * Agregamos a dichos objetos el metodo addWindowFocusListener y referenciamos a la misma
 * clase con this porque es la que implementa la interfaz
 * Luego, como no creamos un constructor se extiende el constructor por defecto de Object
 * y procedemos a instanciar un objeto en el main del mismo tipo de la clase para de 
 * esta forma acceder al metodo iniciar y que haga todo el trabajo
 * No se puede hacer lo mismo reemplazando el metodo iniciar por un constructor y llamando
 * a dicho constructor en el main porque las variables de clase se están instanciando con el mismo
 * constructor
 */
public class VentanaFoco extends JFrame implements WindowFocusListener{
    VentanaFoco marco1;
    VentanaFoco marco2;

    public static void main(String[] args) {
        VentanaFoco prueba = new VentanaFoco();
        prueba.iniciar();
    }
 
   
    public void iniciar(){
        marco1 = new VentanaFoco();
        marco2 = new VentanaFoco();
        marco1.setBounds(200, 100, 300, 300);
        marco2.setBounds(500, 100, 300, 300);
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(EXIT_ON_CLOSE);
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
        
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
       
        if(e.getSource()==marco1)
            marco1.setTitle("Tengo el foco");
        else
            marco2.setTitle("Tengo el foco");
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if(e.getSource()==marco1)
            marco1.setTitle("");
        else
            marco2.setTitle("");
        
        
    }
}
