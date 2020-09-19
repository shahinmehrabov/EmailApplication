package emailapplication;

import java.util.Scanner;

public class AppMenus {
    EmailApp emailApp;

    // Constructor
    public AppMenus(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);
        this.emailApp = emailApp;
        printMainMenu(emailApp, scan);
    }

    // Print mainMenu
    public void printMainMenu(EmailApp emailApp, Scanner scan) {
        System.out.println("\n-- WELCOME TO " + emailApp.getAppName().toUpperCase() + " ---\n");
        System.out.println("- What would you like to do?\n");
        System.out.println("1. Sign in");
        System.out.println("2. Register");
        System.out.println("3. Quit\n");
        System.out.print("- Enter your choice: ");
        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                // Login
                SignIn signIn = new SignIn(emailApp);
                if(signIn.startProcess(emailApp)) {
                    printAccountMenu(emailApp, scan);
                }
                break;
            case 2:
                // Register
                new Register(emailApp);
                break;
            case 3:
                // Quit
                System.out.println("- Good bye :)");
                break;
            default:
                System.out.println("- Invalid input! Please try again.\n");
                break;
        }
    }

    // Print accountMenu
    public void printAccountMenu(EmailApp emailApp, Scanner scan) {

    }
}
