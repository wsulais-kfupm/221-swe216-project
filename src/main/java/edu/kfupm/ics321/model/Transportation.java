package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;
    @Column(nullable = false)
    private String route;

    @ManyToMany()
    @JoinTable(name = "transports", joinColumns = {
            @JoinColumn(name = "transportationId") }, inverseJoinColumns = {
                    @JoinColumn(name = "packageId") })
    private Set<Package> packages;

    public Transportation() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }
}
