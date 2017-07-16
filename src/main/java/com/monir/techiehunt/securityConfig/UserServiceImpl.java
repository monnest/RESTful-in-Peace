package com.monir.techiehunt.securityConfig;

import com.monir.techiehunt.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    static List<User> users = new ArrayList<User>();

    static{
        users = populateUser();
    }

    public List<User> findAllUsers(){
        return users;
    }

    public User findById(int id){
        for(User u : users){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        System.out.println("Only an Admin can Update a User");
        User u = findById(user.getId());
        users.remove(u);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setType(user.getType());
        users.add(u);
    }

    public void deleteUser(int id){
        User u = findById(id);
        users.remove(u);
    }

    private static List<User> populateUser(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"Raahim","Uddin","admin"));
        users.add(new User(2,"Karim","Miah","admin"));
        users.add(new User(3,"Abdul","Miah","dba"));
        users.add(new User(4,"Tito","T2","dba"));
        return users;
    }

}