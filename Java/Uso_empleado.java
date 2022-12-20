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

        Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
        jefe_RRHH.setIncentivo(2570);
        empleado[] misEmpleados = new empleado[6];

        misEmpleados[0]= new empleado("Paco Gomez", 85000, 1990, 12, 17);
        misEmpleados[1]= new empleado("Ana Lopez", 95000, 1995, 6, 2);
        misEmpleados[2]= new empleado("Maria Martin", 105000, 2002, 3, 15);
        misEmpleados[3]= new empleado("Antonio Fernandez");
        misEmpleados[4]= jefe_RRHH;
        misEmpleados[5]= new Jefatura("María", 95000, 1999, 5, 26);
        Jefatura jefa_finanzas = (Jefatura) misEmpleados[5];
        jefa_finanzas.setIncentivo(55000);
        
        //Ordenado por sueldo
        Arrays.sort(misEmpleados);
        
        for (empleado e : misEmpleados) {
            e.subesueldo(5);
            System.out.println("ID: "+ e.getId()+" Nombre: "+e.getNombre() + " Sueldo: "+e.getSueldo()
            + " Fecha de alta: "+e.getAltaContrato());
        }

        

        System.out.println(empleado.getIdSiguiente());

        Persona[] personas = new Persona[2];
        personas[0]= new empleado("Luis Conde", 50000, 2009, 02, 25);
        personas[1]= new Alumno("Ana Lopez", "Biología");

        for (Persona p : personas) {
            System.out.println(p.getNombre()+", "+p.dame_descripcion());
        }
            
    }
}

class empleado extends Persona implements Comparable{

    
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

    @Override
    public int compareTo(Object o) {
        empleado otroEmpleado = (empleado) o;
        
        if(this.sueldo<otroEmpleado.sueldo)
            return -1;
        if(this.sueldo>otroEmpleado.sueldo)
            return 1;
        else
            return 0;
    }
}

//el modificador final establece que la clase no se puede heredar
class Jefatura extends empleado{

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

class Director extends Jefatura{

    public Director(String nom, double sue, int ano, int mes, int dia){
        super(nom, sue, ano, mes, dia);
    }
}

abstract class Persona{
    private final String nombre;
    public Persona (String nombre){
        this.nombre=nombre;
    }

    
    public abstract String dame_descripcion();

    public String getNombre() {
        return nombre;
    }

    
}

class Alumno extends Persona{

    private String carrera;

    public Alumno(String nombre, String carrera){
        super(nombre);
        this.carrera=carrera;
        
    }

    @Override
    public String dame_descripcion() {
        return "Este alumno está estudiando= "+carrera;
    }
}