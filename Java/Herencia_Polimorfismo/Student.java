package Java.Herencia_Polimorfismo;

public class Student{
    protected String name;
    
    public Student(){}
    
    public Student(String s){
        this.name=s;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "my name is "+name+" and im a student";
    }

    public String concatenatetoString(){
        return super.toString()+" "+toString();
    }
}