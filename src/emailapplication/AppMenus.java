package emailapplication;

import java.util.Scanner;

public class AppMenus {
    EmailApp emailApp;

    /* ------------------------------------------------------------ */

    // Constructor
    public AppMenus(EmailApp emailApp) {
        // New Scanner
        Scanner scan = new Scanner(System.in);

        this.emailApp = emailApp;

        // Print mainMenu
        printMainMenu(emailApp, scan);

        // Scanner close
        scan.close();
    }

    /* ------------------------------------------------------------ */

    // Print mainMenu
    public void printMainMenu(EmailApp emailApp, Scanner scan) {
        // Print options
        System.out.println("\n--- WELCOME TO " + emailApp.getAppName().toUpperCase() + " ---\n");
        System.out.println("1. Sign in");
        System.out.println("2. Register");
        System.out.println("3. Quit app\n");
        System.out.print("> Command: ");
        int command = scan.nextInt();

        // Run command
        switch (command) {
            case 1:
                // Login
                SignIn signIn = new SignIn(emailApp);
                printAccountMenu(emailApp, scan, signIn.getAccount(), signIn.AdminOrNot());
                break;
            case 2:
                // Register
                new Register(emailApp);
                break;
            case 3:
                // Quit
                System.out.println("- Good bye :)");
                System.exit(1);
            default:
                System.out.println("- Invalid command! Please try again.\n");

                // Recursion
                printMainMenu(emailApp, scan);
                break;
        }
    }

    // Print accountMenu
    public void printAccountMenu(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        if(admin) {
            // Print option
            System.out.println("\n--- ACCOUNT MENU ---\n");
            System.out.println("- Welcome, " + account.getFirstName() + " " + account.getLastName() + "\n");
            System.out.println("1. Mail box (" + account.getMailBoxSize() + ")");
            System.out.println("2. Send new mail");
            System.out.println("3. Trash bin");
            System.out.println("4. Account settings");
            System.out.println("5. Admin panel");
            System.out.println("6. Sign out");
            System.out.println("7. Quit app");
            System.out.print("\n> Command: ");
            int command = scan.nextInt();

            // Run command
            switch (command) {
                case 1:
                    // Print mailBox
                    printMailBox(emailApp, scan, account, admin);
                    break;
                case 2:
                    // Send new mail
                    sendNewMail(emailApp, scan, account, admin);
                    break;
                case 3:
                    // Print trashBin
                    printTrashBin(emailApp, scan, account, admin);
                    break;
                case 4:
                    // Print account settings
                    printAccountSettings(emailApp, scan, account, admin);
                    break;
                case 5:
                    // Print admin panel
                    printAdminPanel(emailApp, scan, account, admin);
                    break;
                case 6:
                    // Print main menu
                    printMainMenu(emailApp, scan);
                    break;
                case 7:
                    System.out.println("\n- Good bye :)");
                    System.exit(1);
                default:
                    // Default
                    System.out.println("- Invalid command! Please try again.\n");

                    // Recursion
                    printAccountMenu(emailApp, scan, account, admin);
                    break;
            }
        } else {
            // Print option
            System.out.println("\n--- ACCOUNT MENU ---\n");
            System.out.println("- Welcome, " + account.getFirstName() + " " + account.getLastName() + "\n");
            System.out.println("1. Mail box (" + account.getMailBoxSize() + ")");
            System.out.println("2. Send new mail");
            System.out.println("3. Trash bin");
            System.out.println("4. Account settings");
            System.out.println("5. Sign out");
            System.out.println("6. Quit app");
            System.out.print("\n> Command: ");
            int command = scan.nextInt();

            // Run command
            switch (command) {
                case 1:
                    // Print mailBox
                    printMailBox(emailApp, scan, account, admin);
                    break;
                case 2:
                    // Send new mail
                    sendNewMail(emailApp, scan, account, admin);
                    break;
                case 3:
                    // Print trashBin
                    printTrashBin(emailApp, scan, account, admin);
                    break;
                case 4:
                    // Print account settings
                    printAccountSettings(emailApp, scan, account, admin);
                    break;
                case 5:
                    // Print main menu
                    printMainMenu(emailApp, scan);
                    break;
                case 6:
                    System.out.println("\n- Good bye :)");
                    System.exit(1);
                default:
                    // Default
                    System.out.println("- Invalid command! Please try again.\n");

                    // Recursion
                    printAccountMenu(emailApp, scan, account, admin);
                    break;
            }
        }
    }

    /* ------------------------------------------------------------ */

    //Print admin panel
    public void printAdminPanel(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n--- ADMIN PANEL ---\n");
        System.out.println("1. Users");
        System.out.println("2. Admins");
        System.out.println("3. Go back");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        if(command == 1) {
            // Print users list
            printUsers(emailApp, scan, account, admin);
        } else if(command == 2) {
            // Print admins list
            printAdmins(emailApp, scan, account, admin);
        } else if(command ==3) {
            // Print account menu
            printAccountMenu(emailApp, scan, account, admin);
        } else {
            System.out.println("- Invalid command! Please try again.");

            // Recursion
            printAdminPanel(emailApp, scan, account, admin);
        }
    }

    // Print users
    public void printUsers(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n- List of users\n");
        for(int i = 0; i < emailApp.getAccountsSize(); i++) {
            System.out.println((i+1) + ". " + emailApp.getAccount(i).getEmail());
        }

        System.out.println("\n1. Delete account");
        System.out.println("2. Go back");
        System.out.print("\n> Command: ");
        int usersCommand = scan.nextInt();

        if(usersCommand == 1) {
            // Remove account
            removeAccount(emailApp, scan, account, admin);
        } else if(usersCommand == 2) {
            // Print account menu
            printAccountMenu(emailApp, scan, account, admin);
        } else {
            System.out.println("- Invalid command! Please try again.");
            // Recursion
            printUsers(emailApp, scan, account, admin);
        }
    }

    // Print admins
    public void printAdmins(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n- List of admins\n");
        for(int i = 0; i < emailApp.getAdminsSize(); i++) {
            System.out.println((i+1) + ". " + emailApp.getAccount(i).getEmail());
        }
        System.out.println();

        // Print admin panel
        printAdminPanel(emailApp, scan, account, admin);
    }

    // Delete account
    public void removeAccount(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int userIndex = -1;

        while (userIndex < 0 || userIndex > emailApp.getAccountsSize()) {
            System.out.print("\nEnter index: ");
            userIndex = scan.nextInt();

            if(userIndex > 0 && userIndex < emailApp.getAccountsSize()) {
                // Remove account
                emailApp.removeAccount(userIndex - 1);

                // Print users list
                printUsers(emailApp, scan, account, admin);
            } else {
                System.out.println("- Invalid command! Please try again.");

                // Recursion
                removeAccount(emailApp, scan, account, admin);
            }
        }
    }

    /* ------------------------------------------------------------ */

    // Print mailBox
    public void printMailBox(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n--- MAIL BOX ---\n");

        // Print titles of mails
        for (int i = 0; i < account.getMailBoxSize(); i++) {
            System.out.println((i + 1) + ". " + account.getMail(i).getTitle());
        }

        // Print options
        System.out.println("\n1. Read mail");
        System.out.println("2. Delete mail");
        System.out.println("3. Go back");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        // Run command
        if(command == 1) {
            // Read mail
            readMail(emailApp, scan, account, admin);
        } else if(command == 2) {
            // Delete mail
            deleteMail(emailApp, scan, account, admin);
        } else if(command == 3) {
            // Print account menu
            printAccountMenu(emailApp, scan, account, admin);
        } else {
            System.out.println("- Invalid command! Please try again.\n");

            // Recursion
            printMailBox(emailApp, scan, account, admin);
        }

    }

    // Read mail
    public void readMail(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int mailIndex;
        do {
            System.out.print("\n> Mail index: ");
            mailIndex = scan.nextInt();
            if(mailIndex <= account.getMailBoxSize() && mailIndex > 0) {

                // Print mail
                String replyEmail = account.getMail(mailIndex - 1).getFromWho();
                System.out.print("\nFrom who: " + account.getMail(mailIndex - 1).getFromWho());
                System.out.println("\tTo who: " + account.getMail(mailIndex - 1).getToWho());
                System.out.println("Title: " + account.getMail(mailIndex - 1).getTitle());
                System.out.println("Text: " + account.getMail(mailIndex - 1).getText());

                int mailCommand;
                do {
                    // Print options
                    System.out.println("\n1. Delete mail");
                    System.out.println("2. Reply");
                    System.out.println("3. Go back");
                    System.out.print("\n> Command: ");
                    mailCommand = scan.nextInt();

                    // Run command
                    if(mailCommand == 1) {
                        // Delete process
                        account.addMailToTrashBin(account.getMail(mailIndex - 1));
                        account.deleteMail(mailIndex - 1);
                        System.out.println("- Mail deleted.");

                        // Print mailBox
                        printMailBox(emailApp, scan, account, admin);
                    } else if(mailCommand == 2) {
                        scan.nextLine();
                        // Reply mail
                        replyMail(emailApp, scan, account, replyEmail, admin);
                    } else if(mailCommand == 3) {
                        // Print mailBox
                        printMailBox(emailApp, scan, account, admin);
                    }  else {
                        System.out.println("- Invalid command! Please try again.\n");
                    }
                } while (mailCommand < 0 || mailCommand > 3);
            } else {
                System.out.println("- Invalid index! Please try again.\n");
            }
        } while (mailIndex > account.getMailBoxSize() || mailIndex < 0);
    }

    // Delete mail
    public void deleteMail(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int mailIndex;
        do {
            System.out.print("\n> Mail index: ");
            mailIndex = scan.nextInt();
            if(mailIndex <= account.getMailBoxSize() && mailIndex > 0) {
                // Delete process
                account.addMailToTrashBin(account.getMail(mailIndex - 1));
                account.deleteMail(mailIndex - 1);
                System.out.println("- Mail deleted.");
                printMailBox(emailApp, scan, account, admin);
            } else {
                System.out.println("- Invalid index! Please try again.");
            }
        } while (mailIndex >= account.getMailBoxSize() || mailIndex < 0);
    }

    /* ------------------------------------------------------------ */

    // Send new mail
    public void sendNewMail(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
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

        // Print account menu
        printAccountMenu(emailApp, scan, account, admin);
    }

    // Reply mail
    public void replyMail(EmailApp emailApp, Scanner scan, Account account, String replyEmail, boolean admin) {
        String title;
        String text;

        // Print to who
        System.out.println("\n> To who: " + replyEmail);

        // Get title and prevent empty input
        do {
            System.out.print("> Title: ");
            title = scan.nextLine();

            if(title.isEmpty()) {
                System.out.println("- Title field can not be empty! Please try again.");
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

        emailApp.getAccount(emailApp.getAccountIndexWithEmail(replyEmail)).addMail(new Mail(account.getEmail(), replyEmail, title, text));
        System.out.println("\n- Mail sent.");

        // Print account menu
        printAccountMenu(emailApp, scan, account, admin);
    }

    /* ------------------------------------------------------------ */

    // Print trashBin
    public void printTrashBin(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n--- TRASH BIN ---\n");

        // Print titles of mails
        for (int i = 0; i < account.getTrashBinSize(); i++) {
            System.out.println((i + 1) + ". " + account.getMailFromTrashBin(i).getTitle());
        }

        // Print options
        System.out.println("\n1. Read mail");
        System.out.println("2. Recover mail");
        System.out.println("3. Delete mail permanently");
        System.out.println("4. Go back");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        // Run command
        if(command == 1) {
            // Read mail from trash bin
            readTrashMail(emailApp, scan, account, admin);
        } else if(command == 2) {
            // Recover mail
            recoverMail(emailApp, scan, account, admin);
        } else if(command == 3) {
            // Delete mail permanently
            deleteMailPermanently(emailApp, scan, account, admin);
        } else if(command == 4) {
            // Print account menu
            printAccountMenu(emailApp, scan, account, admin);
        } else {
            System.out.println("- Invalid command! Please try again.\n");
            // Recursion
            printTrashBin(emailApp, scan, account, admin);
        }
    }

    // Read mail in trashBin
    public void readTrashMail(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int mailIndex;
        do {
            System.out.print("\n> Mail index: ");
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
                        // Print trash bin
                        printTrashBin(emailApp, scan, account, admin);
                    } else {
                        System.out.println("- Invalid command! Please try again.\n");
                    }
                } while (mailCommand < 0 || mailCommand > 3);
            } else {
                System.out.println("- Invalid index! Please try again.\n");
            }
        } while (mailIndex > account.getTrashBinSize() || mailIndex < 0);
    }

    // Recover mail
    public void recoverMail(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int mailIndex;
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

        // Print trash bin
        printTrashBin(emailApp, scan, account, admin);
    }

    // Delete mail permanently
    public void deleteMailPermanently(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        int mailIndex;
        do {
            System.out.print("> Mail index: ");
            mailIndex = scan.nextInt();

            if(mailIndex > account.getTrashBinSize() || mailIndex < 0) {
                System.out.println(" - Invalid index! Please try again\n");
            }

        } while (mailIndex > account.getTrashBinSize() || mailIndex < 0);

        account.removeMailFromTrashBin(mailIndex - 1);
        System.out.println("- Mail deleted permanently.");

        // Print trash bin
        printTrashBin(emailApp, scan, account, admin);
    }

    /* ------------------------------------------------------------ */

    // Print account settings
    public void printAccountSettings(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("\n--- ACCOUNT SETTINGS ---\n");

        // Print options
        System.out.println("1. Change first name");
        System.out.println("2. Change last name");
        System.out.println("3. Change password");
        System.out.println("4. Change phone number");
        System.out.println("5. Change birthday");
        System.out.println("6. Change security question");
        System.out.println("7. Change answer");
        System.out.println("8. Go back");
        System.out.print("\n> Command: ");
        int command = scan.nextInt();

        // Run command
        switch (command) {
            case 1:
                // Change firstName
                scan.nextLine();
                changeFirstName(emailApp, scan, account, admin);
                break;
            case 2:
                // Change lastName
                scan.nextLine();
                changeLastName(emailApp, scan, account, admin);
                break;
            case 3:
                // Change password
                scan.nextLine();
                changePassword(emailApp, scan, account, admin);
                break;
            case 4:
                // Change phoneNumber
                scan.nextLine();
                changePhoneNumber(emailApp, scan, account, admin);
                break;
            case 5:
                // Change birthDay
                scan.nextLine();
                changeBirthday(emailApp, scan, account, admin);
                break;
            case 6:
                // Change security question
                scan.nextLine();
                changeSecurityQuestion(emailApp, scan, account, admin);
                break;
            case 7:
                // Change answer
                scan.nextLine();
                changeAnswer(emailApp, scan, account, admin);
                break;
            case 8:
                // Print account menu
                scan.nextLine();
                printAccountMenu(emailApp, scan, account, admin);
                break;
            default:
                scan.nextLine();
                System.out.println("- Invalid command! Please try again.");

                // Recursion
                printAccountSettings(emailApp, scan, account, admin);
                break;
        }
    }

    // Change firstName
    public void changeFirstName(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current first name: " + account.getFirstName());
        System.out.print("> New first name: ");
        String firstName = scan.nextLine();

        while(firstName.isEmpty()) {
            System.out.println("- New first name field can not be empty! Please try again.\n");
            changeFirstName(emailApp, scan, account,admin);
        }

        System.out.println("> Your new first name: " + firstName);
        account.setFirstName(firstName);

        // Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    // Change lastName
    public void changeLastName(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current last name: " + account.getLastName());
        System.out.print("> New last name: ");
        String lastName = scan.nextLine();

        while(lastName.isEmpty()) {
            System.out.println("- New last name field can not be empty! Please try again.\n");
            changeLastName(emailApp, scan, account, admin);
        }

        System.out.println("> Your new last name: " + lastName);
        account.setLastName(lastName);

        // Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    // Change password
    public void changePassword(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.print("- Current password: ");
        String currentPassword = scan.nextLine();
        String newPassword;

        if(currentPassword.isEmpty()) {
                System.out.println("- Current password field can not be empty! Please try again.\n");
                System.out.print("> Current password: ");
                currentPassword = scan.nextLine();

                if(currentPassword.equals(account.getPassword())) {
                    System.out.print("> New password: ");
                    newPassword = scan.nextLine();

                    if(newPassword.isEmpty()) {
                        System.out.println("- New password field can not be empty! Please try again.\n");
                        changePassword(emailApp, scan, account, admin);
                    } else {
                        account.setPassword(newPassword);
                        String stars = "";
                        for(int i = 0; i < account.getPassword().length(); i++) {
                            stars += "*";
                        }
                        System.out.println("> Your new password: " + stars);

                        // Print account settings
                        printAccountSettings(emailApp, scan, account, admin);
                    }
                } else {
                    System.out.println("- Wrong password! Please try again.\n");

                    // Recursion
                    changePassword(emailApp, scan, account, admin);
                }
        } else {
            if(currentPassword.equals(account.getPassword())) {
                System.out.print("> New password: ");
                newPassword = scan.nextLine();

                if(newPassword.isEmpty()) {
                    System.out.println("- New password field can not be empty! Please try again.\n");

                    // Recursion
                    changePassword(emailApp, scan, account, admin);
                } else {
                    account.setPassword(newPassword);
                    String stars = "";
                    for(int i = 0; i < account.getPassword().length(); i++) {
                        stars += "*";
                    }
                    System.out.println("> Your new password: " + stars);

                    // Print account settings
                    printAccountSettings(emailApp, scan, account, admin);
                }
            } else {
                System.out.println("- Wrong password! Please try again.\n");

                // Recursion
                changePassword(emailApp, scan, account, admin);
            }
        }
    }

    // Change phoneNumber
    public void changePhoneNumber(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current phone number: " + account.getPhoneNumber());
        System.out.print("> New phone number: ");
        String phoneNumber = scan.nextLine();

        while(phoneNumber.isEmpty()) {
            System.out.println("- New phone number can not be empty. Please try again.\n");

            // Recursion
            changePhoneNumber(emailApp, scan, account, admin);
        }

        System.out.println("> Your new phone number: " + phoneNumber);
        account.setPhoneNumber(phoneNumber);

        // Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    // Change birthday
    public void changeBirthday(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current birthday: " + account.getBirthDay());
        String day;
        String month;
        String year;

        do {
            System.out.print("> Day (1 - 31): ");
            day = scan.nextLine();

            // Prevent empty day input
            if(day.isEmpty()) {
                System.out.println("- Day field can not be empty! Please try again.\n");
            }
        } while(day.isEmpty());

        do {
            System.out.print("> Month (1-12): ");
            month = scan.nextLine();

            // Prevent empty day input
            if(month.isEmpty()) {
                System.out.println("- Month field can not be empty! Please try again.\n");
            }
        } while(month.isEmpty());

        do {
            System.out.print("> Year: ");
            year = scan.nextLine();

            // Prevent empty day input
            if(year.isEmpty()) {
                System.out.println("- Year field can not be empty! Please try again.\n");
            }
        } while(year.isEmpty());

        System.out.println("> Your new birthday: " + account.getBirthDay());
        account.setBirthDay(day + "." + month + "." + year);

        /// Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    // Change security question
    public void changeSecurityQuestion(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current security question: " + account.getSecurityQuestion());
        System.out.print("> New security question: ");
        String securityQuestion = scan.nextLine();

        while(securityQuestion.isEmpty()) {
            System.out.println("- New security question field can not be empty! Please try again.\n");

            // Recursion
            changeSecurityQuestion(emailApp, scan, account, admin);
        }

        System.out.println("> Your new security question: " + securityQuestion);
        account.setSecurityQuestion(securityQuestion);

        // Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    // Change answer
    public void changeAnswer(EmailApp emailApp, Scanner scan, Account account, boolean admin) {
        System.out.println("- Your current answer: " + account.getAnswer());
        System.out.print("> New answer: ");
        String answer = scan.nextLine();

        while(answer.isEmpty()) {
            System.out.println("- New answer field can not be empty! Please try again.\n");

            // Recursion
            changeAnswer(emailApp, scan, account, admin);
        }

        System.out.println("> Your new answer: " + answer);
        account.setSecurityQuestion(answer);

        // Print account settings
        printAccountSettings(emailApp, scan, account, admin);
    }

    /* ------------------------------------------------------------ */
}
