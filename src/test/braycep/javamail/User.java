package test.braycep.javamail;

public class User {
    private String username;
    private String password;
    private String mailHost;
    private String mailPtotocol;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailPtotocol() {
        return mailPtotocol;
    }

    public void setMailPtotocol(String mailPtotocol) {
        this.mailPtotocol = mailPtotocol;
    }
}
