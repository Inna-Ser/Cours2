package Diary;

import Diary.Exception.TaskNotFoundException;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;


public class Main {
    private static final TaskService DIARY = new TaskService();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        readString("title", scanner);
        readString("description", scanner);
        readDate(scanner);
        readTime(scanner);
        readType(scanner);
        readRepeatability(scanner);
        addTask(scanner);

//        System.out.println("Enter the title");
//        while (true) {
//            try {
//                System.out.println("Enter the title");
//            } catch (IncorrectArgumentException e) {
//
//            }
//        }
//        String title = scanner.nextLine();
//
//        System.out.println("Enter the description");
//        String description = scanner.nextLine();
//
//        System.out.println("Enter the date in the format d.MM.yyyy");
//
//        String date = scanner.nextLine();
//
//
//        System.out.println("Enter the time in the format HH:mm");
//        String time = scanner.nextLine();
//
//        System.out.println("Select the type of task");
//        for (Type type : Type.values()) {
//            System.out.println(type.ordinal() + ", " + definitionType(type));
//        }
//        System.out.println("Enter the type");
//        String ordinalLine = scanner.nextLine();
//        String type = scanner.nextLine();
//
//        System.out.println("Select the repeatability of task");
//        for (Task.Repeatability repeatability: Task.Repeatability.values()){
//            System.out.println(repeatability.ordinal() + ", " + definitionRepeatability(repeatability));
//        }
//            System.out.println("Enter the typeRepeatability");
//        String repeatability = scanner.nextLine();
//
//        Task task1 = new EveryMonth("Check the oil in the car", "To arrive to the service", LocalDateTime.now(), Type.PERSONAL);
//        Task task2 = new EveryDay("Walk the dog's", "Walk 40 minutes in the park", LocalDateTime.now(), Type.PERSONAL);
//        Task task3 = new EveryWeek("Submit a report", "Submit a report on the work done for the week in electronic form", LocalDateTime.now(), Type.WORK);
//        Task task4 = new EveryYear("Go through health diagnostics", "Make an appointment with doctor", LocalDateTime.now(), Type.PERSONAL);
//        Task task5 = new EveryDay("Make a list of tasks for next week", "Analyze tasks in the current week and add new tasks", LocalDateTime.now(), Type.WORK);
    }

    private static void addTask(Scanner scanner) {
        String title = readString("Enter the title", scanner);
        String description = readString("Enter the description", scanner);
        LocalDateTime dateTime = readDateTime(scanner);
        Type type = readType(scanner);
        Task.Repeatability repeatability = readRepeatability(scanner);
        Task task;
        switch (repeatability) {
            case ONE_TIME:
                task = new OneTime(title, description, dateTime, type);
                break;
            case EVERY_DAY:
                task = new EveryDay(title, description, dateTime, type);
                break;
            case EVERY_WEEK:
                task = new EveryDay(title, description, dateTime, type);
                break;
            case EVERY_MONTH:
                task = new EveryDay(title, description, dateTime, type);
                break;
            case EVERY_YEAR:
                task = new EveryDay(title, description, dateTime, type);
                break;
            default:
                throw new IllegalArgumentException();
        }
        DIARY.addTask(task);
    }

    private static String readString(String message, Scanner scanner) {
        while (true) {
            System.out.println(message);
            String readString = scanner.nextLine();
            if (readString == null || readString.isEmpty() || readString.isBlank()) {
                System.out.println("Enter the text");
            } else {
                return readString;
            }
        }
    }

    private static Type readType(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Select the type of task");
                for (Type type : Type.values()) {
                    System.out.println(type.ordinal() + ", " + definitionType(type));
                }
                System.out.println("Enter the type");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Type.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Not correct the type task");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("This type task don't found");
            }
        }
    }

    private static Task.Repeatability readRepeatability(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Select the repeatability of task");
                for (Task.Repeatability repeatability : Task.Repeatability.values()) {
                    System.out.println(repeatability.ordinal() + ", " + definitionRepeatability(repeatability));
                }
                System.out.println("Enter the typeRepeatability");
                String ordinalLine = scanner.nextLine();
                int ordinal = Integer.parseInt(ordinalLine);
                return Task.Repeatability.values()[ordinal];
            } catch (NumberFormatException e) {
                System.out.println("Not correct the repeatability task");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("This type task don't found");
            }
        }
    }

    private static LocalDateTime readDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter the date in the format d.mm.yyyy");
                String dateLine = scanner.nextLine();
                return LocalDate.parse(dateLine, DATE_FORMAT).atStartOfDay();
            } catch (DateTimeParseException e) {
                System.out.println("Enter the date in the correct format");
            }
        }
    }

    private static LocalTime readTime(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Enter the time in the format HH:mm");
                String timeLine = scanner.nextLine();
                return LocalTime.parse(timeLine, TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Enter the time in the correct format");
            }
        }
    }

    private static LocalDateTime readDateTime(Scanner scanner) {
        LocalDate localDate = LocalDate.from(readDate(scanner));
        LocalTime localTime = LocalTime.from(readTime(scanner));
        return localDate.atTime(localTime);
    }

    private static void searchTasksOfDay(Scanner scanner) {
        LocalDate localDate = LocalDate.from(readDate(scanner));
        Collection<Task> tasksOfDay = DIARY.getTasksOfDay(localDate);
        System.out.println("Tasks of day " + localDate.format(DATE_FORMAT));
        while (true) {
            try {
                for (Task task : tasksOfDay) {
                    System.out.println(definitionRepeatability(task.getRepeatability()) + " " + task.getTitle() +
                            " " + task.getDescription() + " " + task.getDateTime().format(TIME_FORMAT));
                }
            } catch (DateTimeParseException e) {
                System.out.println("This format is not correct");
            }
        }
    }

    private static void removeTask(Scanner scanner) {
        System.out.println("The list all tasks");
        for (Task task : DIARY.getAllTask()) {
            System.out.println(task);
        }
        while (true) {
            try {
                System.out.println("Select the task for remove");
                String idLine = scanner.nextLine();
                int id = Integer.parseInt(idLine);
                DIARY.removeTask(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This number task is not correct");
            } catch (TaskNotFoundException e) {
                System.out.println("This task didn't found");
            }
        }
    }

    private static void moveTaskToArchive(Scanner scanner) {
        System.out.println("The list all tasks");
        for (Task task : DIARY.getAllTask()) {
            System.out.println(task);
        }
        while (true) {
            try {
                System.out.println("Select the task for move");
                String idLine = scanner.nextLine();
                int id = Integer.parseInt(idLine);
                DIARY.moveTaskToArchive(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("This number task is not correct");
            } catch (TaskNotFoundException e) {
                System.out.println("This task didn't found");
            }
        }
    }

    private static void editTask(Scanner scanner) {
        System.out.println("The list all tasks");
        for (Task task : DIARY.getAllTask()) {
            System.out.println(task);
            System.out.println("Select the task for edit");
            int id = scanner.nextInt();
            System.out.println("Enter the new title");
            String title = scanner.nextLine();

        }
    }


    private static String definitionType(Type type) {
        return switch (type) {
            case WORK -> "work";
            case PERSONAL -> "personal";
        };
    }

    private static String definitionRepeatability(Task.Repeatability repeatability) {
        return switch (repeatability) {
            case ONE_TIME -> "Once";
            case EVERY_DAY -> "Daily";
            case EVERY_WEEK -> "Weekly";
            case EVERY_MONTH -> "Monthly";
            case EVERY_YEAR -> "Yearly";
        };
    }
    private static void sortTaskByDay(Scanner scanner) {
        LocalDate date = null;
        ArrayList<Task> sortTask = new ArrayList<>();
        for (Task task : DIARY.getAllTask()) {
            if (date == LocalDate.from(readDate(scanner))){
                sortTask.add(task);
            }
        }
    }
}
