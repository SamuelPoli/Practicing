package Java.Estructuras.Colecciones;

import Java.Empleado;
import java.util.*;

public class PruebaMapas {
    public static void main(String[] args) {
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
        personal.put("Emp001", new Empleado("José José"));
        personal.put("Emp002", new Empleado("Juan Gomez"));
        personal.put("Emp003", new Empleado("Antonio"));
        personal.put("Emp004", new Empleado("Sandra"));
        System.out.println(personal);
        personal.remove("Emp003");
        System.out.println(personal);
        for (Map.Entry<String, Empleado>  e : personal.entrySet()) {
            System.out.println("Clave: "+e.getKey()+" Valor: "+e.getValue());
        }
    }
}
