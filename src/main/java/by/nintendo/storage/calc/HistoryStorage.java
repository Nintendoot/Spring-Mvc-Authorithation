package by.nintendo.storage.calc;

import by.nintendo.model.Calculator;

import java.util.List;

public interface HistoryStorage {
    List<Calculator> getList();

    void setList(List<Calculator> list);

    void addInList(Calculator calculator);
}
