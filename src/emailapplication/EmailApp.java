package emailapplication;

import java.util.ArrayList;

public class EmailApp {
    private String appName;
    private ArrayList<Account> accounts;
    private ArrayList<Account> admins;
    private int accountIndex;

    // Constructor
    public EmailApp(String appName) {
        this.appName = appName;
        this.accounts = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    // Get and Set appName
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    // Add, Remove and Get account
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(int index) {
        this.accounts.remove(index);
    }

    public Account getAccount(int index) {
        return accounts.get(index);
    }

    // Get accounts size
    public int getAccountsSize() {
        return this.accounts.size();
    }

    // Get account index with email
    public int getAccountIndexWithEmail(String email) {
        for(int i = 0; i < this.accounts.size(); i++) {
            if(email.equals(accounts.get(i).getEmail())) {
                return i;
            }
        }
        return -1;
    }

    // Get accounts
    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    // Add admin
    public void addAdmin(Account account) {
        this.admins.add(account);
    }

    // Get admins
    public ArrayList<Account> getAdmins() {
        return this.admins;
    }

    // Get admins size
    public int getAdminsSize() {
        return this.admins.size();
    }
}
