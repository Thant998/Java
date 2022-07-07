package net.javaguide.jsp.jdbc.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	 private static final long serialVersionUID = 1 ;
	 private String firstName;
	 private String lastName;
	 private String userName;
	 private String password;
	 private String address;
	 private String contact;
	 public void setFirstName(String firstName) {
		 this.firstName=firstName;
	 }
	 public String getFirstName() {
		 return firstName;
	 }
	 public void setLastName(String lastName) {
		 this.lastName=lastName;
	 }
	 public String getLastName() {
		 return lastName;
	 }
	 public void setUserName(String userName) {
		 this.userName=userName;
	 }
	 public String getUserName() {
		 return userName;
	 }
	 public void setPassword(String password) {
		 this.password=password;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setAddress(String address) {
		 this.address=address;
	 }
	 public String getAddress() {
		 return address;
	 }
	 public void setContact(String contact) {
		 this.contact=contact;
	 }
	 public String getContact() {
		 return contact;
	 }
}
