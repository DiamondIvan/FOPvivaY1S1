package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ5a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Original Message: ");
        String msg = sc.nextLine();

        System.out.println("Encoded Message:");

        for (int i = 0; i < msg.length(); i++) {

            // 1. CHAR → DECIMAL
            int decimal = msg.charAt(i);

            // 2. DECIMAL → BINARY (8 BITS)
            String binary = "";
            int temp = decimal;
            for (int bit = 7; bit >= 0; bit--) {
                if (temp >= Math.pow(2, bit)) {
                    binary += "1";
                    temp -= Math.pow(2, bit);
                } else {
                    binary += "0";
                }
            }

            // 3. INVERT THE 8 BITS
            String inverted = "";
            for (int j = 0; j < 8; j++) {
                inverted += (binary.charAt(j) == '0') ? "1" : "0";
            }

            // 4. BINARY → DECIMAL
            int finalDecimal = 0;
            for (int j = 0; j < 8; j++) {
                if (inverted.charAt(7 - j) == '1') {
                    finalDecimal += Math.pow(2, j);
                }
            }

            // 5. OUTPUT
            System.out.print(finalDecimal + " ");
        }

        sc.close();
    }
}
