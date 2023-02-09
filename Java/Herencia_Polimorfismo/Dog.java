package Java.Herencia_Polimorfismo;
public class Dog extends Animal {
    
    public Dog(){
        kind = "Dog";
    }

    @Override
    public String speak() {
       
        return "woof";
    }


}
