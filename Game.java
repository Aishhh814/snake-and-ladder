import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private Dice dice;

    public Game() {
        board = new Board();
        dice = new Dice();
        players = new ArrayList<>();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== SNAKES AND LADDERS GAME =====");
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name of Player " + i + ": ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        System.out.println("\nGame Started!\n");

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println(player.getName() + ", press ENTER to roll the dice...");
                sc.nextLine();

                int diceValue = dice.roll();
                System.out.println(player.getName() + " rolled: " + diceValue);

                int newPos = player.getPosition() + diceValue;

                if (newPos <= 100) {
                    if (board.getSnakes().containsKey(newPos)) {
                        System.out.println("Oh no! Snake at " + newPos);
                        newPos = board.getSnakes().get(newPos);
                    } else if (board.getLadders().containsKey(newPos)) {
                        System.out.println("Great! Ladder at " + newPos);
                        newPos = board.getLadders().get(newPos);
                    }

                    player.setPosition(newPos);
                    System.out.println(player.getName() + " is now at position " + newPos);
                } else {
                    System.out.println("Roll exceeds board limit. Stay at current position.");
                }

                if (newPos == 100) {
                    System.out.println("\n🎉🎉 " + player.getName() + " WINS THE GAME! 🎉🎉");
                    gameOver = true;
                    break;
                }

                System.out.println("----------------------------------");
            }
        }
    }
}
