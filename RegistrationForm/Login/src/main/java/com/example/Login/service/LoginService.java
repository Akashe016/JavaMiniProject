package com.example.Login.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.example.Login.entity.Form;
import com.example.Login.entity.User;
import com.example.Login.entity.response.LoginResponse;
import com.example.Login.repository.FormRepository;
import com.example.Login.repository.LoginRepository;

@Service
public class LoginService{
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private  FormRepository formRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private String otpnumber=" ";
	private String regnumber=" ";
	private String mail=" " ;
	
	public String singup(User user, Model model) {
		
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
				
		if(checkOnlyFindByEmail(user.getUsername())==true) {
			
			if(checkPassword(user.getPassword(), user.getPassword().length()) == true) {   

				user.setConfirmpassword(user.getConfirmpassword());
			
				if(user.getPassword().equals(user.getConfirmpassword())) {

					loginRepository.save(user);
					
					LoginResponse response = new LoginResponse("your account create successfully\nGo back to login", true);
			        model.addAttribute("message", String.valueOf(response));

					return "login";
				}
				else {
					LoginResponse response = new LoginResponse("Password and ConfirmPassword does not match!", false);
					model.addAttribute("message", String.valueOf(response));
  
					return "account";
				}
			}
			else {
				
				LoginResponse response = new LoginResponse("Please enter correct password\nAtleast one upperCase\nAtleast one lowerCase\nAtleast one numeric\nAtleast one symbol\nAnd length should be greater than 7", false);
				model.addAttribute("message", String.valueOf(response));
				
				return "account";
			}
		}
		else {
			
			LoginResponse response = new LoginResponse("your account already created\nGo to Login", false);
			model.addAttribute("message", String.valueOf(response));

			return "account";
		}
	}

	private boolean checkOnlyFindByEmail(String username) {
		
		List<User> user = loginRepository.findByUsername(username);

		if(user.isEmpty()) {

			return true;
		}
		else {

			Object s=user.get(0);
			String s1 = String.valueOf(s);	
			String split[] = s1.split(",");
			
			String c[] = new String[split.length];
							
			for(int i=0;i<split.length;i++) {
			
				String a = split[i];	
				String split1[] = a.split("=");
				c[i]= split1[1];
			}
			if(c[1].equals(username)) {
				
				return false;
			}
			else {
				
				return true;
			}
		}
	}

	private boolean checkPassword(String password, int len) {
	
		int upper=0,lower=0,symbol=0,number=0,length=0;
		
		for(int i=0;i<len;i++) {
			
			if(password.charAt(i)>=65 && password.charAt(i)<=90){
				
				upper++;
			}
			if(password.charAt(i)>=97 && password.charAt(i)<=122){
				
				lower++;
			}
			if(password.charAt(i)>=48 && password.charAt(i)<=58) {
				
				number++;
			}
			if(password.charAt(i)>=58 && password.charAt(i)<=64 || password.charAt(i)>=32 && password.charAt(i)<=47 ||password.charAt(i)>=91 && password.charAt(i)<=96) {
			
					symbol++;
			}
			if(password.length()>=7) {
				
				length++;
			}
		}
		
		if(upper>0 && lower>0 && number>0 && symbol>0 && length>0) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public String singIn(User user, Model model) {
				
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		if(checkfindOnlyNameAndPassword(user.getUsername(), user.getPassword())==true) {
			
			LoginResponse response = new LoginResponse("Login Successfully", true);
			model.addAttribute("message", String.valueOf(response));
			System.out.println("hi");
			
			user.setUsername(" ");
			user.setPassword(" ");
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			return "form";		
		}
		else {
			
			LoginResponse response = new LoginResponse("Login failed!\nPlease correct username and password or Create account", false);
			model.addAttribute("message", String.valueOf(response));
			
			return "login";
		}
	}
	
	private boolean checkfindOnlyNameAndPassword(String username, String password) {
		
		Optional<User> user = loginRepository.findByUsernameAndPassword(username, password);
		
		if(user.isPresent()) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	@Value("${spring.mail.username}")
	private String formMail;
	
	public void sendemail(User user) {
					
			String otp = generatorOTP();

			SimpleMailMessage mailMessage = new SimpleMailMessage();
	
			mailMessage.setFrom(formMail);
			mailMessage.setSubject("OTP Verfication");
			mailMessage.setText("OTP number : "+otp);
			mailMessage.setTo(user.getUsername());
			
			javaMailSender.send(mailMessage);
			
			otpnumber = otp;
			mail = user.getUsername();
	}
	
	private String generatorOTP() {
		
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);
	}

	private boolean checkFindByUsername(String username) {
		
		List<User> user = loginRepository.findByUsername(username);
		
		Object s=user.get(0);
		String s1 = String.valueOf(s);	
		String split[] = s1.split(",");
		String c[] = new String[split.length];
						
		for(int i=0;i<split.length;i++) {
		
			String a = split[i];	
			String split1[] = a.split("=");
			c[i]= split1[1];
		}				
		
		if(c[1].equals(username)) {
			
			return true;		
		}
		else {
			
			return false;
		}
	}
	
	public String otp(User user, Model model) {
		
		System.out.println(user.getOtp());
		int otp = user.getOtp();
		
		if(String.valueOf(otp).equals(otpnumber)) {
			
			LoginResponse response = new LoginResponse("OTP successfully verified, set new password", true);
			model.addAttribute("message", String.valueOf(response));

			return "password";
		}
		else {
			
			LoginResponse response = new LoginResponse("opt number doesn't match", false);
			model.addAttribute("message", String.valueOf(response));

			return "otp";
		}	
	}
	
	public String password(User user, Model model) {
		
		user.setPassword(user.getPassword());
		user.setConfirmpassword(user.getConfirmpassword());
				
		System.out.println(mail);
		System.out.println(user.getPassword());
		System.out.println(user.getConfirmpassword());
		
		if(checkFindByUsername(mail)==true) {

			if(checkPassword(user.getPassword(), user.getPassword().length()) == true) {
			
				user.setConfirmpassword(user.getConfirmpassword());
			
				if(user.getPassword().equals(user.getConfirmpassword())) {
				
					List<User> users =  loginRepository.findByUsername(mail);
					
					Object s=users.get(0);
									
					String s1 = String.valueOf(s);
					
					String split[] = s1.split(",");
					String c[] = new String[split.length];
									
					for(int i=0;i<split.length;i++) {
					
						String a = split[i];	
						String split1[] = a.split("=");
						c[i]= split1[1];
					}							
					
					user.setId(Integer.parseInt(c[0]));
					user.setUsername(mail);
					user.setPassword(user.getPassword());
					user.setConfirmpassword(user.getConfirmpassword());
					
					loginRepository.save(user);
			
					LoginResponse response = new LoginResponse("Password has been changed", true);
					model.addAttribute("message", String.valueOf(response));

					return "backtologin";
				}
				else {
	
					LoginResponse response = new LoginResponse("Password and ConfirmPassword does not match!", false);
					model.addAttribute("message", String.valueOf(response));

					return "password";
				}
			}
			else {
				 
				LoginResponse response = new LoginResponse("Please enter correct password\nAtleast one upperCase\nAtleast one lowerCase\nAtleast one numeric\nAtleast one symbol\nAnd length should be greater than 7", false);
				model.addAttribute("message", String.valueOf(response));

				return "password";
			}
		}
		else {
			
			LoginResponse response = new LoginResponse("Email doesn't exit\nPlease try again later!", false);
			model.addAttribute("message", String.valueOf(response));

			return "email";
		}
}
	
	public String applicationForm(Form formEntity, Model model){
		
		if(checkFindByUsername(formEntity.getEmail())==true) {
			
			String regNo = generatorRegistedNumber();

			if(!(regNo.equals(regnumber))) {
			
				formEntity.setRegnumber(regNo);
				regnumber = regNo;
				
				LocalDate date = LocalDate.parse(formEntity.getDateofbirth());
				
				formEntity.setDateofbirth(String.valueOf(date));
			
				formRepository.save(formEntity);
			
				sendmail(formEntity.getEmail());
						
				LoginResponse response = new LoginResponse("Form successfully submitted",true);
				model.addAttribute("message", String.valueOf(response));

				return "submit";
			}
			else {
				
				LoginResponse response = new LoginResponse("you are already submitted this form",false);
				model.addAttribute("message", String.valueOf(response));
				
				return "form";
			}
		}
		else {
			
			LoginResponse response = new LoginResponse("Email doesn't exit\nPlease type registered email!", false);
			model.addAttribute("message", String.valueOf(response));

			return "form";
		}		
	}

	private String generatorRegistedNumber() {
		
		Random random = new Random();
		int otp = 10000000 + random.nextInt(90000000);
		return String.valueOf(otp);
	}
	
	public void sendmail(String email) {
							
			List<Form> user = formRepository.findByemail(email);
						
			Object s=user.get(0);
			
			String s1 = String.valueOf(s);
		
			String split[] = s1.split(",");
			
			String c[] = new String[split.length];
						
			for(int i=0;i<split.length;i++) {
		
				String a = split[i];	
				String split1[] = a.split("=");
				c[i]= split1[1];
			}
			
			String line =" ";
			
			for(int i=0;i<split.length;i++) {
				
				line = line+split[i]+"\n\n";	
			}
			
			String msg ="Dear  "+c[3]+",\n\nThank you,Your response has been recored\nYour "
					+ "Register Id is : "+c[2]+"\n\nYour informations,\n\n"+line.trim();
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
	
			mailMessage.setFrom(formMail);
			mailMessage.setSubject("Application form successfully submitted");
			mailMessage.setText(msg);
			mailMessage.setTo(email);
			
			javaMailSender.send(mailMessage);	
		}
	
	public List<Form> regno(String regNo) {
		
		return formRepository.findByregnumber(regNo);
	}
	
	public List<User> selectAll() {
		
		return loginRepository.findAll();
	}	
	
	public String logOut(int id) {
		
		loginRepository.deleteById(id);
		 
		//model.addAttribute("message","Your account has been deleted!");

		return "Your account has been deleted!";
	}
}

