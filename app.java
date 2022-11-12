public class app {

    public static void main (String[] args){
        app app1 = new app("Saludar");
        System.out.println(app1.getName());
        app1.Hello();
    
    }

    private String name;

    public app (String name){
        this.name=name;
    }

    public void Hello(){
        System.out.println("Hi");
    }

    public String getName(){
        return this.name;
    }

}