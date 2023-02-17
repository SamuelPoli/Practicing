package Java;

import java.util.ArrayList;

public class app2 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>();
        /*if(lista.size()==0){
            lista.add("xxxx");
        }*/
        for(int i = 0; i<lista.size();i++){
            System.out.println(lista.get(i));
        }
        
        
        for (String s : lista) {
            System.out.println(s);
        }
    }
}
