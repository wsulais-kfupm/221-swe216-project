package edu.kfupm.ics321.model;

import java.io.Serializable;
import java.util.*;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocationType type;

    @OneToMany(mappedBy = "location")
    private Set<PackageStore> stores;

    public Location() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<PackageStore> getStores() {
        return stores;
    }

    public void setStores(Set<PackageStore> stores) {
        this.stores = stores;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }
}
