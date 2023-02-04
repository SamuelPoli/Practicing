package Java.Serializacion;

import java.io.*;
import java.util.*;

public class Serializando {
    public static void main(String[] args) {
        
        Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
        jefe_RRHH.setIncentivo(2570);
        empleado[] misEmpleados = new empleado[3];

        misEmpleados[0]= jefe_RRHH;
        misEmpleados[1]= new empleado("Ana Lopez", 95000, 1995, 6, 2);
        misEmpleados[2]= new empleado("Maria Martin", 105000, 2002, 3, 15);
     
       try {
            String ruta = "Java/Serializacion/arch.txt";
            ObjectOutputStream escribiendo_archivo= new ObjectOutputStream(new FileOutputStream(ruta));
            escribiendo_archivo.writeObject(misEmpleados);
            escribiendo_archivo.close();
            ObjectInputStream recuperando_archivo = new ObjectInputStream(new FileInputStream(ruta));
            empleado[] personal_recuperado = (empleado[]) recuperando_archivo.readObject();
            recuperando_archivo.close();
            for (empleado e : personal_recuperado) {
                System.out.println(e);
            }
       } catch (Exception e) {
            e.printStackTrace();
       }
        
        

      
        
    }
}

class empleado extends Persona implements Serializable{

    
    private double sueldo;
    private Date altaContrato;
    private static int IdSiguiente = 1;
    private int Id;

    public empleado(String nom, double sue, int ano, int mes, int dia){
        super(nom);
        sueldo=sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes-1, dia);//Mes empieza en 0
        altaContrato=calendario.getTime();
        Id=IdSiguiente;
        IdSiguiente++;
    }

    //El this llama al otro constructor para darle
    //datos predefinidos
    public empleado(String nombre){
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

    public int getId(){
        return Id;
    }

    public static String getIdSiguiente(){
        return "El Id siguiente es: "+IdSiguiente;
    }

    @Override
    public String dame_descripcion() {
        return "Este empleado tiene un ID= "+Id+
        " con un sueldo= "+sueldo;
    }

    public String toString(){

        return "Nombre: "+getNombre()+" sueldo: "+sueldo+" fecha de contrato: "+altaContrato;
    }



  
}


class Jefatura extends empleado implements Serializable{

    private double incentivo;
    
    public Jefatura(String nom, double sue, int ano, int mes, int dia){

        super(nom, sue, ano, mes, dia);

    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public double getSueldo() {
        double sueldoJefe = super.getSueldo();
        return sueldoJefe + incentivo;
    }

   
}



abstract class Persona implements Serializable{
    private final String nombre;
    public Persona (String nombre){
        this.nombre=nombre;
    }

    
    public abstract String dame_descripcion();

    public String getNombre() {
        return nombre;
    }

    
}