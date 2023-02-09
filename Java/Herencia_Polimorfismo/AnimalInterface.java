package Java.Herencia_Polimorfismo;
public class AnimalInterface {
    protected String kind;

    public AnimalInterface(){}

    public String toString(){
        return "I am a "+ kind + " and I go by "+ ((Speakable)this).speak();
    }
}
