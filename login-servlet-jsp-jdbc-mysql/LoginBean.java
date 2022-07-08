package net.javaguide.loginbean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	  private static final long serialVersionUID = 1 ;
	  private String username;
	  private String password;
	  
	  public void setUserName(String username) {
		  this.username=username;
	  }
	  public String getUserName() {
		  return username;
	  }
	  
	  public void setPassword(String password) {
		  this.password=password;
	  }
	  public String getPassword() {
		  return password;
	  }
}
