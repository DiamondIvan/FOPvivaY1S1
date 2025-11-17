package FOPvivaY1S1;

import java.util.Scanner;
import java.util.Random;

public class VivaQ6 {

    /**
     * initialize the final value for chest, dragon eggs,cursed chest and attempt
     * times
     */
    public static final int TOTAL_CHEST = 10;
    public static final int TOTAL_EGGS = 3;
    public static final int TOTAL_CURSED = 2;
    public static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        boolean[] ChestHasEgg = new boolean[TOTAL_CHEST + 1];
        boolean[] ChestIsCursed = new boolean[TOTAL_CHEST + 1];
        boolean[] eggCollected = new boolean[TOTAL_CHEST + 1];
        // initialize three important array needed to use

        int attemptsLeft = MAX_ATTEMPTS;// have 10 attempts left at the beginning.
        int eggFounded = 0;// 0 egg founded at the beginning.
        System.out.println("Welcome to the Dragon Egg Quest!");
        System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests.");
        System.out.println("You have 10 attempts to find all dragon eggs.");

        placeUnique(ChestHasEgg, TOTAL_EGGS, rand);// get value which chest has dragon egg,place 3 dragon egg randomly
        placeUnique(ChestIsCursed, TOTAL_CURSED, rand);// get value which chest is cursed,place 2 cursed chest randomly

        while (attemptsLeft > 0 && eggFounded < 3) {
            int guess = readChest(sc);
            boolean cursedChestThisGuess = ChestIsCursed[guess];
            int attemptsCost = cursedChestThisGuess ? 2 : 1;// attempts cost will be 2 or 1.

            if (cursedChestThisGuess) {
                System.out.println("This chest is cursed! Beware!");
            }
            attemptsLeft -= attemptsCost;

            if (ChestHasEgg[guess] && !eggCollected[guess]) {
                eggCollected[guess] = true;// make sure user doesnot guess it second time,if user guess it second
                                           // time,straight away go else selection
                eggFounded++;
                System.out.println("You found a dragon egg!");
            } else {
                if (eggFounded < 3) {
                    Integer nearest = nearestRemainingEgg(guess, ChestHasEgg, eggCollected);
                    if (nearest != null) {
                        int distance = Math.abs(nearest - guess);
                        if (distance <= 3) {
                            System.out.println("Warm! You're very close to a dragon egg!");
                        } else {
                            System.out.println("Cold! You're far from any dragon egg!");
                        }
                        if (guess < nearest)
                            System.out.println("Hint: Try a higher chest number.");
                        else if (guess > nearest) {
                            System.out.println("Hint: Try a lower chest number.");
                        }

                    }
                }
            }
            System.out.println("Attempts left: " + Math.max(attemptsLeft, 0));
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
        if (eggFounded == 3) {
            System.out.println("Congratulations! All dragon eggs are safe!");
        } else {
            System.out.println("Game Over! Some dragon eggs remain hidden!");
        }
    }

    public static int readChest(Scanner sc) {
        while (true) {
            System.out.print("Guess a chest(1-10): ");
            if (sc.hasNextInt()) {
                int v = sc.nextInt();
                if (v >= 1 && v <= 10) // valid the chest number
                    return v;
            } else {
                System.out.println(
                        "Invalid input,Please enter an integer between 1 and 10. Enter anything to start the quest again.");
                sc.next();// clear wrong input

            }
        }
    }

    public static Integer nearestRemainingEgg(int guess, boolean[] ChestHasEgg, boolean[] eggCollected) {
        Integer nearest = null;
        int bestDistance = Integer.MAX_VALUE;
        for (int i = 1; i <= TOTAL_CHEST; i++) {
            if (ChestHasEgg[i] && !eggCollected[i]) {// the dragon egg which still hidden
                int d = Math.abs(i - guess);// distance between guess and egg
                if (d < bestDistance) {// find the closest one if there have 2 eggs
                    bestDistance = d;
                    nearest = i;// store the position of the closest one
                }
            }
        }
        return nearest;// if all egg be collected,it will become null

    }

    public static void placeUnique(boolean[] arr, int count, Random rand) {
        int place = 0;
        while (place < count) {
            int position = rand.nextInt(10) + 1;// random chest number between 1 and 10
            if (!arr[position]) {// check if the position used or not
                arr[position] = true;// mark chest as having dragon egg or become cursed chest or both(because they
                                     // are done separately)
                place++;// count the placement
            }
        }
    }
}