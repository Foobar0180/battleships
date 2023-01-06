import java.util.ArrayList;

class BattleshipTest {

    public static void main(String[] args) {
        Ship ship = new Ship("USS Missouri", ShipType.CRUISER);
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("1");
        locations.add("2");
        locations.add("3");
        locations.add("4");

        ship.setLocationCells(locations);
        String guess = "2";
        String result = ship.checkGuess(guess);
        String testResult = "failed";

        if (result.equalsIgnoreCase("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
