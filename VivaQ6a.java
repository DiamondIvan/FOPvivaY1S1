package FOPvivaY1S1;

import java.util.Scanner;
import java.util.Random;

public class VivaQ6a {

    public static final int TOTAL_CHEST = 10;
    public static final int TOTAL_EGGS = 3;
    public static final int TOTAL_CURSED = 2;
    public static final int MAX_ATTEMPTS = 10;

    // Chest properties (NO ARRAYS)
    public static boolean c1Egg, c2Egg, c3Egg, c4Egg, c5Egg, c6Egg, c7Egg, c8Egg, c9Egg, c10Egg;
    public static boolean c1Cursed, c2Cursed, c3Cursed, c4Cursed, c5Cursed, c6Cursed, c7Cursed, c8Cursed, c9Cursed,
            c10Cursed;
    public static boolean c1Taken, c2Taken, c3Taken, c4Taken, c5Taken, c6Taken, c7Taken, c8Taken, c9Taken, c10Taken;

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int attemptsLeft = MAX_ATTEMPTS;
        int eggFound = 0;

        System.out.println("Welcome to the Dragon Egg Quest!");
        System.out.println("There are 10 chests, 3 dragon eggs, and 2 cursed chests.");
        System.out.println("You have 10 attempts to find all dragon eggs.");

        placeUniqueEggs(rand);
        placeUniqueCursed(rand);

        while (attemptsLeft > 0 && eggFound < 3) {

            int guess = readChest(sc);
            boolean cursed = isCursed(guess);

            int cost = cursed ? 2 : 1;
            if (cursed)
                System.out.println("This chest is cursed! Beware!");

            attemptsLeft -= cost;

            // Egg logic
            if (hasEgg(guess) && !isTaken(guess)) {
                setTaken(guess);
                eggFound++;
                System.out.println("You found a dragon egg!");
            } else {
                Integer nearest = nearestEgg(guess);
                if (nearest != null) {
                    int distance = Math.abs(nearest - guess);
                    if (distance <= 3) {
                        System.out.println("Warm! You're very close to a dragon egg!");
                    } else {
                        System.out.println("Cold! You're far from any dragon egg!");
                    }

                    if (guess < nearest)
                        System.out.println("Hint: Try a higher chest number.");
                    else if (guess > nearest)
                        System.out.println("Hint: Try a lower chest number.");
                }
            }

            System.out.println("Attempts left: " + Math.max(attemptsLeft, 0));
            System.out.println();
        }

        if (eggFound == 3) {
            System.out.println("Congratulations! All dragon eggs are safe!");
        } else {
            System.out.println("Game Over! Some dragon eggs remain hidden!");
        }

        sc.close();
    }

    // -----------------------------------
    // Chest selection input
    // -----------------------------------
    public static int readChest(Scanner sc) {
        while (true) {
            System.out.print("Choose a chest (1–10): ");
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n >= 1 && n <= 10)
                    return n;
            } else
                sc.next();

            System.out.println("Invalid input. Enter a number from 1 to 10.");
        }
    }

    // -----------------------------------
    // Random placement (NO ARRAYS)
    // -----------------------------------
    public static void placeUniqueEggs(Random r) {
        int placed = 0;
        while (placed < 3) {
            switch (r.nextInt(10) + 1) {
                case 1:
                    if (!c1Egg) {
                        c1Egg = true;
                        placed++;
                    }
                    break;
                case 2:
                    if (!c2Egg) {
                        c2Egg = true;
                        placed++;
                    }
                    break;
                case 3:
                    if (!c3Egg) {
                        c3Egg = true;
                        placed++;
                    }
                    break;
                case 4:
                    if (!c4Egg) {
                        c4Egg = true;
                        placed++;
                    }
                    break;
                case 5:
                    if (!c5Egg) {
                        c5Egg = true;
                        placed++;
                    }
                    break;
                case 6:
                    if (!c6Egg) {
                        c6Egg = true;
                        placed++;
                    }
                    break;
                case 7:
                    if (!c7Egg) {
                        c7Egg = true;
                        placed++;
                    }
                    break;
                case 8:
                    if (!c8Egg) {
                        c8Egg = true;
                        placed++;
                    }
                    break;
                case 9:
                    if (!c9Egg) {
                        c9Egg = true;
                        placed++;
                    }
                    break;
                case 10:
                    if (!c10Egg) {
                        c10Egg = true;
                        placed++;
                    }
                    break;
            }
        }
    }

    public static void placeUniqueCursed(Random r) {
        int placed = 0;
        while (placed < 2) {
            switch (r.nextInt(10) + 1) {
                case 1:
                    if (!c1Cursed) {
                        c1Cursed = true;
                        placed++;
                    }
                    break;
                case 2:
                    if (!c2Cursed) {
                        c2Cursed = true;
                        placed++;
                    }
                    break;
                case 3:
                    if (!c3Cursed) {
                        c3Cursed = true;
                        placed++;
                    }
                    break;
                case 4:
                    if (!c4Cursed) {
                        c4Cursed = true;
                        placed++;
                    }
                    break;
                case 5:
                    if (!c5Cursed) {
                        c5Cursed = true;
                        placed++;
                    }
                    break;
                case 6:
                    if (!c6Cursed) {
                        c6Cursed = true;
                        placed++;
                    }
                    break;
                case 7:
                    if (!c7Cursed) {
                        c7Cursed = true;
                        placed++;
                    }
                    break;
                case 8:
                    if (!c8Cursed) {
                        c8Cursed = true;
                        placed++;
                    }
                    break;
                case 9:
                    if (!c9Cursed) {
                        c9Cursed = true;
                        placed++;
                    }
                    break;
                case 10:
                    if (!c10Cursed) {
                        c10Cursed = true;
                        placed++;
                    }
                    break;
            }
        }
    }

    // -----------------------------------
    // Getters without arrays
    // -----------------------------------
    public static boolean hasEgg(int n) {
        return switch (n) {
            case 1 -> c1Egg;
            case 2 -> c2Egg;
            case 3 -> c3Egg;
            case 4 -> c4Egg;
            case 5 -> c5Egg;
            case 6 -> c6Egg;
            case 7 -> c7Egg;
            case 8 -> c8Egg;
            case 9 -> c9Egg;
            default -> c10Egg;
        };
    }

    public static boolean isCursed(int n) {
        return switch (n) {
            case 1 -> c1Cursed;
            case 2 -> c2Cursed;
            case 3 -> c3Cursed;
            case 4 -> c4Cursed;
            case 5 -> c5Cursed;
            case 6 -> c6Cursed;
            case 7 -> c7Cursed;
            case 8 -> c8Cursed;
            case 9 -> c9Cursed;
            default -> c10Cursed;
        };
    }

    public static boolean isTaken(int n) {
        return switch (n) {
            case 1 -> c1Taken;
            case 2 -> c2Taken;
            case 3 -> c3Taken;
            case 4 -> c4Taken;
            case 5 -> c5Taken;
            case 6 -> c6Taken;
            case 7 -> c7Taken;
            case 8 -> c8Taken;
            case 9 -> c9Taken;
            default -> c10Taken;
        };
    }

    public static void setTaken(int n) {
        switch (n) {
            case 1 -> c1Taken = true;
            case 2 -> c2Taken = true;
            case 3 -> c3Taken = true;
            case 4 -> c4Taken = true;
            case 5 -> c5Taken = true;
            case 6 -> c6Taken = true;
            case 7 -> c7Taken = true;
            case 8 -> c8Taken = true;
            case 9 -> c9Taken = true;
            case 10 -> c10Taken = true;
        }
    }

    // -----------------------------------
    // Find nearest uncollected egg
    // -----------------------------------
    public static Integer nearestEgg(int guess) {
        Integer nearest = null;
        int best = Integer.MAX_VALUE;

        for (int i = 1; i <= 10; i++) {
            if (hasEgg(i) && !isTaken(i)) {
                int d = Math.abs(i - guess);
                if (d < best) {
                    best = d;
                    nearest = i;
                }
            }
        }
        return nearest;
    }
}
