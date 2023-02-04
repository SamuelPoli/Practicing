package Java.Graficos.ProcesadorTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;;

public class ProcesadorTextov2{

    public static void main(String[] args) {
        Marco_Textov2 marcov2 = new Marco_Textov2();
        marcov2.setVisible(true);

    }
    
}


class Marco_Textov2 extends JFrame{

    public Marco_Textov2(){
        setBounds(300,100,500,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Lamina_Textov2());
        
    }

}

class Lamina_Textov2 extends JPanel{

    private JMenuBar barra;
    private JTextPane texto;
    private JMenu fuente, estilo, tamano;
   
    private JToolBar barra2;
    //Mejoras: utilizar constante para la primera parte de la ruta de las imagenes
    //Cargar nuevas imagenes

    public Lamina_Textov2(){

        setLayout(new BorderLayout());
        barra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamano = new JMenu("Tamaño");
        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamano);
        configura_menu("Courier","fuente","Courier",0,0);
        configura_menu("Arial","fuente","Arial",0,0);
        configura_menu("Verdana","fuente","Verdana",0,0);
        configura_menu("Negrita","estilo","",1,0);
        configura_menu("Cursiva","estilo","",2,0);
        configura_menu("10","tamano","",0,10);
        configura_menu("14","tamano","",0,14);
        configura_menu("24","tamano","",0,24);
        configura_menu("28","tamano","",0,28);
        texto = new JTextPane();
        add(barra, BorderLayout.NORTH);
        add(texto, BorderLayout.CENTER);
        barra2=new JToolBar();
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.BoldAction());
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.ItalicAction());
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.UnderlineAction());
        barra2.addSeparator();
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.ForegroundAction("Pone azul", Color.BLUE));
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.ForegroundAction("Pone amarillo", Color.YELLOW));
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.ForegroundAction("Pone rojo", Color.RED));
        barra2.addSeparator();
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        configura_barra("C:/Users/001TIC981/Documents/folderblackjava_93291.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
        barra2.setOrientation(1);
        add(barra2, BorderLayout.EAST);
        /*Se pueden agregar menus de checkbox y radiobutton haciendo uso
         * de las clases JCheckBoxMenuItem y JRadioButtonMenuItem en cuyo caso
         * ya no haríamos uso del metodo configura_menu y tocaría instanciar cada elemento
         * y pasar el new StyledEditorKit para que haga la acción. Adicionalmente,
         * los radiobutton deben ser añadidos a una clase Buttongroup para que funcionen correctamente
         */
    
    }

    public JButton configura_barra(String ruta){
        JButton boton = new JButton(new ImageIcon(ruta));
        barra2.add(boton);
        return boton;
    }

    public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
        JMenuItem elem_menu = new JMenuItem(rotulo);
        if(menu=="fuente"){
            fuente.add(elem_menu);
            switch (tipo_letra) {
                case "Arial":
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
                    break;
                case "Verdana":
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
                    break;
                case "Courier":
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Courier"));
                    break;
            }
        }
        else if (menu=="estilo"){
            estilo.add(elem_menu);
            if (estilos==Font.BOLD){
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            } else if(estilos==Font.ITALIC){
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }
        else{
            tamano.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam));
        }

    }

    
    
}
