package Java;
import java.util.*;
public class Empleado {
    
    private String nombre;
    private double sueldo;
    private Date altaContrato;
   

    public Empleado(String nom, double sue, int ano, int mes, int dia){
        this.nombre = nom;
        this.sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes-1, dia);//Mes empieza en 0
        this.altaContrato=calendario.getTime();
       
    }


    public Empleado(String nombre){
        this(nombre, 30000, 2000, 1, 1);
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

    public String dame_descripcion() {
        
        return "Este empleado se llama: "+nombre+
        " tiene un sueldo de: "+sueldo+" y trabaja desde: "+altaContrato;
    }
 
}
