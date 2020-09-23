package emailapplication;

import java.util.Scanner;

public class SignIn {
    private String email;
    private String password;
    private boolean adminOrNot = false;
    EmailApp emailApp;
    Account account;

    /* ------------------------------------------------------------ */

    // Constructor
    public SignIn(EmailApp emailApp) {
        this.emailApp = emailApp;

        Scanner scan = new Scanner(System.in);
        checkEmail(emailApp, scan);
        checkPassword(emailApp, scan, account);

    }

    /* ------------------------------------------------------------ */

    // Check if email exists or not
    public void checkEmail(EmailApp emailApp, Scanner scan) {
        System.out.print("\n> Email: ");
        this.email = scan.nextLine();
        boolean checkEmail = false;

        if(email.isEmpty()) {
            System.out.println("- Email field can not be empty! Please try again.");

            // Recursion
            checkEmail(emailApp, scan);
        } else {
            for(Account account: emailApp.getAccounts()) {
                if(email.equals(account.getEmail())) {
                    checkEmail = true;
                    this.account = account;
                }
            }

            for(Account account: emailApp.getAdmins()) {
                if(email.equals(account.getEmail())) {
                    adminOrNot = true;
                }
            }

            if(!checkEmail) {
                System.out.println("- This email does not exist! Please try again.");

                // Recursion
                checkEmail(emailApp, scan);
            }
        }
    }

    // Check if password match with email or not
    public void checkPassword(EmailApp emailApp, Scanner scan, Account account) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        if(password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");

            // Recursion
            checkPassword(emailApp, scan, account);
        } else {
            if(password.equals(account.getPassword())) {
                this.account = account;
            } else {
                System.out.println("- Wrong password! Please try again.\n");

                // Recursion
                checkPassword(emailApp, scan, account);
            }
        }
    }

    /* ------------------------------------------------------------ */

    // Get account index
    public Account getAccount() {
        return account;
    }

    // Return admin or not
    public boolean AdminOrNot() {
        return adminOrNot;
    }

    /* ------------------------------------------------------------ */
}