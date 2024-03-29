package Java.Estructuras;

import java.util.*;
import Java.Empleado;
/*El ArrayList tiene la ventaja sobre un Array normal que puede 
 * crecer dinamicamente, sin embargo, puede ser muy lento para grandes 
 * volumenes de información
 */
public class Arraylist {
    public static void main(String[] args) {
        ArrayList <Empleado> listaempleados = new ArrayList<Empleado>();
        listaempleados.add(new Empleado("José IV"));
        listaempleados.add(new Empleado("Carolina Guzman", 5000, 2023, 1, 15));
        //Metodo para cerrar el array al tamaño actual y ahorrar recursos
        //listaempleados.trimToSize();
        
        System.out.println(listaempleados.size());
        System.out.println("Listado empleados antiguos:");
        for (Empleado e : listaempleados) {
            System.out.println(e.dame_descripcion());    
        }
        
        //Metodo para modificar un item del ArrayList
        listaempleados.set(0, new Empleado("Juana de Arco", 7800, 2020, 12, 4));
        System.out.println("Listado empleados nuevos:");
        
        /*Se prefiere utilizar un objeto iterator para recorrer listas de colecciones
        * ya que se puede generar errores con el bucle for
        * Comentario del profe:
        * En cuestiones de eficiencia la verdad no sabría decirte qué consume más recursos. 
        * Pero Iterator permite "jugar" más y de manera más sencilla que un bucle for-each 
        * con los elementos de un ArrayList. Los métodos de la clase Iterator permiten eliminar, 
        * ir al siguiente y saber si hay más elementos o no los hay de una manera más sencilla 
        * que un bucle for-each (o el for de toda la vida).
        */
        Iterator <Empleado> iterador = listaempleados.iterator();
        while(iterador.hasNext())
            System.out.println(iterador.next().dame_descripcion());
    }
    
}
