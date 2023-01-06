import java.util.ArrayList;

class Ship {
    private ArrayList<String> locationCells;
    private String name;
    private int size;

    public Ship(String name, ShipType shipType) {
        this.name = name;

        // Based on the ship type, set the size of the ship
        // See reference: https://en.wikipedia.org/wiki/Battleship_(game) for ship class and size
        switch (shipType) {
            case CARRIER:
                this.size = 5;
                break;
            case CRUISER:
                this.size = 4;
                break;
            case SUBMARINE:
                this.size = 3;
                break;
            case DESTROYER:
                this.size = 3;
                break;
            case PATROL_BOAT:
                this.size = 2;
                break;
            default:
                this.size = 1;
        }
    }

    public int getSize() {
        return size;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    String checkGuess(String guess) {
        String result = "MISS";

        // In case the user enters a number
        try {
            // Check if there is a ship at this location
            if (locationCells.contains(guess)) {
                locationCells.remove(guess);
                result = locationCells.isEmpty() ? "KILLED" : "HIT";
            }
            return result;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}

enum ShipType {
    CARRIER,
    CRUISER,
    SUBMARINE,
    DESTROYER,
    PATROL_BOAT
}

