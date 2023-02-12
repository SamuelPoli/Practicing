package Java.Clases_Genericas;

public class UsoPareja {
    public static void main(String[] args) {
        Pareja<String> nuevapareja = new Pareja<String>();
        nuevapareja.setPrimer("Hola");
        System.out.println(nuevapareja.getPrimero());

        Pareja<Persona> otrapareja=new Pareja<Persona>();
        otrapareja.setPrimer(new Persona("Santiago"));
        System.out.println(otrapareja.getPrimero());
    }
}

class Persona{
    public Persona(String nombre){
        this.nombre=nombre;
    }

    private String nombre;

    public String getNombre() {
        return nombre;
    }
}