package emailapplication;

import java.util.Scanner;

public class Register {
    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String securityQuestion;
    private String answer;
    private Account account;

    /* ------------------------------------------------------------ */

    public Register(EmailApp emailApp) {
        Scanner scan = new Scanner(System.in);

        // Get email from user
        createEmail(emailApp, scan);

        // Get password from user
        createPassword(scan);

        // Get phone number from user
        createPhoneNumber(scan);

        // Get first name from user
        createFirstName(scan);

        // Get last name from user
        createLastName(scan);

        // Get birthday from user
        createBirthDay(scan);

        // Get security question from user
        createSecurityQuestion(scan);

        // Get answer from question
        createAnswer(scan);

        // Create and add new account
        account = new Account(this.email, this.password, this.phoneNumber, this.firstName,
                this.lastName, this.birthDay, this.securityQuestion, this.answer);
        emailApp.addAccount(account);

        // Print account info after registration process
        System.out.println("\n- Account is successfully created\n");
        System.out.println("> Email: " + this.email);
        System.out.println("> Password: " + printPasswordStars());
        System.out.println("> Phone number: " + this.phoneNumber);
        System.out.println("> Firstname: " + this.firstName);
        System.out.println("> Lastname: " + this.lastName);
        System.out.println("> Birthday: " + this.birthDay);
        System.out.println("> Security question: " + this.securityQuestion);
        System.out.println("> Answer: " + this.answer);

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
    public void createPassword(Scanner scan) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        // Prevents empty input
        if(this.password.isEmpty()) {
            System.out.println("- Password field can not be empty! Please try again.\n");

            // Recursion
            createPassword(scan);
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
    public void createPhoneNumber(Scanner scan) {
        System.out.print("> Phone number: ");
        this.phoneNumber = scan.nextLine();

        // Prevents empty input
        if(this.phoneNumber.isEmpty()) {
            System.out.println("- Phone number field can not be empty! Please try again.\n");

            // Recursion
            createPhoneNumber(scan);
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
    public void createFirstName(Scanner scan) {
        System.out.print("> Firstname: ");
        this.firstName = scan.nextLine();

        // Prevents empty input
        if(this.firstName.isEmpty()) {
            System.out.println("- Firstname field can not be empty! Please try again.\n");

            // Recursion
            createFirstName(scan);
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
    public void createLastName(Scanner scan) {
        System.out.print("> Lastname: ");
        this.lastName = scan.nextLine();

        // Prevents empty input
        if(this.lastName.isEmpty()) {
            System.out.println("- Lastname field can not be empty! Please try again.\n");

            // Recursion
            createLastName(scan);
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
    public void createBirthDay(Scanner scan) {
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

    // Create security question
    public void createSecurityQuestion(Scanner scan) {
        System.out.print("> Security question: ");
        this.securityQuestion = scan.nextLine();

        // Prevents empty input
        if(this.securityQuestion.isEmpty()) {
            System.out.println("- Security question field can not be empty! Please try again.\n");

            // Recursion
            createSecurityQuestion(scan);
        }
    }

    // Get security question
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    // Set security question
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /* ------------------------------------------------------------ */

    // Create answer
    public void createAnswer(Scanner scan) {
        System.out.print("> Answer: ");
        this.answer = scan.nextLine();

        // Prevents empty input
        if(this.answer.isEmpty()) {
            System.out.println("- Answer field can not be empty! Please try again.\n");

            // Recursion
            createAnswer(scan);
        }
    }

    // Get answer
    public String getAnswer() {
        return answer;
    }

    // Set andwer
    public void setAnswer(String answer) {
        this.answer = answer;
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
