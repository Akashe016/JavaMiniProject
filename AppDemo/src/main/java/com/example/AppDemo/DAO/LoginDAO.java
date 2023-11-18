package com.example.AppDemo.DAO;

public class LoginDAO {

	private long id;
	private String email;
	private String password;
	private String confirm_password;
	
	/*public LoginDAO(long id,String email, String password, String confirm_password) {
		//super();
		this.id=id;
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
	}
*/
	public LoginDAO() {
	}

	public long getId() {
		return id;
		
	}
	public void SetId(long id) {
		this.id = id;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	@Override
	public String toString() {
		return "LoginDAO [email=" + email + ", password=" + password + ", confirm_password=" + confirm_password + "]";
	}	
}
