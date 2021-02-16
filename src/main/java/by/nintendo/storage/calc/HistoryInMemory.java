package by.nintendo.storage.calc;

import by.nintendo.entity.Calculator;
import by.nintendo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HistoryInMemory implements HistoryStorage {
    private final Map<User, List<Calculator>> list = new HashMap<>();

    @Autowired
    public HistoryInMemory() {
    }



    @Override
    public Map<User, List<Calculator>> getAllList() {
        return list;
    }

    @Override
    public void addInList(User user) {
        list.put(user, user.getList());
    }

//    @Override
//    public Map<User, List<Calculator>> getList() {
//        return list;
//    }
//
//    @Override
//    public void setList(Map<User, List<Calculator>> list) {
//        this.list = list;
//    }
//
//    @Override
//    public void addInList(User user, List<Calculator> calculator) {
//        list.put(user, calculator);
//    }

}

