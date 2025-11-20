import java.util.Random;
import java.util.Scanner;

public class HighlightGrid {

    private static void showGrid(int[][] data, Integer target) {
        int size = data.length;

        System.out.print("   ");
        for (int col = 0; col < size; col++) {
            System.out.printf("%02d ", col);
        }
        System.out.println();

        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print("---");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.printf("%02d| ", row);
            for (int col = 0; col < size; col++) {
                int value = data[row][col];
                if (target != null && value == target) {
                    System.out.printf("[%d] ", value);
                } else {
                    System.out.printf("%2d  ", value);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        int size = 0;

        while (true) {
            System.out.print("Enter array size (for NxN array): ");
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size > 0) break;
            } catch (Exception ignore) {}
            System.out.println("Invalid size. Try again.");
        }

        int[][] numbers = new int[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                numbers[r][c] = (rng.nextInt(10) + 1) * 2;
            }
        }

        System.out.println("\nGenerated 2D array:");
        showGrid(numbers, null);

        int chosen = 0;

        while (true) {
            System.out.print("\nEnter a number to highlight (even number 2–20): ");
            try {
                chosen = Integer.parseInt(scanner.nextLine());
                if (chosen >= 2 && chosen <= 20 && chosen % 2 == 0) break;
            } catch (Exception ignore) {}
            System.out.println("Invalid entry. Try again.");
        }

        int total = 0;
        for (int[] row : numbers) {
            for (int val : row) {
                if (val == chosen) total++;
            }
        }

        System.out.println("\nArray with " + chosen + " highlighted:");
        showGrid(numbers, chosen);

        System.out.println("\nNumber " + chosen + " appeared " + total + " time(s)");
    }
}