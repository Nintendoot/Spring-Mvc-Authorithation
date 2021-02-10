package by.nintendo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @NotNull(message = "Not empty")
    @NotBlank(message = "not probel")
    private String name;

    @NotNull(message = "Not empty")
    @NotBlank(message = "not probel")
    private String surname;

    @NotNull(message = "Not empty")
    @NotBlank(message = "not probel")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String login;

    @NotNull(message = "Not empty")
    @NotBlank(message = "not probel")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String password;
    private int id;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname=surname;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password, int id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
