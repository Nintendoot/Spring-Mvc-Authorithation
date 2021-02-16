package by.nintendo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

  @NotBlank(message = "The field \"name\" must not be empty")
    private String name;


   @NotBlank(message = "The field \"surname\" must not be empty")
    private String surname;


    @NotBlank(message = "The field \"login\" must not be empty")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String login;


    @NotBlank(message = "The field \"password\" must not be empty")
    @Size(min = 4,max = 10,message = "size min = 4,max = 10")
    private String password;

    private int id;

    private  List<Calculator> list=new ArrayList<>();

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

    public List<Calculator> getList() {
        return list;
    }

    public void addList(Calculator calculator){
        list.add(calculator);
    }

    public void setList(List<Calculator> list) {
        this.list = list;
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
