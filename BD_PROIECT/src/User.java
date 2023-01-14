public class User {
    private String id_user;
    private String nume;
    private String prenume;
    private String CNP;
    private String adresa;
    private String tel;
    private String email;
    private String username;
    private String password;

    public User() {
    }

    public User(String id_user) {
        this.id_user = id_user;
    }

    public User(String id_user, String nume, String prenume, String CNP, String adresa, String tel, String email) {
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.adresa = adresa;
        this.tel = tel;
        this.email = email;
    }
    public User(String nume, String prenume, String CNP, String adresa, String tel, String email) {
        this.id_user = id_user;
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.adresa = adresa;
        this.tel = tel;
        this.email = email;
    }

    public String getId_user() {
        return id_user;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user='" + id_user + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", adresa='" + adresa + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
