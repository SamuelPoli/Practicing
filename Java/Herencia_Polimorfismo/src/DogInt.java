public class DogInt extends AnimalInterface implements Speakable {
    
    public DogInt(){
        this.kind="Dog";
    }

    @Override
    public String speak() {
        
        return "woof";
    }

    
}
