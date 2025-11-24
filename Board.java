import java.util.HashMap;

public class Board {
    private final HashMap<Integer, Integer> snakes;
    private final HashMap<Integer, Integer> ladders;

    public Board() {
        snakes = new HashMap<>();
        ladders = new HashMap<>();

        // Snakes
        snakes.put(99, 54);
        snakes.put(70, 55);
        snakes.put(52, 42);
        snakes.put(25, 2);

        // Ladders
        ladders.put(6, 25);
        ladders.put(11, 40);
        ladders.put(60, 85);
        ladders.put(46, 90);
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }
}
