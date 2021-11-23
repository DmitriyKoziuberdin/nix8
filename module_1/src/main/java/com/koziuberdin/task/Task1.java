package com.koziuberdin.task;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private final Random r;
    private final Scanner s;

    public Task1(Scanner s) {
        this.s = s;
        r = new Random();
    }

    public void solve() {
        System.out.println("Manual input?(y/n)");
        int size;
        int[] arr;
        if (s.nextLine().toLowerCase().startsWith("y")) {
            System.out.println("Input size");
            size = s.nextInt();
            s.nextLine();
            arr = new int[size];
            System.out.println("Input the array");
            input_arr(arr, size);
        } else {
            size = r.nextInt(11);
            arr = new int[size];
            generate(arr);
        }
        System.out.print("Your array = ");
        out_arr(arr);
        count_unique(arr);
    }

    private void generate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(11);
        }
    }

    private void out_arr(int[] arr) {
        for (int n :
                arr) {
            System.out.print(n + " ");
        }
    }

    private void input_arr(int[] arr, int size) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        s.nextLine();
    }

    private void count_unique(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    count--;
                    break;
                }
            }
        }
        System.out.println("\nUnique numbers = " + count);
    }

    public String name() {
        return "Count the number of unique numbers in an array";
    }
}
