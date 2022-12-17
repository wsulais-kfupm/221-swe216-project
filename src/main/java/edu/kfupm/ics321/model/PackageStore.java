package edu.kfupm.ics321.model;

import java.util.*;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
// @IdClass(PackageStoreId.class)
public class PackageStore {

    @EmbeddedId
    private PackageStoreId id = new PackageStoreId();

    @ManyToOne
    @MapsId("packageId")
    private Package pkg;

    @ManyToOne
    @MapsId("locationId")
    private Location location;

    @Column(nullable = false)
    @CreatedDate
    private Date date;

    public PackageStore() {
        super();
    }

    public PackageStore(Package pkg, Location location, Date date) {
        this.pkg = pkg;
        this.location = location;
        this.date = date;
    }

    public PackageStoreId getId() {
        return id;
    }

    public Package getPkg() {
        return pkg;
    }

    public void setPkg(Package pkg) {
        this.pkg = pkg;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
