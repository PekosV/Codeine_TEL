package com.example.telproject.database;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="user")
@DynamicUpdate
//@Data
public class User {
    @Id
    @Column(name="iduser")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer  id ;

    @Column(name="role")
    private String role;

    @Column(name="username")
    private String username;


    @Column(name="email")
    private String email;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="password")
    private String password;

    @Column(name="fee")
    private Integer fee;

    public User (){};

    public User( String email,
                String username,
                String firstname,
                String lastname,
                String password
                ){

        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = "USER";
        this.fee =0 ;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
// public Integer getId() {
    //     return id;
    // }
    //
    // public void setId(Integer id) {
    //     this.id = id;
    // }
    //
    // public String getUsername() {
    //     return username;
    // }
    //
    // public void setUsername(String name) {
    //     this.username = username;
    // }
    //
    // public String getEmail() {
    //     return email;
    // }
    //
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    //
    // public String getPassword() {
    //     return password;
    // }
    //
    // public void setPassword(String password) {
    //     this.password = password;
    // }
    //
    // public Integer getRole() {
    //     return role;
    // }
    //
    // public void setRole(Integer role) {
    //     this.role = role;
    // }
    // public Integer setIs_customer(){
    //     return is_customer;
    // }
    // public void setIs_customer(Integer is_customer){
    //     this.is_customer = is_customer;
    // }

}
