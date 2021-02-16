package by.nintendo.storage.calc;

import by.nintendo.entity.Calculator;
import by.nintendo.entity.User;

import java.util.List;
import java.util.Map;

public interface HistoryStorage {
    void addInList(User user);
     Map<User, List<Calculator>> getAllList();

}
