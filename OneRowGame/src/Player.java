public abstract class Player {
    public static final int COMPUTER = 0;
    public static final int HUMAN = 1;
    protected int id;
    protected int kind;

    public Player(){

    }

    public Player(int id, int kind){
        this.id=id;
        this.kind=kind;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public boolean isComputer(){
        return kind==COMPUTER;
    }

    public abstract String makeAMove(String prompt);
}
