package Java.Estructuras.Colecciones;

import java.util.*;
public class PruebaTreeSet {
    public static void main(String[] args) {
        /* 
        TreeSet<String> ordenaPersonas = new TreeSet<String>();

        ordenaPersonas.add("Sandra");
        ordenaPersonas.add("Amanda");
        ordenaPersonas.add("Diana");

        for (String s : ordenaPersonas) {
            System.out.println(s);
        }
*/

        Articulo primero = new Articulo(1, "APrimero");
        Articulo segundo = new Articulo(2, "ZSegundo");
        Articulo tercero = new Articulo(3, "ETercero");
        TreeSet<Articulo> ordenaArticulos = new TreeSet<Articulo>();
        ordenaArticulos.add(tercero);
        ordenaArticulos.add(segundo);
        ordenaArticulos.add(primero);
        for (Articulo articulo : ordenaArticulos) {
            System.out.println(articulo.getDescripcion());
        }

        /*Utilizando interfaz comparator añadida a la clase articulo */
        Comparator<Articulo> comparaDescripcion = new Articulo();
        TreeSet<Articulo> ordenaArticulos2 = new TreeSet<Articulo>(comparaDescripcion);
        ordenaArticulos2.add(tercero);
        ordenaArticulos2.add(segundo);
        ordenaArticulos2.add(primero);
        for (Articulo articulo : ordenaArticulos2) {
            System.out.println(articulo.getDescripcion());
        }
 
        /*Utilizando clases anonimas */
        TreeSet<Articulo> ordenaArticulos3 = new TreeSet<Articulo>(new Comparator<Articulo>(){

            @Override
            public int compare(Articulo o1, Articulo o2) {
               
                return o1.getDescripcion().compareTo(o2.getDescripcion());
            }

        });

        ordenaArticulos3.add(tercero);
        ordenaArticulos3.add(segundo);
        ordenaArticulos3.add(primero);
        for (Articulo articulo : ordenaArticulos3) {
            System.out.println(articulo.getDescripcion());
        }
    }
}

class Articulo implements Comparable<Articulo>, Comparator<Articulo>{
    public Articulo(int num, String descripcion) {
        this.num = num;
        this.descripcion = descripcion;
    }

    public Articulo(){}
    private int num;
    private String descripcion;
    
    @Override
    public int compareTo(Articulo o) {
        return num - o.num;
    }

    public int getNum() {
        return num;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int compare(Articulo o1, Articulo o2) {
        String descripcionA = o1.getDescripcion();
        String descripcionB = o2.getDescripcion();
        return descripcionA.compareTo(descripcionB);
    }

}
