package Userservice;

import com.koziuberdin.dao.UserDao;
import com.koziuberdin.model.User;

public class Userservice {
    private UserDao userDao;

    public Userservice(UserDao userDao){
        this.userDao = userDao;
    }

    public void create(User user){
        userDao.create(user);
    }

    public User findById(int id){
        return userDao.findById(id);
    }

    public User[] findAll(){
        return userDao.findAll();
    }

    public User update(int id, User user ) {
      return userDao.update(id, user);
    }

    public void delete(int id){
       userDao.delete(id);
    }



}
