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

    public Register(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);

        createEmail(emailApp, scan);
        createPassword(emailApp, scan);
        createPhoneNumber(emailApp, scan);
        createFirstName(emailApp, scan);
        createLastName(emailApp, scan);
        createBirthDay(emailApp, scan);

        account = new Account(this.email, this.password, this.phoneNumber, this.firstName, this.lastName, this.birthDay);
        emailApp.addAccount(account);

        System.out.println("\n- Account is successfully created");
        System.out.println("> Email: " + this.email);
        System.out.println("> Password: " + printPasswordStars());
        System.out.println("> Phone number: " + this.phoneNumber);
        System.out.println("> Firstname: " + this.firstName);
        System.out.println("> Lastname: " + this.lastName);
        System.out.println("> Birthday: " + this.birthDay);

        new AppMenus(emailApp);
    }

    // Create, Get and Set email
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
                    createEmail(emailApp, scan);
                }
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Get and Set password
    public void createPassword(EmailApp emailApp, Scanner scan) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        // Prevents empty input
        if(this.password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");
            createPassword(emailApp, scan);
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Get and Set phoneNumber
    public void createPhoneNumber(EmailApp emailApp, Scanner scan) {
        System.out.print("> Phone number: ");
        this.phoneNumber = scan.nextLine();

        // Prevents empty input
        if(this.phoneNumber.isEmpty()) {
            System.out.println("- Phone number field can not be empty! Please try again.\n");
            createPhoneNumber(emailApp, scan);
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get and Set firstName
    public void createFirstName(EmailApp emailApp, Scanner scan) {
        System.out.print("> Firstname: ");
        this.firstName = scan.nextLine();

        // Prevents empty input
        if(this.firstName.isEmpty()) {
            System.out.println("- Firstname field can not be empty! Please try again.\n");
            createFirstName(emailApp, scan);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get and Set lastName
    public void createLastName(EmailApp emailApp, Scanner scan) {
        System.out.print("> Lastname: ");
        this.lastName = scan.nextLine();

        // Prevents empty input
        if(this.lastName.isEmpty()) {
            System.out.println("- Lastname field can not be empty! Please try again.\n");
            createLastName(emailApp, scan);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get and Set birthDay
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    // Print password stars
    public String printPasswordStars() {
        String stars = "";
        for (int i = 0; i < this.password.length(); i++) {
            stars += "*";
        }
        return stars;
    }
}
