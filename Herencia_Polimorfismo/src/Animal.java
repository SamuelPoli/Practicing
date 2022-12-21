public abstract class Animal {

    protected String kind;

    public Animal(){}

    public String toString(){
        return "I am a "+ kind + " and I go by "+ speak();
    }

    public abstract String speak();//Metodos abstractos no tienen una implementacion
    //Es decir, no tienen un conjunto de procedimientos
    //Sin embargo, si un metodo de una clase es abstracto, la clase tambien se debe marcar como abstracta
    //Las clases abstractas no se pueden instanciar
    
}


