package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ1 {
    public static void main(String[] args) {
        // Variables
        int n;
        int daysoverdue = 0;
        char booktype = 0;
        char borrower = 0;
        int latereturns = 0;
        double fine = 0;
        String booktypeStr;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cases: ");
        n = sc.nextInt();
        // Process each case
        for (int i = 0; i < n; i++) {

            System.out.print("Enter days overdue: ");
            daysoverdue = sc.nextInt();

            // VALIDATE BOOK TYPE
            while (true) {
                System.out.print("Enter book type code (R/G/M/C/T): ");
                booktypeStr = sc.next().toUpperCase();
                booktype = booktypeStr.charAt(0);

                if (booktype == 'R' || booktype == 'G' || booktype == 'M' || booktype == 'C' || booktype == 'T') {
                    break;
                } else {
                    System.out.println("Invalid book type code. Please re-enter.");
                }
            }

            System.out.print("Enter borrower (S for student, T for Staff): ");
            borrower = sc.next().toUpperCase().charAt(0);

            System.out.print("Enter number of previous late returns: ");
            latereturns = sc.nextInt();

            // Fine calculation
            switch (booktype) {
                case 'R':
                    fine = 100;
                    break;
                case 'G':
                    if (daysoverdue >= 1 && daysoverdue <= 7) {
                        fine = daysoverdue * 0.5;
                    } else if (daysoverdue >= 8 && daysoverdue <= 30) {
                        fine = 3.5 + (daysoverdue - 7);
                    } else if (daysoverdue > 30) {
                        fine = 27.5 + (daysoverdue - 30) * 5;
                    }
                    break;
                case 'M':
                    fine = daysoverdue * 0.2;
                    break;
                case 'C':
                    if (daysoverdue <= 10) {
                        fine = daysoverdue * 2;
                    } else {
                        fine = 20 + (daysoverdue - 10) * 5;
                    }
                    break;
                case 'T':
                    fine = daysoverdue * 10;
                    if (daysoverdue > 15) {
                        fine = 200;
                    }
                    break;
            }

            if (daysoverdue > 60)
                fine += 25;
            if (latereturns >= 3)
                fine += 10;
            if (borrower == 'T')
                fine *= 0.8;
            else if (latereturns == 0 && daysoverdue <= 3)
                fine *= 0.5;

            System.out.println("--- Case " + (i + 1) + " ---");
            System.out.printf("Total fine : RM %.2f%n", fine);
        }

        sc.close();
    }
}
