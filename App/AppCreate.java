package coding;

public class AppCreate {

	private String email;
	private String pass;
	private String cPass;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getcPass() {
		return cPass;
	}
	public void setcPass(String cPass) {
		this.cPass = cPass;
	}
	
	
	@Override
	public String toString() {
		return "AppCreate [email=" + email + ", pass=" + pass + ", cPass=" + cPass + "]";
	}
	
	
}
