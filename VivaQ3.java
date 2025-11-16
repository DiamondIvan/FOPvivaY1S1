
/**
 * This program is to check if username are valid and rates password strength.
 * 
 * @author Angel Tan Ke Qin
 */
package FOPvivaY1S1;

import java.util.Scanner;

public class VivaQ3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);

        // Username
        System.out.println("Enter username:");
        String username = cs.nextLine();
        boolean validName = true;
        char firstLetter = username.charAt(0);
        if (!(firstLetter >= 'a' && firstLetter <= 'z')) {
            validName = false;
        }

        if (username.length() > 15 || username.length() < 5) {
            validName = false;
        }

        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c < '9' && c >= '0') || (c == '_')))
                validName = false;
        }

        // Password
        System.out.println("Enter password:");
        String pw = cs.nextLine();
        int ruleMet = 0;

        // Rule 1: Minimum 8 characters
        if (pw.length() >= 8)
            ruleMet++;

        // Rule2: At least one upper case letter
        boolean oneUppercase = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                oneUppercase = true;
                break;
            }
        }
        if (oneUppercase)
            ruleMet++;

        // Rule3: At least one lowercase
        boolean oneLowercase = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c >= 'a' && c <= 'z') {
                oneLowercase = true;
                break;
            }
        }
        if (oneLowercase)
            ruleMet++;

        // Rule4: At least one digit
        boolean digit = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c >= '0' && c <= '9') {
                digit = true;
                break;
            }
        }
        if (digit)
            ruleMet++;

        // Rule 5: At least one special character(!,@,#,$,%,^,&,*)
        boolean specChar = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*') {
                specChar = true;
                break;
            }
        }
        if (specChar)
            ruleMet++;

        // Rule 6: Must not contain any spaces
        boolean space = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c == ' ') {
                space = true;
                break;
            }
        }
        if (!space)
            ruleMet++;

        // Rule 7: Must not contain the username as a substring (case-insensitive)
        boolean containsUsername = false;
        for (int i = 0; i < pw.length() - username.length(); i++) {
            if (pw.regionMatches(true, i, username, 0, username.length())) {
                containsUsername = true;
                break;
            }
        }
        if (validName == false) {
            System.out.println("Invalid username.");
        } else if (validName) {
            // Password strength
            System.out.print("Password Strength: ");
            if (ruleMet == 7)
                System.out.print("Very Strong");
            else if (ruleMet == 6)
                System.out.print("Strong");
            else if (ruleMet >= 4)
                System.out.print("Moderate");
            else
                System.out.print("Weak");
        }
        cs.close();
    }
}
