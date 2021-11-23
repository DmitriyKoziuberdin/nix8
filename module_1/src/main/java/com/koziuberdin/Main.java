package com.koziuberdin;

import com.koziuberdin.task.Task1;
import com.koziuberdin.task.Task2;
import com.koziuberdin.task.Task3;
import com.koziuberdin.task.Task4;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    private static final Task1 task1 = new Task1(s);
    private static final Task2 task2 = new Task2(s);
    private static final Task3 task3 = new Task3(s);
    private static final Task4 task4 = new Task4(s);

    public static void main(String[] args) {
        do {
            System.out.println("Please choose task");
            System.out.println("""
                    1)Unique nums
                    2)Endless chessboard
                    3)Triangle area
                    4)String validation""");
            String tasklevel = s.nextLine();
            int tasknum;
            switch (tasklevel) {
                case "1" -> tasknum = 1;
                case "2" -> tasknum = 2;
                case "3" -> tasknum = 3;
                case "4" -> tasknum = 4;
                default -> tasknum = 5;
            }
            levelselect(tasknum);
            System.out.println("Check another task?(y/n)");
        } while (s.nextLine().toLowerCase().startsWith("y"));
    }

    public static void levelselect(int tasknum) {
        System.out.println("So you have chosen ");
        switch (tasknum) {
            case 1 -> {
                System.out.println(task1.name());
                task1.solve();
            }
            case 2 -> {
                System.out.println(task2.name());
                task2.run();
            }
            case 3 -> {
                System.out.println(task3.name);
                task3.run();
            }
            case 4 -> {

                System.out.println(task4.name);
                task4.run();
            }
            default -> System.out.println("Wrong number.");
        }
    }

}



