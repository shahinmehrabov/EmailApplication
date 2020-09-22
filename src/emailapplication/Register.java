package emailapplication;

import java.util.Scanner;

public class Register {
    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthDay;
    private Account account;

    /* ------------------------------------------------------------ */

    public Register(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);

        // Get email from user
        createEmail(emailApp, scan);

        // Get password from user
        createPassword(emailApp, scan);

        // Get phone number from user
        createPhoneNumber(emailApp, scan);

        // Get first name from user
        createFirstName(emailApp, scan);

        // Get last name from user
        createLastName(emailApp, scan);

        // Get birthday from user
        createBirthDay(emailApp, scan);

        // Create and add new account
        account = new Account(this.email, this.password, this.phoneNumber, this.firstName, this.lastName, this.birthDay);
        emailApp.addAccount(account);

        // Print account info after registration process
        System.out.println("\n- Account is successfully created\n");
        System.out.println("> Email: " + this.email);
        System.out.println("> Password: " + printPasswordStars());
        System.out.println("> Phone number: " + this.phoneNumber);
        System.out.println("> Firstname: " + this.firstName);
        System.out.println("> Lastname: " + this.lastName);
        System.out.println("> Birthday: " + this.birthDay);

        new AppMenus(emailApp);
    }

    /* ------------------------------------------------------------ */

    // Create email
    public void createEmail(EmailApp emailApp, Scanner scan) {
        System.out.print("> Email: ");
        this.email = scan.nextLine();

        // Prevents empty input
        if(this.email.isEmpty()) {
            System.out.println("- Email field can not be empty! Please try again.\n");
            createEmail(emailApp, scan);
        } else {
            this.email += "@" + emailApp.getAppName().toLowerCase() + ".com";

            // Check if email exists or not
            for(int i = 0; i < emailApp.getAccountsSize(); i++) {
                if(this.email.equals(emailApp.getAccount(i).getEmail())) {
                    System.out.println("- This email already exists. Please try again.\n");

                    // Recursion
                    createEmail(emailApp, scan);
                }
            }
        }
    }

    // Get email
    public String getEmail() {
        return email;
    }

    // Set email
    public void setEmail(String email) {
        this.email = email;
    }

    /* ------------------------------------------------------------ */

    // Create password
    public void createPassword(EmailApp emailApp, Scanner scan) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        // Prevents empty input
        if(this.password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");

            // Recursion
            createPassword(emailApp, scan);
        }
    }

    // Get password
    public String getPassword() {
        return password;
    }

    // Set password
    public void setPassword(String password) {
        this.password = password;
    }

    /* ------------------------------------------------------------ */

    // Create phoneNumber
    public void createPhoneNumber(EmailApp emailApp, Scanner scan) {
        System.out.print("> Phone number: ");
        this.phoneNumber = scan.nextLine();

        // Prevents empty input
        if(this.phoneNumber.isEmpty()) {
            System.out.println("- Phone number field can not be empty! Please try again.\n");

            // Recursion
            createPhoneNumber(emailApp, scan);
        }

    }

    // Get phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* ------------------------------------------------------------ */

    // Create first name
    public void createFirstName(EmailApp emailApp, Scanner scan) {
        System.out.print("> Firstname: ");
        this.firstName = scan.nextLine();

        // Prevents empty input
        if(this.firstName.isEmpty()) {
            System.out.println("- Firstname field can not be empty! Please try again.\n");

            // Recursion
            createFirstName(emailApp, scan);
        }
    }

    // Get first name
    public String getFirstName() {
        return firstName;
    }

    // Set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /* ------------------------------------------------------------ */

    // Create last name
    public void createLastName(EmailApp emailApp, Scanner scan) {
        System.out.print("> Lastname: ");
        this.lastName = scan.nextLine();

        // Prevents empty input
        if(this.lastName.isEmpty()) {
            System.out.println("- Lastname field can not be empty! Please try again.\n");

            // Recursion
            createLastName(emailApp, scan);
        }
    }

    // Get last name
    public String getLastName() {
        return lastName;
    }

    // Set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* ------------------------------------------------------------ */

    // Create birhtday
    public void createBirthDay(EmailApp emailApp, Scanner scan) {
        System.out.println("- Birthday");
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

        this.birthDay = day + "." + month + "." + year;
    }

    // Get birthday
    public String getBirthDay() {
        return birthDay;
    }

    // Set birthday
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /* ------------------------------------------------------------ */

    // Print password stars
    public String printPasswordStars() {
        String stars = "";
        for (int i = 0; i < this.password.length(); i++) {
            stars += "*";
        }
        return stars;
    }

    /* ------------------------------------------------------------ */
}
