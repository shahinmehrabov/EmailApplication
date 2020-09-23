package emailapplication;

public class EmailApplication {
    public static void main(String[] args) {
        EmailApp emailApp = new EmailApp("Gmail");
        Account a = new Account("a", "1524", "577991061", "Shahin",
                "Mehrabov", "10.08.1997", "How old am I?", "23");
        Account b = new Account("b", "1524", "577991061", "Shahin",
                "Mehrabov", "10.08.1997", "How old am I?", "23");
        emailApp.addAccount(a);
        emailApp.addAccount(b);
        emailApp.addAdmin(a);
        new AppMenus(emailApp);
    }
}
