package by.homework.servlets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by dmurashko on 07.12.2017.
 */
@Entity
@Table (name = "users")
public class Users implements Serializable{
    private static final long serialVersionUID = 1360027157056486431L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Login", nullable = false, unique = true)
    private String Login;
    @Column(name = "Password", nullable = false)
    private String Password;
    @Column(name = "Email", nullable = false, unique = true)
    private String Email;
    @Column (name = "Role", columnDefinition = "INT DEFAULT 1")
    private int Role;
    @Column (name = "BlackList",columnDefinition = "INT DEFAULT 1")
    private int BlackList;

    public Users() {}

    public Users(String login, String password, String email) {

        Login = login;
        Password = password;
        Email = email;




    }

    public Users(int id, String login, String password, String email, int role, int blackList) {
        this.id = id;
        Login = login;
        Password = password;
        Email = email;
        Role = role;
        BlackList = blackList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Role=" + Role +
                ", BlackList=" + BlackList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Role == users.Role &&
                BlackList == users.BlackList &&
                Objects.equals(Login, users.Login) &&
                Objects.equals(Password, users.Password) &&
                Objects.equals(Email, users.Email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, Login, Password, Email, Role, BlackList);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setRole(int role) {
        Role = role;
    }

    public void setBlackList(int blackList) {
        BlackList = blackList;
    }

    public int getId() {

        return id;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public int getRole() {
        return Role;
    }

    public int getBlackList() {
        return BlackList;
    }
}
