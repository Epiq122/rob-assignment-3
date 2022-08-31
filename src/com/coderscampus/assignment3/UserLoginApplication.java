package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) throws IOException {

		User[] userArray = new User[5];
		try (Scanner scan = new Scanner(System.in)) {
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
					System.out.println(userInfo);
				}

			} finally {

				fileReader.close();

			}

			boolean loginSuccessful = false;
			int failedAttempts = 0;
			while (true) {
				failedAttempts++;
				System.out.println("Enter your email");
				String username = scan.nextLine();
				System.out.println("Enter your password");
				String password = scan.nextLine();

				for (User loginInfo : userArray) {

					if (loginInfo.getUsername().equalsIgnoreCase(username)
							&& loginInfo.getPassword().equals(password)) {
						System.out.println("Welcome: " + loginInfo.getName());
						loginSuccessful = true;
						break;
					}

					else if (!loginInfo.getUsername().equalsIgnoreCase(username)
							|| !loginInfo.getPassword().equals(password)) {

						loginSuccessful = false;

					}
					if (failedAttempts == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");

						break;
					}
				}
				if (loginSuccessful == true) {
					break;
				} else if (loginSuccessful == false) {
					System.out.println("Invalid login, please try again");
				}
			}
		}
	}
}
