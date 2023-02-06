package Java.Clases_Genericas;

/*El <E> permite indicar que la clase es generica
 *y que por lo tanto puede manejar diferentes tipos de datos
 *los cuales hay que indicarles entre <> cuando se instancie
 *la clase 
 */
public class Pareja <E>{
    //Variable de clase de tipo generico
    private E primero;
    //Constructor
    public Pareja(){
        primero=null;
    }
    /*Modifica el valor de la variable de clase
    *sin embargo el tipo de variable del parametro que recibe
    *el metodo es generico
    */
    public void setPrimer(E nuevoValor){
        primero=nuevoValor;
    }
    /*Ël getter es de tipo generico */
    public E getPrimero(){
        return primero;
    }
}
