package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Package> packages;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
