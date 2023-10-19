package ru.tinkoff.java.serminar;

import java.util.List;
import java.util.UUID;

public interface HistoryViewManager {

    void addView(UUID id);

    List<UUID> getViewHistory();

}
