package Graficos;

import javax.swing.JFrame;
import java.awt.event.*;

/*Acá si podemos instanciar el objeto VentanaFocoV2 haciendo uso de un 
 * constructor ya que las variables son de tipo JFrame, es decir, son objetos diferentes
 * a la misma clase. Vemos que VentanaFocoV2 ya no necesita heredar JFrame
 * y el metodo que crea las ventanas tiene ligeras diferencias con el de VentanaFoco
 * por este motivo
 */
public class VentanaFocoV2 implements WindowFocusListener{
    private JFrame marco1;
    private JFrame marco2;

    public static void main(String[] args) {
        VentanaFocoV2 prueba = new VentanaFocoV2();
        prueba.iniciar();    
    }
 
    //Con constructor
    /* 
    public VentanaFocoV2(){
        marco1 = new JFrame();
        marco2 = new JFrame();
        marco1.setBounds(200, 100, 300, 300);
        marco2.setBounds(500, 100, 300, 300);
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
        
    }
    */

    //Con metodo 
    public void iniciar(){
        marco1 = new JFrame();
        marco2 = new JFrame();
        marco1.setBounds(200, 100, 300, 300);
        marco2.setBounds(500, 100, 300, 300);
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
