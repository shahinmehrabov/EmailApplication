package emailapplication;

import java.util.Scanner;

public class SignIn {
    private String email;
    private String password;
    EmailApp emailApp;
    Account account;

    // Constructor
    public SignIn(EmailApp emailApp) {
        this.emailApp = emailApp;
    }

    // Start the process and return true or false
    public boolean startProcess(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);
        return checkEmail(emailApp, scan);
    }

    // Check if email exists or not
    public boolean checkEmail(EmailApp emailApp, Scanner scan) {
        System.out.print("> Email: ");
        this.email = scan.nextLine();

        if(this.email.isEmpty()) {
            System.out.println("- Email field can not be empty! Please try again.\n");
            checkEmail(emailApp, scan);
        } else {
            for(Account acc: emailApp.getAccounts()) {
                if(this.email.equals(acc.getEmail())) {
                    this.account = acc;
                    return checkPassword(emailApp, scan, account);
                }
            }
            System.out.println("- This email address is not exist. Please try again.\n");
            checkEmail(emailApp, scan);
        }
        return false;
    }

    // Check password match with email or not
    public boolean checkPassword(EmailApp emailApp, Scanner scan, Account account) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        if(this.password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");
            checkPassword(emailApp, scan, account);
        } else if(this.password.equals(account.getPassword())){
                return true;
        } else {
            System.out.println("- Wrong password! Please try again.\n");
            checkPassword(emailApp, scan, account);
        }
        return false;
    }

    // Get account index
    public Account getAccount() {
        return account;
    }
}
