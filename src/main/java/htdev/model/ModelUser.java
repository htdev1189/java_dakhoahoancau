package htdev.model;

public class ModelUser {
    private int id;
    private String name;
    private String email;
    private String country;
    private String pass;
    private String user;
    private String image;

    public ModelUser(int id, String name, String email, String country, String pass, String user, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.pass = pass;
        this.user = user;
        this.image = image;
    }

    public ModelUser(String name, String email, String country, String pass, String user, String image) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.pass = pass;
        this.user = user;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
