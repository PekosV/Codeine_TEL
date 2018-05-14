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
    private Integer role;

    @Column(name="username")
    private String username;


    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="customer_boolean")
    private Integer customer_boolean;

    @Column(name="admin_boolean")
    private Integer admin_boolean;


    @Column(name="fee")
    private Integer fee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
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

    public Integer getCustomer_boolean() {
        return customer_boolean;
    }

    public void setCustomer_boolean(Integer customer_boolean) {
        this.customer_boolean = customer_boolean;
    }

    public Integer getAdmin_boolean() {
        return admin_boolean;
    }

    public void setAdmin_boolean(Integer admin_boolean) {
        this.admin_boolean = admin_boolean;
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
