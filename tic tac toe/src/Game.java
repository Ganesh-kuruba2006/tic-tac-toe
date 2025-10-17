import java.util.Scanner;

public class Game {
    private Board board;
    private Player p1, p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        Player current = p1;
        boolean gameOver = false;

        while (!gameOver) {
            board.printBoard();
            System.out.println(current.getName() + " (" + current.getSymbol() + ") - Enter row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (!board.makeMove(row, col, current.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (board.checkWin(current.getSymbol())) {
                board.printBoard();
                System.out.println("🎉 " + current.getName() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                current = (current == p1) ? p2 : p1;
            }
        }
        sc.close();
    }
}
