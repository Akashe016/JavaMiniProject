package com.example.AccountDetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	private int pinNumber;
	private Long phoneNumber;
	private Long withdraw;
	private Long deposite;
	private int pinChange;
	private Long balance;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPinnumber() {
		return pinNumber;
	}
	public void setPinnumber(int pinNumber) {
		 this.pinNumber = pinNumber;
	}
	public Long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(Long withdraw) {
		this.withdraw = withdraw;
	}
	public Long getDeposite() {
		return deposite;
	}
	public void setDeposite(Long deposite) {
		this.deposite = deposite;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPinChange() {
		return pinChange;
	}
	public void setPinChange(int pinChange) {
		this.pinChange = pinChange;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", Name=" + Name + ", pinNumber=" + pinNumber + ", phoneNumber="
				+ phoneNumber + ", withdraw=" + withdraw + ", deposite=" + deposite + ", pinChange=" + pinChange
				+ ", balance=" + balance;
	}
	

	
	
}
