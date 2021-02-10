package by.nintendo.storage.user;

import by.nintendo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInMemory implements UserStorage {
    private List<User> userList = new ArrayList<>();

    @Autowired
    public UserInMemory() {
    }

    @Override
    public List<User> allList() {
        return userList;
    }

    @Override
    public boolean userInMemori(User user) {
        boolean result = false;
        for (User us : userList) {
            if (us.equals(user)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean checkLoginAndPassword(User user) {
        boolean result=false;
        for (User us : userList) {
            if (us.getLogin().equals(user.getLogin()) && us.getPassword().equals(user.getPassword())) {
                result=true;
            }
        }
        return result;
    }


    @Override
    public User getByLogin(String name) {
        for (User u : userList) {
            if (name.equals(u.getLogin())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void addInMemory(User user) {
        userList.add(user);
    }
}
