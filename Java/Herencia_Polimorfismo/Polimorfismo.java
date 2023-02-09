package Java.Herencia_Polimorfismo;
import java.util.Scanner;

public class Polimorfismo {
    //Aquí hacemos uso del polimorfismo para definir un metodo speak que funcione
    //diferente dependiendo del tipo de animal, haciendo uso de clases abstractas
    //Luego hacemos una interfaz que implemente el metodo abstracto speak
    //Las diferencias en el codigo son ligeras pero producen el mismo resultado
    public static void main(String[] args) {
        //Clases abstractas
/*      System.out.println("Clases abstractas");
        Animal animal = new Cat();
        System.out.println(animal);
        animal = new Dog();
        System.out.println(animal);

        //Polimorfismo
        System.out.println("Interfaces");
        AnimalInterface animal2 = new CatInt();
        System.out.println(animal2);
        animal2 = new DogInt();
        System.out.println(animal2);
*/
        boolean b1 = true;
        boolean b2 = false;
        Scanner ent = new Scanner(System.in);
        String texto = ent.nextLine();
        while(!texto.equals("ok")){
            if(b1==true){
                b1=false;
                b2=true;
            }
            else{
                b1=true;
                b2=false;
            }
            System.out.println("b1: "+b1+" b2: "+b2);
            texto = ent.nextLine();
        }
        ent.close();
        
    }

    
}
