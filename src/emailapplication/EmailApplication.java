package emailapplication;

public class EmailApplication {
    public static void main(String[] args) {
        EmailApp emailApp = new EmailApp("Gmail");
        Account shahin = new Account("shahin@gmail.com", "1524", "577991061", "Shahin",
                "Mehrabov", "10.08.1997", "How old am I?", "23");
        emailApp.addAccount(shahin);
        emailApp.addAdmin(shahin);
        new AppMenus(emailApp);
    }
}
