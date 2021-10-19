package com.koziuberdin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BaseOperationsController {
    public static void main(String[] args) {
        BaseOperationsController controller = new BaseOperationsController();
        controller.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);//(System.in) - поток ввода
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Choose task
                    1 - Some of numbers in string;
                    2 - How many times each character is in the string;
                    3 - Time of the end of the lesson;
                    Anything else to quit.""");
            switch (scanner.nextLine()) {
                case "1":
                    task1(scanner);
                    break;
                case "2":
                    task2(scanner);
                    break;
                case "3":
                    task3(scanner);
                    break;
                default:
                    flag = false;
            }
        }
    }


    private void task1(Scanner scanner) {
        int sum = 0;
        String temp = "";
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                temp = temp.concat(String.valueOf(s.charAt(i)));
            } else {
                if (!temp.equals("")) {
                    sum += Integer.parseInt(temp);
                    temp = "";
                }
            }
        }
        if (!temp.equals("")) {
            sum += Integer.parseInt(temp);
        }
        System.out.println("Sum of given string = " + sum);
    }


    private void task2(Scanner scanner) {
        String s = scanner.nextLine();
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character.UnicodeBlock ofChar = Character.UnicodeBlock.of(s.charAt(i));
            if (ofChar.equals(Character.UnicodeBlock.CYRILLIC) || Character.isAlphabetic(s.charAt(i))) {
                if (charMap.containsKey(s.charAt(i)))
                    charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
                else
                    charMap.put(s.charAt(i), 1);
            }
        }
        for (Character c :
                charMap.keySet()) {
            System.out.println(c + " - " + charMap.get(c));
        }
    }


    private void task3(Scanner scanner) {
        int time = 540;
        System.out.println("Input lesson's number.");
        int lesson = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= lesson; i++) {
            if (i % 2 != 0) {
                time += 50;
            } else {
                time += 60;
            }
        }
        if (lesson % 2 != 0) {
            time -= 5;
        } else {
            time -= 15;
        }
        System.out.println("Your lesson ends at - " + time / 60 + ":" + time % 60);
    }

}

