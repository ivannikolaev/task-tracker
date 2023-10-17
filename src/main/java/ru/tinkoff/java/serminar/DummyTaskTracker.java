package ru.tinkoff.java.serminar;

import java.util.*;
import java.util.stream.Collectors;

public class DummyTaskTracker implements TaskTracker {

    @Override
    public Task createTask(Task task) {
        return task;
    }

    @Override
    public Task getTask(UUID uuid) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return Collections.emptyList();
    }

    @Override
    public void deleteTask(UUID uuid) {

    }

    @Override
    public List<Task> getPriorityTasks() {
        return Collections.emptyList();
    }

    @Override
    public List<Task> getViewHistory() {
        return Collections.emptyList();
    }

    @Override
    public Map<TaskStatus, List<Task>> getStatusBoard() {
        return Collections.emptyMap();
    }
}
