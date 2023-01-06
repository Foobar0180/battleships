import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Ship> ships = new ArrayList<>();
    private int numberOfGuesses = 0;

    public static void main(String[] args) {
        Game game = new Game();
        game.setupGame();
    }

    private void setupGame() {
        ships.add(new Ship("USS Enterprise",ShipType.CARRIER));
        ships.add(new Ship("USS Providence",ShipType.SUBMARINE));
        ships.add(new Ship("USS Gettysburg",ShipType.CRUISER));
        ships.add(new Ship("USS Nitze", ShipType.DESTROYER));
        ships.add(new Ship("USS Thunderbolt",ShipType.PATROL_BOAT));

        System.out.println("\nWelcome to BATTLESHIPS!");
        System.out.println("Your objective is to sink all your opponents battleships.\n");

        for (Ship ship : ships) {
            ArrayList<String> newLocation = Grid.placeShip(ship.getSize());
            ship.setLocationCells(newLocation);
        }

        playGame();
    }

    private void playGame() {
        Scanner in = new Scanner(System.in);

        while (!ships.isEmpty()) {
            System.out.println("\nEnter a location: ");
            String guess = in.next();
            checkGuess(guess);
        }
        gameOver();
    }

    private void checkGuess(String guess) {
        numberOfGuesses++;
        String result = "MISS";
        for (Ship ship : ships) {
            result = ship.checkGuess(guess);
            if (result.equalsIgnoreCase("hit")) {
                break;
            }
            if (result.equalsIgnoreCase("kill")) {
                ships.remove(ship);
                break;
            }
        }
        System.out.println(result);
    }

    private void gameOver() {
        System.out.println("You have sunk all the battleships. WELL DONE! It took " + numberOfGuesses + " guesses.");
    }
}
