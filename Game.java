import java.util.Scanner;
public class Game {
    int turn = 0;
    public void playGame(){
        String First, Second;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of board:");
        int n = in.nextInt();
        XOBoard board = new XOBoard(n);

        System.out.print("Enter name of first player:");
        First = in.next();
        Player a = new Player(First, 'x');

        System.out.print("Enter name of Second player:");
        Second = in.next();
        Player b = new Player(Second, 'o');

        while(true){
            board.displayBoard();
            move m = new move();
            if(turn == 0){
                a.get_move(m);
                while(!board.updateBoard(m.x, m.y, 'x')){
                    System.out.println("Invalid move, Try again.");
                    a.get_move(m);
                }
                if(board.isWinner('x')){
                    board.displayBoard();
                    System.out.println(a.get_name() + " won!!");
                    break;
                }
                if(board.isDraw()){
                    System.out.println("In Draw");
                    break;
                }
                turn = 1;
            }
            else{
                b.get_move(m);
                while(!board.updateBoard(m.x, m.y, 'o')){
                    System.out.println("Invalid move, Try again.");
                    b.get_move(m);
                }
                if(board.isWinner('o')){
                    board.displayBoard();
                    System.out.println(b.get_name() + " won!!");
                    break;
                }
                if(board.isDraw()){
                    System.out.println("In Draw");
                    break;
                }
                turn = 0;
            }
        }

    }
}
