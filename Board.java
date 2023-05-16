public abstract class Board {
    protected int n;
    protected char[][] grid;

    public Board(int n){
        this.n = n;
        this.grid = new char[n][n];
    }
    public abstract boolean updateBoard(int x, int y, char symbol);
    public abstract boolean isWinner(char symbol);
    public abstract boolean isDraw();
    public abstract void displayBoard();
}
