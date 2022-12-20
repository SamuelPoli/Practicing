package Java;

import java.util.*;

public class Uso_empleado {
    public static void main(String[] args) {
        
        /*empleado empleado1 = new empleado("Paco Gomez", 85000, 1990, 12, 17);
        empleado empleado2 = new empleado("Ana Lopez", 95000, 1995, 6, 2);
        empleado empleado3 = new empleado("Maria Martin", 105000, 2002, 3, 15);

        empleado1.subesueldo(5);
        empleado2.subesueldo(5);
        empleado3.subesueldo(5);

        System.out.println("Nombre: "+empleado1.getNombre() + " Sueldo: "+empleado1.getSueldo()
        + " Fecha de alta: "+empleado1.getAltaContrato());

        System.out.println("Nombre: "+empleado2.getNombre() + " Sueldo: "+empleado2.getSueldo()
        + " Fecha de alta: "+empleado2.getAltaContrato());

        System.out.println("Nombre: "+empleado3.getNombre() + " Sueldo: "+empleado3.getSueldo()
        + " Fecha de alta: "+empleado3.getAltaContrato());
        */

        empleado[] misEmpleados = new empleado[3];

        misEmpleados[0]= new empleado("Paco Gomez", 85000, 1990, 12, 17);
        misEmpleados[1]= new empleado("Ana Lopez", 95000, 1995, 6, 2);
        misEmpleados[2]= new empleado("Maria Martin", 105000, 2002, 3, 15);
        
        for (empleado e : misEmpleados) {
            e.subesueldo(5);
            System.out.println("ID: "+ e.getId()+" Nombre: "+e.getNombre() + " Sueldo: "+e.getSueldo()
            + " Fecha de alta: "+e.getAltaContrato());
        }

        System.out.println(empleado.getIdSiguiente());
            
    }
}

class empleado{

    private final String nombre;
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente = 1;
    private int Id;

    public empleado(String nom, double sue, int ano, int mes, int dia){
        nombre=nom;
        sueldo=sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes-1, dia);//Mes empieza en 0
        altaContrato=calendario.getTime();
        Id=IdSiguiente;
        IdSiguiente++;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getAltaContrato() {
        return altaContrato;
    }

    public void setAltaContrato(Date altaContrato) {
        this.altaContrato = altaContrato;
    }

    public void subesueldo(double porcentaje){
        double aumento = this.sueldo*porcentaje/100;
        this.sueldo+=aumento;
    }

    public int getId(){
        return Id;
    }

    public static String getIdSiguiente(){
        return "El Id siguiente es: "+IdSiguiente;
    }
}
