package FOPvivaY1S1;

import java.util.*;

public class VivaQ6a {

    public static void main(String[] args) {
        System.out.println("Welcome to the Dragon Egg Quest!");
        System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests.");
        System.out.println("You have 10 attempts to find all dragon eggs.");
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        // 3 eggs
        int egg1 = 1 + rng.nextInt(10);
        int egg2 = 1 + rng.nextInt(10);
        int egg3 = 1 + rng.nextInt(10);

        // Ensure all eggs are unique
        while (egg2 == egg1)
            egg2 = 1 + rng.nextInt(10);
        while (egg3 == egg1 || egg3 == egg2)
            egg3 = 1 + rng.nextInt(10);

        // 2 cursed chests
        int curse1 = 1 + rng.nextInt(10);
        int curse2 = 1 + rng.nextInt(10);

        while (curse2 == curse1)
            curse2 = 1 + rng.nextInt(10);

        // Track found eggs
        boolean egg1Found = false;
        boolean egg2Found = false;
        boolean egg3Found = false;

        int attempts = 10;

        while (attempts > 0 && !(egg1Found && egg2Found && egg3Found)) {

            int guess = readChest(sc);

            // Check curse
            if (guess == curse1 || guess == curse2) {
                System.out.println("This chest is cursed! Beware!(-2 attempts)");
                attempts -= 2;
            } else {
                attempts -= 1;
            }

            // Check eggs
            if (!egg1Found && guess == egg1) {
                egg1Found = true;
                System.out.println("You found a dragon egg!");
            } else if (!egg2Found && guess == egg2) {
                egg2Found = true;
                System.out.println("You found a dragon egg!");
            } else if (!egg3Found && guess == egg3) {
                egg3Found = true;
                System.out.println("You found a dragon egg!");
            } else {
                System.out.println("No egg here,keep searching!");

                // Use for loop to check distance
                int nearest = 9999;
                int[] eggs = { egg1, egg2, egg3 };
                boolean[] found = { egg1Found, egg2Found, egg3Found };

                for (int i = 0; i < 3; i++) {
                    if (!found[i]) {
                        int d = Math.abs(guess - eggs[i]);
                        if (d < nearest)
                            nearest = d;
                    }
                }

                if (nearest <= 3) {
                    System.out.println("Warm! You're very close to a dragon egg!");
                } else {
                    System.out.println("Cold! You're far from any dragon egg!");
                }
                if (guess > nearest) {
                    System.out.println("Hint! Try a lower chest number.");
                } else {
                    System.out.println("Hint! Try a higher chest number.");

                }
            }
            System.out.println("Attempts left: " + attempts);
        }

        if (egg1Found && egg2Found && egg3Found)
            System.out.println("Congratulations! All dragon eggs are safe!");
        else
            System.out.println("Game Over! Some dragon eggs remain hidden!");
    }

    public static int readChest(Scanner sc) {
        while (true) {
            System.out.print("Guess a chest(1-10): ");
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                if (v >= 1 && v <= 10)// valid the chest number
                    return v;
                else {
                    System.out.println(
                            "Invalid input,Please enter an integer between 1 and 10. Enter a integer to start the quest again.");

                    sc.next();// clear wrong input
                }

            } else {
                System.out.println("Invalid input,Please enter an integer between 1 and 10. ");
                sc.next();// clear wrong input
            }

        }
    }
}