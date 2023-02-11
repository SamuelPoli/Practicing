package Java.Estructuras.Colecciones;

import java.util.*;

public class CuentasUsuarios {
    public static void main(String[] args) {
        Cliente cl1 = new Cliente("Antonio Banderas","00001",200000);
        Cliente cl2 = new Cliente("Rafael Nadal","00002",250000);
        Cliente cl3 = new Cliente("Penelope Cruz","00003",300000);
        Cliente cl4 = new Cliente("Julio Iglesias","00004",500000);
        Cliente cl5 = new Cliente("Antonio Banderas","00001",200000);
        Set <Cliente> clientesBanco = new HashSet<Cliente>();
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);
        /*for (Cliente c : clientesBanco) {
            
            if(c.getNombre().equals("Julio Iglesias")){
                clientesBanco.remove(c);
            }
        }*/
        Iterator<Cliente> iterador = clientesBanco.iterator();
        while(iterador.hasNext()){
            Cliente clienteactual = iterador.next();
            String nombreCliente = clienteactual.getNombre();
            if(nombreCliente.equals("Julio Iglesias")){
               iterador.remove();
            }

        }
        for (Cliente c : clientesBanco) {
            System.out.println(c.getNombre()+" "+c.getN_cuenta()+" "+c.getSaldo()+
            " "+c.hashCode());
            
        }
        /*
        Iterator<Cliente> iterador = clientesBanco.iterator();
        while(iterador.hasNext()){
            Cliente clienteactual = iterador.next();
            String nombreCliente = clienteactual.getNombre();
            String cuentaCliente = clienteactual.getN_cuenta();
            double saldoCliente = clienteactual.getSaldo();
            System.out.println(nombreCliente+" "+cuentaCliente+" "+saldoCliente);
        }
        */
    }
}
