import java.util.Scanner;
class move{
    public int x, y;
}
public class Player {
    protected String name;
    protected char symbol;
    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public void get_move(move m){
        Scanner scanner = new Scanner(System.in);
        System.out.print(this.name + ", enter your move (x,y): ");
        m.x = scanner.nextInt();
        m.y = scanner.nextInt();
    }
    public char get_symbol(){
        return symbol;
    }
    public String get_name(){
        return name;
    }
}
