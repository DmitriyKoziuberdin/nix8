package com.koziuberdin.dao;

import com.koziuberdin.model.User;

import java.util.Arrays;

public class UserDao {

    private int counter = 1;
    private int lastIndex = 0;



    private User[] users;



    public UserDao() {
        users = new User[16];

    }

    public void create(User user){
        user.setId(counter++);
        if (users.length <= lastIndex ){
           users =  Arrays.copyOf(users,users.length + 16);
        }
        users[lastIndex++] = user;

    }

    public User findById(int id){
        for (int i = 0; i < users.length && users[i] != null; i++) {
            if(users[i].getId() == id)
                return users[i];
        }
        return null;
    }

    public User[] findAll(){
        return users;
    }

    public User update(int id, User user ) {
        for (int i = 0; i < users.length && users[i] != null; i++) {
            User current = users[i];
            if (current.getId() == id){
                current.setAge(user.getAge());
                current.setLogin(user.getLogin());
                return current;
            }
        }
        return null;
    }

    public void delete(int id){
        for (int i = 0; i < users.length && users[i] != null; i++) {
            if (users[i].getId() == id){
                for (int j = i+1; j < users.length && users[i] != null ; j++, i++) {
                    users[i] = users[j];
                }
                lastIndex--;
                break;

            }
        }
    }

}
