public class app {

    public static void main (String[] args){
        app app1 = new app("Saludar");
        app1.Hello;
    }

    private String name;

    public app (String name){
        this.name=name;
    }

    public static String Hello(){
        System.out.println("Hi");
    }

}