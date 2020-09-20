package emailapplication;

public class Mail {
    private String fromWho;
    private String toWho;
    private String title;
    private String text;

    public Mail(String fromWho, String toWho, String title, String text) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.title = title;
        this.text = text;
    }

    // Get and Set fromWho
    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    // Get and Set toWho
    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    // Get and Set title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Get and Set text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
