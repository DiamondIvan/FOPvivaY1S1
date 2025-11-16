/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Original Message: ");
        String msg = sc.nextLine();
        int[] decimal = new int[msg.length()];
        String[] binary = new String[msg.length()];
        int[] convert = new int[msg.length()];
        int[] end = new int[msg.length()];
        for (int i = 0; i < msg.length(); i++) {
            decimal[i] = msg.charAt(i);
        }
        for (int i = 0; i < decimal.length; i++) {
            String word = "";
            for (int j = 0; j < 8; j++) {
                if (Math.pow(2, (7 - j)) <= decimal[i]) {
                    word = word + "1";
                    decimal[i] = (int) (decimal[i] - Math.pow(2, (7 - j)));
                } else {
                    word = word + "0";
                }
                binary[i] = word;
                convert[i] = Integer.parseInt(binary[i]);

            }
        }

        System.out.println("Encoded Message: ");
        for (int x = 0; x < decimal.length; x++) {
            convert[x] = 11111111 - convert[x];

        }
        for (int y = 0; y < end.length; y++) {
            int sum = 0;
            for (int j = 0; j < 8; j++) {
                if (convert[y] % 10 == 1) {
                    sum = (int) (sum + Math.pow(2, j));
                    convert[y] = convert[y] / 10;
                } else {
                    convert[y] = convert[y] / 10;
                }

            }
            end[y] = sum;
            System.out.print(end[y] + " ");
        }
        sc.close();
    }
}
