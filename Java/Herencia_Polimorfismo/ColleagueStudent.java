package Java.Herencia_Polimorfismo;
public class ColleagueStudent extends Student{
    
    public ColleagueStudent(){}

    public ColleagueStudent(String s){
        super(s);
    }

    public String toString(){
        return "my name is "+name+" and im a colleague student";
    }
}