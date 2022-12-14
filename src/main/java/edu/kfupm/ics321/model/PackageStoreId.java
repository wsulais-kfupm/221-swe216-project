package edu.kfupm.ics321.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class PackageStoreId implements Serializable {
    private long packageId;
    private long locationId;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    public PackageStoreId() {
        super();
    }

    public PackageStoreId(long packageId, long locationId) {
        this.packageId = packageId;
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return packageId + "," + locationId;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long pkg) {
        this.packageId = pkg;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}
