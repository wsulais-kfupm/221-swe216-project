package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "center")
    private Set<Package> packages;

    public Center() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
