package by.nintendo.storage;

import by.nintendo.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryInMemory {
    private List<Calculator> list = new ArrayList<>();

@Autowired
    public HistoryInMemory() {
    }

    public List<Calculator> getList() {
        return list;
    }

    public void setList(List<Calculator> list) {
        this.list = list;
    }

    public void addInList(Calculator calculator) {
        list.add(calculator);
    }

}
