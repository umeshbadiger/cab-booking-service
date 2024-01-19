package com.thinkify.cabbookingservice.service;

import com.thinkify.cabbookingservice.exception.UserAlreadyExistsException;
import com.thinkify.cabbookingservice.model.User;
import com.thinkify.cabbookingservice.model.UserDto;
import com.thinkify.cabbookingservice.repository.UserRepository;
import com.thinkify.cabbookingservice.util.SequenceIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public ResponseEntity<?> addUser(UserDto userDetailsDto){

        ResponseEntity<?> responseEntity;
        try{
            Long userId = null;
            User userObj = null;
            User newUser = null;

            if(userDetailsDto.getUserId() != null) {
                userId = Long.parseLong(userDetailsDto.getUserId());
                userObj = userRepo.findByUserId(Long.parseLong(userDetailsDto.getUserId()));
            }
            if(userObj == null) {
                 userId = SequenceIdGenerator.generateId(userRepo.getUsersCount());
                newUser = new User(userId, userDetailsDto.getName(), userDetailsDto.getGender(), userDetailsDto.getAge());
                newUser = userRepo.addUser(newUser);
                responseEntity = new ResponseEntity<>(newUser, HttpStatus.OK);
            } else {
                throw new UserAlreadyExistsException("user with Id: "+ userDetailsDto.getUserId() +" already Exists");

            }
        }catch (UserAlreadyExistsException exception){
            exception.printStackTrace();
            responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity responseEntity = null;
        List<User> userList = null;
        try{
            userList = userRepo.getAllUsersList();

        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }


}
