package ru.tinkoff.java.serminar;

import java.util.*;
import java.util.stream.Collectors;

public class DummyTaskTracker implements TaskTracker {
    private HistoryViewManager historyViewManager = new LinkedHashSetHistoryViewManager();

    private Map<UUID, Task> tasks = new HashMap<>();
    private TreeSet<Task> indexedTasks = new TreeSet<>(Comparator.comparingInt(Task::getPriority));

    @Override
    public Task createTask(Task task) {
        tasks.put(task.getId(), task);
        indexedTasks.add(task);
        return task;
    }

    @Override
    public Task getTask(UUID uuid) {
        historyViewManager.addView(uuid);
        return tasks.get(uuid);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public void deleteTask(UUID uuid) {
        tasks.remove(uuid);
    }

    @Override
    public List<Task> getPriorityTasks() {
        return indexedTasks.stream().toList();
    }

    @Override
    public List<Task> getViewHistory() {
        return historyViewManager.getViewHistory().stream().map(id -> tasks.get(id)).toList();
    }

    @Override
    public Map<TaskStatus, List<Task>> getStatusBoard() {
        return tasks.values().stream().collect(Collectors.groupingBy(Task::getStatus));
    }

    @Override
    public Optional<Task> removeTask(UUID uuid) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Task updateStatus(UUID uuid) {
        Task task = tasks.get(uuid);
        task.setStatus(TaskStatus.IN_PROGRESS);
        return task;
    }
}
