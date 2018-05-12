package com.example.telproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer role;
    private String username;
    private String password;
    private String email;
    private Integer is_customer;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = username;
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

  public Integer getRole() {
		return role;
	}

  public void setRole(Integer role) {
		this.role = role;
	}
  public Integer setIs_customer(){
    return is_customer;
  }
  public void setIs_customer(Integer is_customer){
    this.is_customer = is_customer;
  }

}
