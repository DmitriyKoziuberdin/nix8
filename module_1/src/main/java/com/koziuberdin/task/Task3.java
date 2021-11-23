package com.koziuberdin.task;

import java.util.Random;
import java.util.Scanner;

public class Task3 {
    private final Scanner s;
    public Task3(Scanner s) {
        this.s = s;
    }

    public void run() {
        Vertex[] vertices = new Vertex[3];
        Random r = new Random();
        System.out.println("Manual input(y/n)");
        boolean manual = s.nextLine().startsWith("y");
        for (int i = 0; i < 3; i++) {
            System.out.println((char) ('A' + i));
            if (manual)
                vertices[i] = new Vertex();
            else {
                int x = r.nextInt(100);
                int y = r.nextInt(100);
                vertices[i] = new Vertex(x, y);
            }
            System.out.println(vertices[i].x + " " + vertices[i].y);
        }
        double S = (vertices[0].x - vertices[2].x) * (vertices[1].y - vertices[2].y);
        S = S - ((vertices[1].x - vertices[2].x) * (vertices[0].y - vertices[2].y));
        S = Math.abs(0.5 * S);
        System.out.println("area " + S);
    }

    private class Vertex {
        double x;
        double y;

        public Vertex(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Vertex() {
            System.out.println("Please input coordinates");
            this.x = s.nextDouble();
            this.y = s.nextDouble();
        }
    }

    public String name = "find the area of the triangle being given the coordinates";
}
