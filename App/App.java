package coding;

import java.util.HashMap;
import java.util.Scanner;

public class App {
	 private static HashMap<String, String> user = new HashMap<>(); // Map to store registered user credentials

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        String username;
	        String password;

	        while (true) {
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = input.nextInt();
	            input.nextLine(); // Consume newline character after reading integer input

	            switch (choice) {
	                case 1:
	                    System.out.println("Register Form");
	                    System.out.println("--------------");
	                    System.out.print("Enter Username: ");
	                    username = input.nextLine();
	                    System.out.print("Enter Password: ");
	                    password = input.nextLine();
	                    register(username, password);
	                    System.out.println("Registration Successful!");
	                    break;
	                case 2:
	                    System.out.println("Login Form");
	                    System.out.println("-----------");
	                    System.out.print("Enter Username: ");
	                    username = input.nextLine();
	                    System.out.print("Enter Password: ");
	                    password = input.nextLine();
	                    if (login(username, password)) {
	                        System.out.println("Login Successful!");
	                    } else {
	                        System.out.println("Invalid Username or Password. Please try again.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Thank you for using the program. Goodbye!");
	                    input.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    // Method to register a new user
	    public static void register(String username, String password) {
	        user.put(username, password);
	    }

	    // Method to validate login credentials
	    public static boolean login(String username, String password) {
	        if (user.containsKey(username)) {
	            String storedPassword = user.get(username);
	            if (password.equals(storedPassword)) {
	                return true;
	            }
	        }
	        return false;
	    }
	
}
