package connect;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Atm {

	public static void main(String[] args)throws Exception {

		int add,sub,a1=0,total;
	
		 System.out.println("----Welcome to ATM Machine----");

	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter the name : ");
	        String name = input.next();
	        System.out.print("Enter Your 4 digit Atm Pin : ");
	        int pin = input.nextInt();
	        
			int num = pin;
	        if (num == pin) {
	            while (true) {
	                System.out.println("""
	                                        
	                        1. Deposit amount
	                        2. Withdraw amount
	                        3. Check available balances
	                        4. Mini Statement
	                        5. Account create
	                        6. Exit
	                                       
	                        """);
	                System.out.print("Enter choice : ");
	                int ch = input.nextInt();
	                	
	                if(ch==1) {
	                	
	                	int arr[]=new int[10];
	                	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","akash","Akash@2001");
	        			Statement st=con.createStatement();
	        			
	                	System.out.println("****Deposit Amount****");
	                    System.out.print("Enter the Amount : ");
	                    add = input.nextInt();
	                   	a1=a1+add;
	                   	String update="update atm set amount="+a1+",deposit_amt="+add+" where pin_no ="+pin+"";
	                   	st.executeUpdate(update);
	                   	System.out.println("..."+add+" $ Deposited successfully...");
		               //	break;
	                }
	                else if(ch==2) { 
	                	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","akash","Akash@2001");
	        			Statement st1=con1.createStatement();
	        			
	                    System.out.println("****Withdraw Amount****");
	                    System.out.print("Enter the Amount : ");
	                    sub = input.nextInt();
	                    total=a1-sub;
	                    String update1="update atm set amount="+total+",withdraw_amt="+sub+" where pin_no ="+pin+"";
	                    st1.executeUpdate(update1);
	                    System.out.println("...Collect your cash and card..." + sub+ "$");
	                    //break;
	                }
	                else if(ch==3) {
	               
	                	
	                    System.out.println("****Available Balance****");
	                    Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","akash","Akash@2001");
	        			Statement st2=con2.createStatement();
	        			ResultSet rs1=st2.executeQuery("select * from atm");
	        			
	        			while( rs1.next())
	        			{
	        				int pin_no=rs1.getInt(1);
	        				String name1=rs1.getString(2);
	        				int amount=rs1.getInt(3);
	        				int deposit_atm=rs1.getInt(4);
	        				int withdraw_atm=rs1.getInt(5);
	        				String select="select "+amount+" from atm";
	        				System.out.println(select);
	        				//st.execute(select);
	        			}
	        			con2.close();
	        			//break;
	                }
	                else if(ch==4) { 
	                    System.out.println("****Mini Statement****");
	                    
	                    Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","akash","Akash@2001");
	        			Statement st3=con3.createStatement();
	        			ResultSet rs2=st3.executeQuery("select * from atm");
	        			
	        			while( rs2.next())
	        			{
	        				int pin_no=rs2.getInt(1);
	        				String name1=rs2.getString(2);
	        				int amount=rs2.getInt(3);
	        				int deposit_atm=rs2.getInt(4);
	        				int withdraw_atm=rs2.getInt(5);
	        				System.out.println(pin_no+", "+name1+", "+amount+", "+deposit_atm+", "+withdraw_atm);
	        				//st.execute(select);
	        			}
	        			con3.close();         
	                    //break;
	                }
	                else if(ch==5) {
	                	System.out.println("****Account Create****");
	                	Connection con6=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","akash","Akash@2001");
	        			Statement st4=con6.createStatement();
	        			
	                	String insert="insert into atm values("+pin+",'"+name+"',"+0+","+0+","+0+")";
	                   	st4.executeUpdate(insert);
	                   	System.out.println("...Account create successfully...");
		               	//break;
	                }
	                else if(ch==6) {
	                    System.exit(0);
	                    //break;
	                }
	                else {
	                    System.out.println("Please enter the correct option");
	                }
	            }
	            
	        }
	        System.out.println("Please collect your ATM card\n Thank you");
	}
}
