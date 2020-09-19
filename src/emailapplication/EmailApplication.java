package emailapplication;

public class EmailApplication {
    public static void main(String[] args) {
        EmailApp emailApp = new EmailApp("Gmail");
        Account shahin = new Account("shahin", "1524", "577991061", "Shahin", "Mehrabov", "10.08.1997");
        emailApp.addAccount(shahin);
        new AppMenus(emailApp);
    }
}
