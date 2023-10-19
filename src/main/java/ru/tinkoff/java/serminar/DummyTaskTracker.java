package ru.tinkoff.java.serminar;

import java.util.*;
import java.util.stream.Collectors;

public class DummyTaskTracker implements TaskTracker {

    @Override
    public Task createTask(Task task) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task getTask(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> getAllTasks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteTask(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> getPriorityTasks() {
        return Collections.emptyList();
    }

    @Override
    public List<Task> getViewHistory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<TaskStatus, List<Task>> getStatusBoard() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Task> removeTask(UUID uuid) {
        throw new UnsupportedOperationException();
    }
}
