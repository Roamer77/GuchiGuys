package hello.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Integer  id;

    private String login;
    private  String eMain;
    private  String password; // былжен быть зашифрован. К примеру MD5
    private  String role;
    private boolean active;


    public Account() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Account(String login,  String password,String eMain,String role) {
        this.login = login;
        this.eMain = eMain;
        this.password = password;
        this.role=role;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String geteMain() {
        return eMain;
    }

    public void seteMain(String eMain) {
        this.eMain = eMain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
