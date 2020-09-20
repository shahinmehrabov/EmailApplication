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

    // Get and Set email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Get and Set password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Get and Set phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get and Set firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get and Set lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get and Set birthDay
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    // Add, Delete Get mail
    public void addMail(Mail mail) {
        this.mailBox.add(mail);
    }

    public void deleteMail(int index) {
        this.mailBox.remove(index);
    }

    public Mail getMail(int index) {
        return this.mailBox.get(index);
    }

    // Get mailBox size
    public int getMailBoxSize() {
        return mailBox.size();
    }

    // Get trashBin size
    public int getTrashBinSize() { return  trashBin.size(); }

    // Add and Get mail from trashBin
    public void addMailToTrashBin(Mail mail) {
        this.trashBin.add(mail);
    }

    public Mail getMailFromTrashBin(int index) {
        return this.trashBin.get(index);
    }

    public void removeMailFromTrashBin(int index) {
        this.trashBin.remove(index);
    }
}
