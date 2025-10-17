import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Player 1 name: ");
        String p1Name = sc.nextLine();
        System.out.print("Enter Player 2 name: ");
        String p2Name = sc.nextLine();

        Player p1 = new Player(p1Name, 'X');
        Player p2 = new Player(p2Name, 'O');

        Game game = new Game(p1, p2);
        game.start();
    }
}
