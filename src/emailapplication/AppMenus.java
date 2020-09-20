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
        System.out.println("\n--- WELCOME TO " + emailApp.getAppName().toUpperCase() + " ---\n");
        System.out.println("1. Sign in");
        System.out.println("2. Register");
        System.out.println("3. Quit\n");
        System.out.print("> Command: ");
        int command = scan.nextInt();
        System.out.println();

        switch (command) {
            case 1:
                // Login
                SignIn signIn = new SignIn(emailApp);
                if(signIn.startProcess(emailApp)) {
                    printAccountMenu(emailApp, scan, signIn.getAccount());
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
                System.out.println("- Invalid command! Please try again.\n");
                break;
        }
    }

    // Print accountMenu
    public void printAccountMenu(EmailApp emailApp, Scanner scan, Account account) {
        System.out.println("\n--- ACCOUNT MENU ---\n");
        System.out.println("- Welcome, " + account.getFirstName() + " " + account.getLastName() + "\n");
        System.out.println("1. Mail box (" + account.getMailBoxSize() + ")");
        System.out.println("2. Send new mail");
        System.out.println("3. Trash bin");
        System.out.println("4. Account settings");
        System.out.println("5. Log out");
        System.out.println("6. Quit app");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        switch (command) {
            case 1:
                printMailBox(emailApp, scan, account);
                break;
            case 2:
                sendNewMail(emailApp, scan, account);
                break;
            case 3:
                printTrashBin(emailApp, scan, account);
                break;
            case 4:
            case 5:
                printMainMenu(emailApp, scan);
                break;
            case 6:
                System.out.println("- Good bye :)");
                break;
            default:
                System.out.println("- Invalid command! Please try again.\n");
                printAccountMenu(emailApp, scan, account);
                break;
        }
    }

    // Print mailBox
    public void printMailBox(EmailApp emailApp, Scanner scan, Account account) {
        System.out.println("\n--- MAIL BOX ---\n");
        // Print titles of mails
        for (int i = 0; i < account.getMailBoxSize(); i++) {
            System.out.println((i + 1) + ". " + account.getMail(i).getTitle());
        }

        System.out.println("\n1. Read mail");
        System.out.println("2. Go back");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        if(command == 1) {
            int mailIndex;
            do {
                System.out.print("\n> Mail index: ");
                mailIndex = scan.nextInt();
                if(mailIndex <= account.getMailBoxSize() && mailIndex > 0) {
                    System.out.print("From who: " + account.getMail(mailIndex - 1).getFromWho());
                    System.out.println("\tTo who: " + account.getMail(mailIndex - 1).getToWho());
                    System.out.println("Title: " + account.getMail(mailIndex - 1).getTitle());
                    System.out.println("Text: " + account.getMail(mailIndex - 1).getText());

                    int mailCommand;
                    do {
                        System.out.println("\n1. Delete mail");
                        System.out.println("2. Reply");
                        System.out.println("3. Go back");
                        System.out.print("\n> Command: ");
                        mailCommand = scan.nextInt();

                        if(mailCommand == 1) {
                            account.addMailToTrashBin(account.getMail(mailIndex - 1));
                            account.deleteMail(mailIndex - 1);
                            System.out.println("- Mail deleted.");
                            printMailBox(emailApp, scan, account);
                        } else if(mailCommand == 2) {
                            sendNewMail(emailApp, scan, account);
                        } else if(mailCommand == 3) {
                            printMailBox(emailApp, scan, account);
                        }  else {
                            System.out.println("- Invalid command! Please try again.\n");
                        }
                    } while (mailCommand < 0 || mailCommand > 3);
                } else {
                    System.out.println("- Invalid index! Please try again.\n");
                }
            } while (mailIndex > account.getMailBoxSize() || mailIndex < 0);
        } else if(command == 2) {
            printAccountMenu(emailApp, scan, account);
        } else {
            System.out.println("- Invalid command! Please try again.\n");
            printMailBox(emailApp, scan, account);
        }

    }

    // Send new mail
    public void sendNewMail(EmailApp emailApp, Scanner scan, Account account) {
        String toWho;
        String title;
        String text;
        boolean runToWho = false;

        // Get email, check if it is exists and prevent empty input
        scan.nextLine();
        do {
            System.out.print("\n> To who: ");
            toWho = scan.nextLine();

            if(toWho.isEmpty()) {
                System.out.println("- To who field can not be empty! Please try again.");
            } else {
                for (Account acc: emailApp.getAccounts()) {
                    if(toWho.equals(acc.getEmail())) {
                        runToWho = true;
                    }
                }

                if(!runToWho) {
                    System.out.println("- This email doesn't exist. Please try again.");
                }
            }
        } while (!runToWho);

        // Get title and prevent empty input
        do {
            System.out.print("> Title: ");
            title = scan.nextLine();

            if(title.isEmpty()) {
                System.out.println("- Title field can not be empty! Please try again.\n");
            }
        } while (title.isEmpty());

        // Get text and prevent empty input
        do {
            System.out.print("> Text: ");
            text = scan.nextLine();

            if(text.isEmpty()) {
                System.out.println("- Text field can not be empty! Please try again.\n");
            }
        } while (text.isEmpty());

        emailApp.getAccount(emailApp.getAccountIndexWithEmail(toWho)).addMail(new Mail(account.getEmail(), toWho, title, text));
        System.out.println("\n- Mail sent.");
        printAccountMenu(emailApp, scan, account);
    }

    // Print trashBin
    public void printTrashBin(EmailApp emailApp, Scanner scan, Account account) {
        System.out.println("\n--- TRASH BIN ---\n");

        // Print titles of mails
        for (int i = 0; i < account.getTrashBinSize(); i++) {
            System.out.println((i + 1) + ". " + account.getMailFromTrashBin(i).getTitle());
        }

        System.out.println("\n1. Read mail");
        System.out.println("2. Recover mail");
        System.out.println("3. Delete mail permanently");
        System.out.println("4. Go back");
        System.out.print("> Command: ");
        int command = scan.nextInt();

        int mailIndex;
        if(command == 1) {

            do {
                System.out.print("> Mail index: ");
                mailIndex = scan.nextInt();

                if(mailIndex <= account.getTrashBinSize() && mailIndex > 0) {
                    System.out.print("From who: " + account.getMail(mailIndex - 1).getFromWho());
                    System.out.println("\tTo who: " + account.getMail(mailIndex - 1).getToWho());
                    System.out.println("Title: " + account.getMail(mailIndex - 1).getTitle());
                    System.out.println("Text: " + account.getMail(mailIndex - 1).getText());

                    int mailCommand;
                    do {
                        System.out.println("\n1. Go back");
                        System.out.print("\n> Command: ");
                        mailCommand = scan.nextInt();

                        if(mailCommand == 1) {
                            printTrashBin(emailApp, scan, account);
                        } else {
                            System.out.println("- Invalid command! Please try again.\n");
                        }
                    } while (mailCommand < 0 || mailCommand > 3);
                } else {
                    System.out.println("- Invalid index! Please try again.\n");
                }
            } while (mailIndex > account.getTrashBinSize() || mailIndex < 0);
        } else if(command == 2) {
            do {
                System.out.print("> Mail index: ");
                mailIndex = scan.nextInt();

                if(mailIndex > account.getTrashBinSize() || mailIndex < 0) {
                    System.out.println(" - Invalid index! Please try again\n");
                }

            } while (mailIndex > account.getTrashBinSize() || mailIndex < 0);

            account.addMail(account.getMailFromTrashBin(mailIndex - 1));
            account.removeMailFromTrashBin(mailIndex - 1);
            System.out.println("- Mail recovered.");
            printTrashBin(emailApp, scan, account);
        } else if(command == 3) {
            do {
                System.out.print("> Mail index: ");
                mailIndex = scan.nextInt();

                if(mailIndex > account.getTrashBinSize() || mailIndex < 0) {
                    System.out.println(" - Invalid index! Please try again\n");
                }

            } while (mailIndex > account.getTrashBinSize() || mailIndex < 0);

            account.removeMailFromTrashBin(mailIndex - 1);
            System.out.println("- Mail deleted permanently.");
            printTrashBin(emailApp, scan, account);

        } else if(command == 4) {
            printAccountMenu(emailApp, scan, account);
        } else {
            System.out.println("- Invalid command! Please try again.\n");
            printTrashBin(emailApp, scan, account);
        }
    }
}
