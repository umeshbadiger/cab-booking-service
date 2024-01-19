package com.thinkify.cabbookingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {
    @JsonIgnore
    private String userId;
    private String name;
    private String gender;
    private int age;

    public UserDto(String userId, String name, String gender, int age) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public UserDto(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
