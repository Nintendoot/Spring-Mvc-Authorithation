package by.nintendo.storage.calc;

import by.nintendo.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier(value = "inMemory")
public class HistoryInMemory implements HistoryStorage {
    private List<Calculator> list = new ArrayList<>();

@Autowired
    public HistoryInMemory() {
    }
    @Override
    public List<Calculator> getList() {
        return list;
    }
    @Override
    public void setList(List<Calculator> list) {
        this.list = list;
    }
    @Override
    public void addInList(Calculator calculator) {
        list.add(calculator);
    }

}
