package com.uzhnu.epam.course.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class Application {
    enum DateNowCommand implements Command {
        INSTANCE;

        @Override
        public void execute() {
            System.out.println(System.currentTimeMillis());
        }
    }

    static class EchoCommand implements Command {
        private final String message;

        public EchoCommand(String message) {
            this.message = message;
        }

        @Override
        public void execute() {
            System.out.println(message);
        }
    }

    enum ExitCommand implements Command {
        INSTANCE;

        @Override
        public void execute() {
            System.out.println("Goodbye!");
        }
    }

    enum HelpCommand implements Command {
        INSTANCE;

        @Override
        public void execute() {
            System.out.println("Help executed");
        }
    }

    private static final Map<Function<String[], Boolean>, Function<String[], Command>> COMMAND_MAP = new HashMap<>();

    static {
        COMMAND_MAP.put(
                nonNull(new Function<String[], Boolean>() {
                    @Override
                    public Boolean apply(String[] args) {
                        return Arrays.asList(args).contains("help");
                    }
                }),
                new Function<String[], Command>() {
                    @Override
                    public Command apply(String[] arg) {
                        return HelpCommand.INSTANCE;
                    }
                }
        );
        COMMAND_MAP.put(
                nonNull(new Function<String[], Boolean>() {
                    @Override
                    public Boolean apply(String[] args) {
                        return args.length == 2 && Arrays.asList(args).contains("echo");
                    }
                }),
                new Function<String[], Command>() {
                    @Override
                    public Command apply(String[] args) {
                        return new EchoCommand(args[args.length - 1]);
                    }
                }
        );
        COMMAND_MAP.put(
                nonNull(new Function<String[], Boolean>() {
                    @Override
                    public Boolean apply(String[] args) {
                        List<String> strings = Arrays.asList(args);
                        return strings.contains("date") && strings.contains("now");
                    }
                }),
                new Function<String[], Command>() {
                    @Override
                    public Command apply(String[] arg) {
                        return DateNowCommand.INSTANCE;
                    }
                }
        );
        COMMAND_MAP.put(
                nonNull(new Function<String[], Boolean>() {
                    @Override
                    public Boolean apply(String[] args) {
                        return args.length == 1 && Arrays.asList(args).contains("exit");
                    }
                }),
                new Function<String[], Command>() {
                    @Override
                    public Command apply(String[] arg) {
                        return ExitCommand.INSTANCE;
                    }
                }
        );
    }

    private static Function<String[], Boolean> nonNull(final Function<String[], Boolean> function) {
        return new Function<String[], Boolean>() {
            @Override
            public Boolean apply(String[] args) {
                if (args == null || args.length == 0) {
                    return false;
                } else {
                    return function.apply(args);
                }
            }
        };
    }

    public static void main(String[] args) {
        Function<String[], Command> commandToExecute = null;

        for (Entry<Function<String[], Boolean>, Function<String[], Command>> entry : COMMAND_MAP.entrySet()) {
            Function<String[], Boolean> predicate = entry.getKey();
            Function<String[], Command> command = entry.getValue();

            if (predicate.apply(args)) {
                commandToExecute = command;
                break;
            }
        }

        if (commandToExecute == null) {
            System.out.println("Error");
        } else {
            commandToExecute.apply(args).execute();
        }
    }
}

