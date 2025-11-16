package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input ic number
        System.out.print("Enter IC number (YYMMDD-##-####): ");
        String ic = sc.next();

        String icNum = ic.replace("-", "");

        // extract birth details
        int year = Integer.parseInt(icNum.substring(0, 2));
        int month = Integer.parseInt(icNum.substring(2, 4));
        int day = Integer.parseInt(icNum.substring(4, 6));
        int lastDigit = Integer.parseInt(icNum.substring(11));

        if (year <= 25) {
            year = year + 2000;
        } else {
            year += 1900;
        }

        // determine gender
        String gender;
        if (lastDigit % 2 == 0) {
            gender = "Female";
        } else {
            gender = "Male";
        }

        // calculate sum
        int sum = 0;
        for (int i = 0; i < icNum.length(); i++) {
            sum = sum + icNum.charAt(i) - '0';
        }

        // month classification
        boolean islongMonth = (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                || month == 12);
        boolean lucky = false;
        if (gender.equals("Male")) {
            if (sum % 5 == 0 && !islongMonth) {
                lucky = true;
            }
        } else {
            if (sum % 7 == 0 && islongMonth) {
                lucky = true;
            }
        }

        // output
        System.out.println("Birth Date: " + day + "/" + month + "/" + year);
        System.out.println("Gender: " + gender);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Lucky Winner: " + (lucky ? "Yes" : "No"));

        sc.close();
    }
}
