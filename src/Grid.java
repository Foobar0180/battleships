import java.util.ArrayList;

public class Grid {
    private static int gridSize = 100;
    private static int[] grid = new int[gridSize];
    private static int shipCount = 0;

    public static ArrayList<String> placeShip(int shipSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
        int[] shipCoords = new int[shipSize];           // Holds the coordinates of a ship, i.e.: 'C6'
        String temp;                                    // Temp string. Used for concatenation
        int attempts = 0;                               // Current number of attempts
        boolean success = false;                        // Flag = found a ship cellLocation?
        int cellLocation;                               // Current starting cellLocation
        int gridLength = 10;

        // The nth number of ships to place
        shipCount++;

        // The horizontal increment
        int incr = 1;

        // If the number of ships is odd, then place the ships vertically
        if ((shipCount % 2) == 1) {
            incr = gridLength; // Set the vertical increment
        }

        while (!success && attempts++ < 500) {
            // Get a random starting location
            cellLocation = (int) (Math.random() * gridSize);
            //System.out.print("\nTry " + cellLocation);

            // The next position in the ship to place
            int next = 0;

            // Assume success to start
            success = true;

            // Look for adjacent unused cells
            while (success && next < shipSize) {
                // If not already used then save the location
                if (grid[cellLocation] == 0) {
                    shipCoords[next++] = cellLocation;

                    // Try 'next' adjacent cell
                    cellLocation += incr;

                    // Out of bounds - 'bottpm'
                    if (cellLocation >= gridSize) {
                        success = false;
                    }

                    // Out of bounds - 'right edge'
                    if (next > 0 && (cellLocation % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    //System.out.print("\nUsed " + cellLocation);
                    success = false;
                }
            }
        }

        int point = 0;
        int column;
        int row;
        String alphabet = "ABCDEFGHIJ";

        while (point < shipSize) {
            // Mark the master grid points as 'used'
            grid[shipCoords[point]] = 1;

            // Get the row and column values
            row = shipCoords[point] / gridLength;
            column = shipCoords[point] % gridLength;

            // Convert to alpha value
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            point++;

            System.out.print("\nCoord " + point + " = " + alphaCells.get(point - 1));
        }
        return alphaCells;
    }
}
