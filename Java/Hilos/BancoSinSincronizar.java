package Java.Hilos;

import java.util.concurrent.locks.*;

public class BancoSinSincronizar {
    public static void main(String[] args) {

        Banco mibanco = new Banco();
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencia r = new EjecucionTransferencia(mibanco, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }

        /*double[] cuentas = mibanco.getCuentas();
        for (double d : cuentas) {
            System.out.println();
        }*/
        
    }
}

class Banco{
    private final double[] cuentas;
    //clase para sincronizar hilos
    private Lock cierrebanco = new ReentrantLock();
    //Condicionales bloqueos
    private Condition saldosuficiente;

    public Banco(){
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=2000;
        }
        saldosuficiente = cierrebanco.newCondition();
    }
    /*Con synchronized */
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{        
        //Verificar saldo
        while(cuentas[cuentaOrigen]<cantidad){
            wait();
            System.err.println(Thread.currentThread()); 
        }
        
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen]-=cantidad;//dinero sale de cuenta origen
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino]+=cantidad;//dinero entra a cuenta destino
        System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
        notifyAll();
    
    }

/*     
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
    
        //*Si solo se utiliza el metodo lock, cuando no se cumpla la condicion
        // del if, el hilo no hace la transaccion y desaparece, con las condiciones en bloqueos
        // el hilo se queda esperando hasta que los otros hilos le notifiquen
        // e intenta hacer la transacción nuevamente
         
        cierrebanco.lock();
        try{
        //Verificar saldo
        while(cuentas[cuentaOrigen]<cantidad){
            saldosuficiente.await();
            System.err.println(Thread.currentThread()); 
        }
        //if(cuentas[cuentaOrigen]<cantidad)
        //    return;
        System.out.println(Thread.currentThread());
        cuentas[cuentaOrigen]-=cantidad;//dinero sale de cuenta origen
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        cuentas[cuentaDestino]+=cantidad;//dinero entra a cuenta destino
        System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
        saldosuficiente.signalAll();
        } finally{
            cierrebanco.unlock();
        }
    
    }
*/
    public double getSaldoTotal(){
        double sumaTotal = 0;
        for (double d : cuentas) {
            sumaTotal+=d;
        }
        return sumaTotal;
    }
    public double[] getCuentas(){
        return cuentas;
    }
}

class EjecucionTransferencia implements Runnable{

    private Banco banco;
    private int cuentaO;
    private double cantidadMaxima;

    public EjecucionTransferencia(Banco banco, int cuentaO, double cantidadMaxima){
        this.banco=banco;
        this.cuentaO=cuentaO;
        this.cantidadMaxima=cantidadMaxima;
    }
    @Override
    public void run() {
        
        while(true){
            int cuentaD = (int) (100*Math.random());
            double cantidad = cantidadMaxima*Math.random();
            try {
                banco.transferencia(cuentaO, cuentaD, cantidad);
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException e) {
              
                System.out.println(e.getMessage());
            }
        }
        
    }

}