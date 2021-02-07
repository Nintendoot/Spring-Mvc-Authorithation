package by.nintendo.servise.history;

import by.nintendo.model.Calculator;
import by.nintendo.storage.HistoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HistoryImplement implements HistoryServise {
   @Autowired
    HistoryInMemory historyInMemory;

   @Autowired
    public HistoryImplement(HistoryInMemory historyInMemory) {
        this.historyInMemory = historyInMemory;
    }

    @Override
    public void addInHistory(Calculator calculator) {
        historyInMemory.addInList(calculator);
    }

    @Override
    public ArrayList<Calculator> allHistory() {
        return (ArrayList<Calculator>) historyInMemory.getList();
    }
}
