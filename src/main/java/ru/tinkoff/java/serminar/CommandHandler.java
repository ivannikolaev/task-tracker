package ru.tinkoff.java.serminar;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommandHandler {

    private final TaskTracker taskTracker = new DummyTaskTracker();

    public String addTask(String[] args) {
        try {
            Task task = new Task();
            task.setId(UUID.randomUUID());
            task.setSummary(args[1]);
            task.setPriority(Integer.parseInt(args[2]));
            task.setStatus(TaskStatus.TODO);
            task.setDateCreated(LocalDateTime.now());
            return taskTracker.createTask(task).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getTask(String[] args) {
        try {
            UUID uuid = UUID.fromString(args[1]);
            return taskTracker.getTask(uuid).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getHistory(String[] args) {
        try {
            return taskTracker.getViewHistory().stream()
                    .map(Task::toString)
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String removeTask(String[] args) {
        try {
            UUID uuid = UUID.fromString(args[1]);
            return taskTracker.removeTask(uuid)
                    .map(t -> "Removed task " + uuid)
                    .orElse("Task not found " + uuid);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getAllTasks(String[] args) {
        try {
            return taskTracker.getAllTasks().stream()
                    .map(Task::toString)
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPriorityTasks(String[] args) {
        try {
            return taskTracker.getPriorityTasks().stream()
                    .map(Task::toString)
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getStatus(String[] args) {
        try {
            return taskTracker.getStatusBoard().entrySet().stream()
                    .map(entry -> entry.getKey() + "\n" + entry.getValue().stream()
                            .map(Task::toString)
                            .collect(Collectors.joining("\n")))
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateStatus(String[] args) {
        UUID uuid = UUID.fromString(args[1]);
        return taskTracker.updateStatus(uuid).toString();
    }
}
