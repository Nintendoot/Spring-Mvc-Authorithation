package by.nintendo.storage.user;

import by.nintendo.entity.User;

import java.util.List;

public interface UserStorage {
    List<User> allList();

    boolean userInMemori(User user);

    void addInMemory(User user);

    boolean checkLoginAndPassword(User user);

    public User getByLogin(String name);
}
