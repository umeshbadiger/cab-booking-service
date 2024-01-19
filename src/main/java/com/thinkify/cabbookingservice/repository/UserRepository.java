package com.thinkify.cabbookingservice.repository;

import com.thinkify.cabbookingservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    List<User> userList = new ArrayList<>();
    public User addUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }

    public User findByUserId(Long userId){
        User user = userList.stream()
                .filter(userObj-> userObj.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
        return user;
    }

    public int getUsersCount(){
        return userList.size();
    }

    public List<User> getAllUsersList() {
        return new ArrayList<>(userList);
    }

    public User findByUserName(String userName) {
        User user =userList.stream()
                .filter(userObj -> userObj.getName().toLowerCase().equals(userName.toLowerCase()))
                .findFirst()
                .orElse(null);
        return user;
    }
}
