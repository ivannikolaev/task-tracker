package ru.tinkoff.java.serminar;

import java.util.Scanner;

public class CommandLineParser {

    private static final String EXIT_CMD = "exit";
    private static final String ADD_TASK = "add";
    private static final String GET_TASK = "get";
    private static final String REMOVE_TASK = "remove";
    private static final String GET_ALL_TASKS = "all";
    private static final String GET_PRIORITY_TASKS = "priority";
    private static final String GET_HISTORY = "history";
    private static final String GET_STATUS = "status";
    private static final String UPDATE_STATUS = "update";


    private static final String HELP_MESSAGE = """
        Commands:
        - add <summary> <priority>
        - get <id>
        - remove <id>
        - all
        - priority
        - history
        - status
        """;

    private final Scanner scanner = new Scanner(System.in);
    private final CommandHandler commandHandler = new CommandHandler();

    public void run() {
        String input = null;
        while (!EXIT_CMD.equals(input)) {
            input = scanner.nextLine();
            String[] args = input.split(" ");
            String command = extractCommand(args);
            String result = switch (command) {
                case ADD_TASK -> commandHandler.addTask(args);
                case GET_TASK -> commandHandler.getTask(args);
                case REMOVE_TASK -> commandHandler.removeTask(args);
                case GET_ALL_TASKS -> commandHandler.getAllTasks(args);
                case GET_PRIORITY_TASKS -> commandHandler.getPriorityTasks(args);
                case GET_HISTORY -> commandHandler.getHistory(args);
                case GET_STATUS -> commandHandler.getStatus(args);
                case UPDATE_STATUS -> commandHandler.updateStatus(args);
                case null, default -> HELP_MESSAGE;
            };
            System.out.println(result);
        }
    }

    private String extractCommand(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        return null;
    }

}
