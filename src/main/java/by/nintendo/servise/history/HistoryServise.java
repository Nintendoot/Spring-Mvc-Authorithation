package by.nintendo.servise.history;

import by.nintendo.model.Calculator;

import java.util.ArrayList;

public interface HistoryServise {
    void addInHistory(Calculator calculator);

    ArrayList<Calculator> allHistory();
}
