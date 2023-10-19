package ru.tinkoff.java.serminar;

import java.util.*;

public class LinkedHashSetHistoryViewManager implements HistoryViewManager {
    Set<UUID> ids = new LinkedHashSet<>();
    @Override
    public void addView(UUID id) {
        ids.remove(id);
        ids.add(id);
    }

    @Override
    public List<UUID> getViewHistory() {
        return new ArrayList<>(ids);
    }
}
