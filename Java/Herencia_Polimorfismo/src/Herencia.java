public class Herencia {
    public static void main(String[] args) throws Exception {
        Student est = new Student("Andrea");
        System.out.println(new Student("Samuel"));
        System.out.println(est.concatenatetoString());
        est = new ColleagueStudent("Juancho Polo");
        System.out.println(est); 
    }
}
