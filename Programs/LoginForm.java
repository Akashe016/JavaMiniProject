package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginPath {

	public static void main(String args[]) throws IOException {

		while(true) {

		HashMap<String, String> hm = new HashMap<>();
		Scanner input = new Scanner(System.in);
		File file= new File("/home/aakash/number.txt");
		
		System.out.print("Enter the Login or SignUp : ");
		String user = input.next();
		if(user.equals("login")) {
			
		FileReader reader = new FileReader(file);
	
		BufferedReader reader2 = new BufferedReader(reader);
		
		
		String s=reader2.readLine();
		while(s!=null) {
		
			String split[] = s.split(",");
		
			hm.put(split[0], split[1]);
		
			s=reader2.readLine();
		}
		
		System.out.print("Enter the Username : ");
		String username = input.next();
		System.out.print("Enter the Password :");
		String password = input.next();
	
		
		for(Map.Entry<String, String> map : hm.entrySet()) {
			
			if(map.getKey().equals(username) && map.getValue().equals(password)) {	
		
				System.out.println("Login successfully");
				System.out.println("Your name is : "+ username +" "+ password);
				break;
			}	
		}
		}
		else {
			
			FileWriter writer = new FileWriter(file,true);
			BufferedWriter writer2 = new BufferedWriter(writer);
			System.out.print("Enter the Username : ");
			String username = input.next();
			System.out.print("Enter the Password :");
			String password = input.next();
			
			writer2.write(username);
			writer2.write(",");
			writer2.write(password);
			writer2.newLine();
			writer2.flush();
			writer2.close();
		}
		}
	}
}
