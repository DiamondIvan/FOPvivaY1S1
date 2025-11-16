/**
 * This program is a smart digital billing system that automatically calculate taxes,
 * applies discounts, and rewards loyal customers.
 * 
 * @author Angel Tan Ke Qin
 */
package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ2 {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);// Create Scanner
        double price = 0, subtotal = 0, sst = 0;// Initialise

        // input price of items
        System.out.println("Enter item price (0 to finish):");
        price = cs.nextDouble();
        while (price == 0)// Check if first price is negative or not. If negative, loop until user enter
                          // positive value
        {
            System.out.println("Please enter at least one valid item before proceeding. Please re-enter.");
            price = cs.nextDouble();
        }

        // First input price
        while (price < 0)// Check if first price is negative or not. If negative, loop until user enter
                         // positive value
        {
            System.out.println("Invalid amount. Price cannot be negative. Please re-enter.");
            price = cs.nextDouble();
        }
        subtotal += price;// Calculate total

        // Following input price
        while (price != 0) {
            System.out.println("Enter item price (0 to finish):");
            price = cs.nextDouble();

            while (price < 0)// quite loop when number enter is positive
            {// Invalid output
                System.out.println("Invalid amount. Price cannot be negative. Please re-enter.");
                price = cs.nextDouble();// Ask to enter again,if still negative,then will continue loop
            }
            subtotal += price;// sum price to total after quite the loop(value positive)
        }

        // sst for different subtotal
        if (subtotal <= 30)
            sst = 0.06;
        else if (subtotal <= 100)
            sst = 0.08;
        else
            sst = 0.1;

        // total before discount
        double totalBeforeDiscount = subtotal + subtotal * sst;// Total before discount is sum of subtotal and sst
        double discountStu = 0, discountHappyHour = 0, discountWeekend = 0;// Initialise all discount=0
        cs.nextLine();

        // Day of week
        System.out.println("Enter day of week:");
        String day = cs.nextLine().trim();// trim to avoid read \t before or after string
        // Invalid day output to ask user input again
        while (!(day.equalsIgnoreCase("Sunday")
                || day.equalsIgnoreCase("Monday")
                || day.equalsIgnoreCase("Tuesday")
                || day.equalsIgnoreCase("Wednesday")
                || day.equalsIgnoreCase("Thursday")
                || day.equalsIgnoreCase("Friday")
                || day.equalsIgnoreCase("Saturday")))// Check if day entered is invalid
        {
            System.out.println("Invalid day. Please re-enter.");// prompt user until user enter valid value
            day = cs.nextLine().trim();
        }

        System.out.println("Enter hour (24-hour format):");
        int hour = cs.nextInt();// Read hour from user
        // invalid hour output
        while (hour < 0 || hour > 23)// Invalid output
        {
            System.out.println("Invalid hour. Hour should be 0-23. Please re-enter.");
            hour = cs.nextInt();
        }
        // Student Saver Discount and Happy Hour Discount
        if (day.equalsIgnoreCase("Monday")
                || day.equalsIgnoreCase("Tuesday")
                || day.equalsIgnoreCase("Wednesday")
                || day.equalsIgnoreCase("Thursday")
                || day.equalsIgnoreCase("Friday"))// Check if day entered is weekday
        {
            if (totalBeforeDiscount > 25)// Student Saver Discount 10%
                discountStu = totalBeforeDiscount * 0.1;
            if (hour < 17 && hour >= 15)// Happy Hour Discount 5%
                discountHappyHour = (totalBeforeDiscount - discountStu) * 0.05;
        }

        // Weekend Combo Discount
        else if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday")) {
            if (subtotal >= 50)
                discountWeekend = totalBeforeDiscount * 0.05;// Weekend Combo Discount 5%
        }

        double totalPay = (subtotal + (subtotal * sst) - discountHappyHour - discountStu - discountWeekend);// Calculate
                                                                                                            // total
                                                                                                            // payable

        // Membership(cashback 2% for member(Y))
        System.out.println("Is customer a member (Y/N)?");
        char member = cs.next().charAt(0);
        double cashback = 0;
        while (member != 'Y' && member != 'N') {
            System.out.println("Invalid input. Please re-enter.");
            member = cs.next().charAt(0);
        }
        if (member == 'Y')
            cashback = totalPay * 0.02;

        // Output statement
        System.out.println("------ Kopi-Satu Receipt---------");
        System.out.printf("%-25s%-10s%n", "Subtotal:", priceStr(subtotal));
        System.out.printf("%-25s%-10s%n", "Service Tax (" + Math.round(sst * 100) + "):", priceStr(subtotal * sst));
        System.out.printf("%-25s%-10s%n", "Total before discount:", priceStr(totalBeforeDiscount));

        // Print details of discount if applicable
        if (discountStu > 0)
            System.out.printf("%-25s%-10s%n", "Student Discount (10%):", priceStr(discountStu));
        if (discountHappyHour > 0)
            System.out.printf("%-25s%-10s%n", "Happy Hour Discount (5%):", priceStr(discountHappyHour));
        if (discountWeekend > 0)
            System.out.printf("%-25s%-10s%n", "Weekend Combo Discount", priceStr(discountWeekend));
        System.out.println("---------------------------------");
        System.out.printf("%-25s%-10s%n", "Total Payable:", priceStr(totalPay));
        if (cashback > 0) {
            System.out.printf("%-25s%-10s%n", "Loyalty Cashback (2%):", priceStr(cashback));
        }
        System.out.println("---------------------------------");
        System.out.printf("%-25s%-10s%n", "Final Amount to Collect:", priceStr(totalPay));

        cs.close();// Close Scanner
    }

    public static String priceStr(double price)// Method to print RM with price
    {
        return "RM" + String.format("%-9.2f", price);// Return 2 decimal places price with RM
    }

}
