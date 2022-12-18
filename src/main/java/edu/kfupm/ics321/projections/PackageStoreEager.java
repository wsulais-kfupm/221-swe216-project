package edu.kfupm.ics321.projection;

import edu.kfupm.ics321.model.PackageStore;
import edu.kfupm.ics321.model.PackageStoreId;
import edu.kfupm.ics321.model.Package;
import edu.kfupm.ics321.model.Location;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = { PackageStore.class })
public interface PackageStoreEager {
    public PackageStoreId getId();
    public Package getPkg();
    public Location getLocation();
    public Date getDate();
}
