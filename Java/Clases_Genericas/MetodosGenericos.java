package Java.Clases_Genericas;

import java.util.GregorianCalendar;

import Java.Empleado;

public class MetodosGenericos {
    public static void main(String[] args) {
        String[] lista = {"Feb","Mar","Ene","Abril"};
        //misMatrices.<String>getElementos(lista);
        misMatrices.getElementos(lista);
        System.out.println(misMatrices.elementoMenor(lista));
        
        Empleado misEmpleados[] = {new Empleado("Ana"),
        new Empleado("Juancho"),
        new Empleado("Mandinga"),
        new Empleado("Esperanza")};
        misMatrices.getElementos(misEmpleados);

        GregorianCalendar calendario[] = {new GregorianCalendar(2023,10,01),
            new GregorianCalendar(2023,12,15),
            new GregorianCalendar(2022,05,07)
        };
        System.out.println(misMatrices.elementoMenor(calendario).getTime());
        
    }
}

class misMatrices{
    public static <T> void getElementos(T[] arreglo){
        System.out.println("El array tiene: "+arreglo.length+" elementos");
    }

    public static <T extends Comparable> T elementoMenor(T[] arreglo){
        if(arreglo==null || arreglo.length == 0)
            return null;
        T menor = arreglo[0];
        for (int i=1; i<arreglo.length; i++) {
            if(menor.compareTo(arreglo[i])>0)
                menor = arreglo[i];
        }
        return menor;

    }
}
