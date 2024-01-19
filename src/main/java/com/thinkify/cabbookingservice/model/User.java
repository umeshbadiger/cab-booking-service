package com.thinkify.cabbookingservice.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private Long userId;
    private String name;
    private String gender;
    private int age;


	public User( ) {
		super();
	}
    public User(Long userId, String name, String gender, int age) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}
}
