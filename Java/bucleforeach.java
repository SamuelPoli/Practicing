package Java;

public class bucleforeach {

    public static void main(String[] args) {
        /*Como declarar matrices
         * int [] matriz = new int[5];
         * Se declara el tipo de dato seguido de [], nombre de la variable
         * y luego el operador new indicando nuevamente el tipo de dato
         * con el tamaño de la matriz
         * Para inicializar:
         * matriz[0]=5;
         * matriz[1]=2;
         * matriz[2]=56;
         * matriz[3]=69;
         * matriz[4]=5;
         * Otra forma es inicializando enseguida:
         * int [] matriz_2 = {55, 65, 80, 20}
         * ojo que aquí no se indica el tamaño y se utilizan {}
         * 
         */

        int[] aleatorios = new int[150];

        //Bucle for normal
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i]=(int)Math.round(Math.random()*100);
        }

        //Bucle for each, se crea una variable del mismo tipo que la matriz
        //y se le indica el nombre de la matriz a recorrer
        for (int i : aleatorios) {
            System.out.print(i+" ");
        }

    }
    
}
