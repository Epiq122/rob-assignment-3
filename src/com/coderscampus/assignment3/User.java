package com.coderscampus.assignment3;

public class User {



	// This allows us to output the username,password and name into the console and show all the information
	public String toString() {
		return "UserInfo [username =  " + username + ", password = " + password + ", name = " + name + "]";
	}



	//  This creates a user constructor used to apply the username , namr and password using this
	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}


	// These are our variables
	private String username;
	private String password;
	private String name;


	// these are the getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
