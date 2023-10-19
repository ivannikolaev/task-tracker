package ru.tinkoff.java.serminar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListHistoryViewManager implements HistoryViewManager {
    private List<UUID> ids = new ArrayList<>();
    @Override
    public void addView(UUID id) {
        ids.add(id);
    }

    @Override
    public List<UUID> getViewHistory() {
        return ids;
    }
}
