package Controller;

import Userservice.Userservice;
import com.koziuberdin.dao.UserDao;
import com.koziuberdin.model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Controller {
    private final Userservice service;
    private final Scanner in;

    public Controller(){
        service = new Userservice(new UserDao());
        in = new Scanner(System.in);
    }

    public void run(){
        try {
            do {
                System.out.println("""
                Choose what do you want to do:\s
                1-Create
                2-Find by ID
                3-Find all
                4-Update
                5-Delete""");

                switch (Integer.parseInt(in.nextLine())){
                    case 1 -> create();
                    case 2 -> findById();
                    case 3 -> findAll();
                    case 4 -> update();
                    case 5 -> delete();
                    default -> System.out.println("Incorrect value entered");
                }

                System.out.println("Do you want to continue working with users? 1-yes, else-no");
            } while (Integer.parseInt(in.nextLine()) == 1);

        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }  catch (RuntimeException e) {
            System.out.print(e.getMessage());
        }

    }




    private void create() {
        Scanner in = new Scanner(System.in);
        User user = new User();

        String login;
        System.out.print("login -->");
        login = in.next();
        user.setLogin(login);
        System.out.print("login = " + login);

        int age;
        System.out.print("Age --> ");
        age = in.nextInt();
        user.setAge(age);
        System.out.print("Age = " + age);
        service.create(user);
    }

    private void findById() {
        Scanner in = new Scanner(System.in);

        int id;
        System.out.print("Find by ID -->");
        id = in.nextInt();
        in.nextLine();
        User user = service.findById(id);
        System.out.print("Result" + user);

    }

    private void findAll() {
        User[] users = service.findAll();

        for (int i = 0; i < users.length && users[i] != null ; i++) {
            System.out.print(users[i]);
        }

    }

    private void update() {
        Scanner in = new Scanner(System.in);
        User user = new User();

        int id;
        id = in.nextInt();
        while (service.findById(id) == null){
            System.out.print("Enter ID again, user with such ID not found!");
            id = Integer.parseInt(in.nextLine());
        }
        User update = new User();

        String login;
        System.out.print("Enter new login -->");
        login = in.next();
        user.setLogin(login);
        System.out.print("login = " + login);

        int age;
        System.out.print("Enter new age --> ");
        age = in.nextInt();
        user.setAge(age);
        System.out.print("Age = " + age);
        service.update(id, user);


    }

    private void delete() {
        Scanner in = new Scanner(System.in);
        int id;
        id = in.nextInt();
        service.delete(id);
    }


}
