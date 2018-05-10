package mk.edu.fikt.pmpdomasno;

public class Zbor {

    public String zbor;
    public String opis;
    public String userName;

    public Zbor() {
    }

    public Zbor(String zbor, String opis , String userName) {
        this.zbor = zbor;
        this.opis = opis;
        this.userName = userName;
    }

    public String getZbor() {
        return zbor;
    }

    public void setZbor(String zbor) {
        this.zbor = zbor;
    }

    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

}
