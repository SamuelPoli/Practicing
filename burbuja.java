import java.util.Arrays;

public class burbuja {
    public static void main(String[] args) {
        int[] arreglo = {5,7,8,6,1,2,4,9,3};
        int temporal;
        boolean esta_ordenado = false;
        int longitud = arreglo.length;
        int ultimo_ordenado = longitud-1;
        System.out.println(Arrays.toString(arreglo));
       
        while(esta_ordenado==false){
            esta_ordenado=true;
            for(int i=0; i<ultimo_ordenado; i++){
                if(arreglo[i]>arreglo[i+1]){
                    temporal=arreglo[i];
                    arreglo[i]=arreglo[i+1];
                    arreglo[i+1]=temporal;
                    esta_ordenado=false;
                }
            }
            ultimo_ordenado=ultimo_ordenado--;
        }

        System.out.println(Arrays.toString(arreglo));


    }
}
