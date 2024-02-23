package se.edu.streamdemo;

import se.edu.streamdemo.data.DataManager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task (stream) manager");
        DataManager dataManager = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

        System.out.println("Printing all data ...");
        printAllData(tasksData);
        printALlDataUsingStreams(tasksData);

        System.out.println("Printing deadlines ...");
        printDeadlines(tasksData);
        printDeadlineUsingStream(tasksData);

        System.out.println("Total number of deadlines (iteration): " + countDeadlines(tasksData));
        System.out.println("Total number of deadlines (stream): " + countDeadlinesUsingStream(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static int countDeadlinesUsingStream (ArrayList<Task> tasks) {
        System.out.println("Counting Deadlines using stream...");
        int count = (int) tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .count();

        return count;
    }
    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println("Printing data using iteration...");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printALlDataUsingStreams(ArrayList<Task> tasks) {
        System.out.println("Printing data using stream...");
        tasks.stream()
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing deadlines using iterations...");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlineUsingStream (ArrayList<Task> tasks) {
        System.out.println("Printing deadlines using stream...");
        tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }
}
