package emailapplication;

public class Mail {
    private String fromWho;
    private String toWho;
    private String title;
    private String text;

    /* ------------------------------------------------------------ */

    public Mail(String fromWho, String toWho, String title, String text) {
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.title = title;
        this.text = text;
    }

    /* ------------------------------------------------------------ */

    // Get fromWho
    public String getFromWho() {
        return fromWho;
    }

    // Set fromWho
    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    /* ------------------------------------------------------------ */

    // Get toWho
    public String getToWho() {
        return toWho;
    }

    // Set toWho
    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    /* ------------------------------------------------------------ */

    // Get title
    public String getTitle() {
        return title;
    }

    // Set title
    public void setTitle(String title) {
        this.title = title;
    }

    /* ------------------------------------------------------------ */

    // Get text
    public String getText() {
        return text;
    }

    // Set text
    public void setText(String text) {
        this.text = text;
    }

    /* ------------------------------------------------------------ */
}
