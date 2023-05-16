public class XOBoard extends Board {
    XOBoard(int n) {
        super(n);
        this.grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean updateBoard(int x, int y, char symbol) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        if (grid[x][y] == 'x' || grid[x][y] == 'o') {
            return false;
        }
        grid[x][y] = symbol;
        return true;
    }

    @Override
    public boolean isWinner(char symbol) {
        int count = 0;

        //row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == symbol) {
                    count++;
                }
                if (count == n) {
                    return true;
                }
            }
            count = 0;
        }

        //column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == symbol) {
                    count++;
                }
                if (count == n) {
                    return true;
                }
            }
            count = 0;
        }

        //diagonal1
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] != symbol ){
                flag = false;
                break;
            }
        }
        if (flag)
            return true;

        //diagonal2
        flag = true;
        for (int i = 0; i < n; i++) {
            if (grid[i][n - i - 1] != symbol) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean isDraw() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 'x' && grid[i][j] != 'o') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void displayBoard() {
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                for (int k = 0; k < n * n + 5; k++) {
                    System.out.print('-');
                    continue;
                }
                System.out.println();
            }
            for (int j = 0; j < n; j++) {
                System.out.print(" " + grid[i][j]);
                if (j != n - 1)
                    System.out.print("  |  ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }
}
