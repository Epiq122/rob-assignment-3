package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {
		UserService userService = new UserService();
		User[] userArray = new User[4];

		Scanner scan = new Scanner(System.in);

		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String line;
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] userData = line.split(",");
				User userInfo = new User(userData[0], userData[1], userData[2]);
				userArray[i] = userInfo;
				i++;
				System.out.println(line);
			}

		} finally {

			fileReader.close();

		}
	}

}
