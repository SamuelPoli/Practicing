package Java.Herencia_Polimorfismo;

public class CatInt extends AnimalInterface implements Speakable {

    public CatInt(){
        kind = "Cat";
    }

    @Override
    public String speak() {
       
        return "meow";
    }
    
}
