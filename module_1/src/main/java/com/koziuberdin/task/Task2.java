package com.koziuberdin.task;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    Scanner s;

    public Task2(Scanner s) {
        this.s = s;
    }

    private int knightX;
    private int knightY;
    private boolean placed;

    public void run() {
        int x;
        int y;
        Random r = new Random();
        System.out.println("please enter the knight's coordinates");
        do {
            System.out.println("Manual input?(y/n)");
            if (s.nextLine().toLowerCase().startsWith("y")) {
                x = s.nextInt();
                s.nextLine();
                y = s.nextInt();
                s.nextLine();
            } else {
                x = r.nextInt(knightY+3);
                y = r.nextInt(knightX+3);
            }if(placeKnight(x, y))
                System.out.println("Knight placed on coordinates ");
            else{
                System.out.println("Knight couldn't be placed at ");
            }
            System.out.printf("(%d, %d)%n", x, y);
            System.out.println("Continue?(y/n)");
        }while(s.nextLine().startsWith("y"));
    }

    private boolean placeKnight(int x, int y) {
        if(!placed){
            knightX = x;
            knightY = y;
            return placed = true;
        }else if((Math.abs(knightX - x) == 2 && Math.abs(knightY - y) == 1) || (Math.abs(knightX-x) == 1 && Math.abs(knightY-y) == 2)) {
            knightX = x;
            knightY = y;
            return true;
        }
        else return false;
    }

    public String name(){
        return "Infinite board";
    }
}
