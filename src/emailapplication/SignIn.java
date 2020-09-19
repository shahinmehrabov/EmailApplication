package emailapplication;

import java.util.Scanner;

public class SignIn {
    private String email;
    private String password;
    private int index;
    EmailApp emailApp;
    private static int countEmail = 0;
    private static int countPassword = 0;

    // Constructor
    public SignIn(EmailApp emailApp) {
        this.emailApp = emailApp;
        this.index = index;
    }

    // Start the process and return true or false
    public boolean startProcess(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);
        return checkEmail(emailApp, scan);
    }

    // Check if email exists or not
    public boolean checkEmail(EmailApp emailApp, Scanner scan) {
        System.out.print("\n> Email: ");
        this.email = scan.nextLine();

        if(this.email.isEmpty()) {
            System.out.println("- Email field can not be empty! Please try again.\n");
            checkEmail(emailApp, scan);
        } else {
            for (int i = 0; i < emailApp.accountsSize(); i++) {
                    if(this.email.equals(emailApp.getAccount(i).getEmail())) {
                        this.index = i;
                        while (countPassword < 3) {
                            if(checkPassword(emailApp, scan, index)) {
                                return true;
                            } else if(countPassword == 2) {
                                System.out.println("- You tried 3 times. Process stopped.\n");
                                return false;
                            }
                            countPassword++;
                        }
                    } else {
                        System.out.println("- This email address is not exist. Please try again.\n");
                        countEmail++;
                        if(countEmail == 3) {
                            System.out.println("- You tried 3 times. Process stopped.\n");
                            return false;
                        } else {
                            checkEmail(emailApp, scan);
                        }
                    }
            }
        }
        return false;
    }

    // Check password match with email or not
    public boolean checkPassword(EmailApp emailApp, Scanner scan, int index) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        if(this.password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");
            checkPassword(emailApp, scan, index);
        } else if(this.password.equals(emailApp.getAccount(index).getPassword())){
                return true;
        } else {
            System.out.println("- Wrong password! Please try again.\n");
            return false;
        }
        return false;
    }
}
