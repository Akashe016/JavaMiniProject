package com.example.Login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "form")
public class Form {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String email;
		private String regnumber;
		private String fullName;
		
		@Column(length = 10)
		private long phoneNumber;
		private String dateofbirth;
		private String gender;
		private String address;
		private String state;
		private String city;
		
		@Column(length = 6)
		private int pincode;
		private String qualification;
		private String course;
		private String specification;
		
		@Column(length = 4)
		private int yop;
		@Column(length = 3)
		private double cgpa;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getRegnumber() {
			return regnumber;
		}
		public void setRegnumber(String regnumber) {
			this.regnumber = regnumber;
		}
		public long getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getDateofbirth() {
			return dateofbirth;
		}
		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public String getCourse() {
			return course;
		}
		public void setCourse(String course) {
			this.course = course;
		}
		public String getSpecification() {
			return specification;
		}
		public void setSpecification(String specification) {
			this.specification = specification;
		}
		public int getYop() {
			return yop;
		}
		public void setYop(int yop) {
			this.yop = yop;
		}
		public double getCgpa() {
			return cgpa;
		}
		public void setCgpa(double cgpa) {
			this.cgpa = cgpa;
		}
		
		@Override
		public String toString() {
			return "id=" + id + ", email=" + email + ", regnumber=" + regnumber + ", fullName=" + fullName
					+ ", phoneNumber=" + phoneNumber + ", dateofbirth=" + dateofbirth + ", gender=" + gender + ", address=" + address
					+ ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", qualification="
					+ qualification + ", course=" + course + ", specification=" + specification + ", yop="
					+ yop + ", cgpa=" + cgpa;
		}
}