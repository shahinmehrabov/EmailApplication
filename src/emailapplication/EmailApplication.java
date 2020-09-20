package emailapplication;

public class EmailApplication {
    public static void main(String[] args) {
        EmailApp emailApp = new EmailApp("Gmail");
        Account shahin = new Account("shahin@gmail.com", "1524", "577991061", "Shahin", "Mehrabov", "10.08.1997");
        Account mehrabov = new Account("mehrabov@gmail.com", "1234", "577991061", "Shahin", "Mehrabov", "10.08.1997");
        Account musa = new Account("musa@gmail.com", "1234", "577991061", "Shahin", "Mehrabov", "10.08.1997");
        emailApp.addAccount(shahin);
        emailApp.addAccount(mehrabov);
        emailApp.addAccount(musa);
        new AppMenus(emailApp);
    }
}
