package com.example.Form.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Form")
public class FormEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String password;
	private String confirm_password;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public FormEntity(int id, String password, String confirm_password, String email) {
		super();
		this.id = id;
		this.password = password;
		this.confirm_password = confirm_password;
		this.email = email;
	}*/
	
	
	@Override
	public String toString() {
		return "FormEntity [id=" + id + ", password=" + password + ", confirm_password=" + confirm_password
				+ ", email=" + email + "]";
	}
	
	
}
