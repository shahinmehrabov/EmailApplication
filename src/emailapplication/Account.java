package emailapplication;

import java.util.ArrayList;

public class Account {
    private String email;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthDay;
    private ArrayList<Mail> mailBox;
    private ArrayList<Mail> trashBin;

    /* ------------------------------------------------------------ */

    // Constructor
    public Account(String email, String password, String phoneNumber, String firstName, String lastName, String birthDay) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mailBox = new ArrayList<Mail>();
        this.trashBin = new ArrayList<Mail>();
    }

    /* ------------------------------------------------------------ */

    // Get email
    public String getEmail() {
        return email;
    }

    // Set email
    public void setEmail(String email) {
        this.email = email;
    }

    /* ------------------------------------------------------------ */

    // Get password
    public String getPassword() {
        return password;
    }

    // Set password
    public void setPassword(String password) {
        this.password = password;
    }

    /* ------------------------------------------------------------ */

    // Get phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* ------------------------------------------------------------ */

    // Get firstName
    public String getFirstName() {
        return firstName;
    }

    // Set firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /* ------------------------------------------------------------ */

    // Get lastName
    public String getLastName() {
        return lastName;
    }

    // Set lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /* ------------------------------------------------------------ */

    // Get birthDay
    public String getBirthDay() {
        return birthDay;
    }

    // Set birthDay
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /* ------------------------------------------------------------ */

    // Add mail to mailBox
    public void addMail(Mail mail) {
        this.mailBox.add(mail);
    }

    // Delete mail from mailBox
    public void deleteMail(int index) {
        this.mailBox.remove(index);
    }

    // get mail from mailBox with index
    public Mail getMail(int index) {
        return this.mailBox.get(index);
    }

    /* ------------------------------------------------------------ */

    // Get mailBox size
    public int getMailBoxSize() {
        return mailBox.size();
    }

    // Get trashBin size
    public int getTrashBinSize() { return  trashBin.size(); }

    /* ------------------------------------------------------------ */

    // Add mail to trashBin
    public void addMailToTrashBin(Mail mail) {
        this.trashBin.add(mail);
    }

    // Get mail from trashBin
    public Mail getMailFromTrashBin(int index) {
        return this.trashBin.get(index);
    }

    // Remove mail from trashBin
    public void removeMailFromTrashBin(int index) {
        this.trashBin.remove(index);
    }

    /* ------------------------------------------------------------ */
}
