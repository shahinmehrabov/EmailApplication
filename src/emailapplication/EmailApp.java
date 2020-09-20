package emailapplication;

import java.util.ArrayList;

public class EmailApp {
    private String appName;
    private ArrayList<Account> accounts;
    private int accountIndex;

    // Constructor
    public EmailApp(String appName) {
        this.appName = appName;
        this.accounts = new ArrayList<Account>();
    }

    // Get and Set appName
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    // Add and Get account
    public void addAccount(Account account) {
        this.accounts.add(account);
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
}
