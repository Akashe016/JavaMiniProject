package filehanding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login{
	
	public static void main(String[] args) throws IOException  {
		
		Scanner input = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		
		File file = new File("/home/aakash/"
				+ ""
				+ "login");
		
		while(true) {
		
		System.out.print("sing up / sing in : ");
		String login = input.next();
				
			if(login.equals("in")) {
			
				System.out.println("      Login");
		
				System.out.print("UserName : ");
				String userName = input.next();
				System.out.print("Password : ");
				String password = input.next();

				FileReader reader = new FileReader(file);
				BufferedReader reader2 = new BufferedReader(reader);
		
				String line = reader2.readLine();
		
				while(line!=null) {
			
					String split[] = line.split(",");
				
					map.put(split[0],split[1]);
					line = reader2.readLine();
				}

				for(Map.Entry<String, String> hm : map.entrySet()) {
			
					if(hm.getKey().equals(userName) && hm.getValue().equals(password)) {
				
						System.out.println("Login Successfully");
						System.exit(0);
					}
					else {
						System.out.println("Invalid login, Please try again!");
					}
				}
			}
			else if(login.equals("up")) {
						
				FileWriter writer = new FileWriter(file,true);
				BufferedWriter writer2 = new BufferedWriter(writer);
			
				System.out.println("      Account create");
				System.out.print("UserName : ");
				String userName = input.next();
				System.out.print("Password : ");
				String password = input.next();
			
				Practice.CheckPassword(password, password.length());
			
				if(Practice.CheckPassword(password, password.length())==true) {

					writer2.append(userName);
					writer2.append(",");
					writer2.append(password);
					writer2.newLine();
					writer2.flush();
					writer2.close();
					System.out.println("Account successfully created");		
				}
				else {
					System.out.println("Please enter the valid password!");
				}
			}
		}
	}
	public static boolean CheckPassword(String s,int n) {
				
		boolean b = false;
		int c=0;
		
		if(n<4) {
			
			return false;
		}
		if(s.charAt(0)>='0' && s.charAt(0)<='9') {
			
			return false;
		}
		for(int i=0;i<n;i++) {
			
			if(s.charAt(i)>=65 && s.charAt(i)<=90) {
				c++;
			}
			else if(s.charAt(i)>=97 && s.charAt(i)<=122) {
				c++;
			}
			else if(s.charAt(i)>=48 && s.charAt(i)<=58) {
				c++;
			}
			else if (s.charAt(i)>=91 && s.charAt(i)<=96) {
				c++;
			}
			else {
				
				return false;
			}
		}
		if(c>0) {
			
			return true; 
		}
		else {
			return false;
		}
	}	
}
