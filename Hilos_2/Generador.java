package Hilos_2;

public class Generador extends Thread {
    private Contenedor contenedor;

    public Generador (Contenedor c){
        this.contenedor=c;
    }

    public void run(){
        boolean vacio = true;
        for(int i=0; i<10; i++){
            if(vacio == true){
                System.out.println("Generador. linea: "+ i+". valor variable vacio: "+vacio);
                vacio = false;
            } else {
                contenedor.put(vacio);
                System.out.println("Generador. linea: "+ i+". valor variable vacio: "+vacio);
                vacio = true;
            }
           
            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                
            }       
        }
    }
}