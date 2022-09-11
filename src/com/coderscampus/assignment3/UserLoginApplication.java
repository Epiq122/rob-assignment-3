package com.coderscampus.assignment3;


// all the required imports from out rpject

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) throws IOException {

        // Creates an array and adds 5 indexes into it
        User[] userArray = new User[5];
        try (Scanner scan = new Scanner(System.in)) {
            BufferedReader fileReader = null;


            // our try block for the the file reader
            try {
                fileReader = new BufferedReader(new FileReader("data.txt"));


                String line;
                int i = 0;

                // assigned line to the file reader
                while ((line = fileReader.readLine()) != null) {

                    // Create a user data Array and take our file reader  we called line and add the split method so we can add ,
                    String[] userData = line.split(",");

                    // create a userInfo and add 3 sections of data we had in our user class (username,password,name)
                    User userInfo = new User(userData[0], userData[1], userData[2]);
                    //create a userArray and assing it to the user info
                    userArray[i] = userInfo;
                    i++;
                    System.out.println(userInfo);
                }

            } finally {

                fileReader.close();

            }

            boolean loginSuccessful = false;

            int failedAttempts = 6;

            while (loginSuccessful == false) {

                while (true) {
                    failedAttempts--;
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
                        } else if (!loginInfo.getUsername().equalsIgnoreCase(username)
                                || !loginInfo.getPassword().equals(password)) {

                            loginSuccessful = false;

                        }
                        if (failedAttempts == 0) {
                            System.out.println("Too many failed login attempts, you are now locked out.");
                            loginSuccessful = true;
                            break;
                        }
                    }
                    if (loginSuccessful == true) {
                        break;
                    } else {
                        System.out.println("Invalid login, please try again you have " + failedAttempts + " attempts remaining");

                    }
                }
            }
        }
    }
}
