package com.koziuberdin.task;

import java.util.Scanner;

public class Task4 {
    private final Scanner s;

    public Task4(Scanner s) {
        this.s = s;
    }

    public void run() {
        String regex = "\\s.*?|\\{([^\\[\\](){])+|\\[([]]|[^\\[(){}])+|\\((([^]\\[({}])+)";
        try {
            System.out.print("Please enter string.\n");
            String input = s.nextLine();
            System.out.println("input = " + input);
            if(input.replaceAll(regex, "").length()>0)
                throw new Exception("String isn't valid.");
            System.out.println("String is valid.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String name = "String checker";

}
