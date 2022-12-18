package edu.kfupm.ics321.projection;

import edu.kfupm.ics321.model.Dimensions;
import edu.kfupm.ics321.model.Customer;
import edu.kfupm.ics321.model.Center;
import edu.kfupm.ics321.model.Package;
import edu.kfupm.ics321.model.PackageType;
import edu.kfupm.ics321.model.PackageStatus;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = { Package.class })
public interface PackageCustomer {

  public long getId();
  public float getWeight();

  public float getInsuranceAmount();

  public Dimensions getDims();

  public float getCost();
  public PackageType getType();

  public PackageStatus getStatus();
  public float getFine();
  public String getDestinationAddress();

  public Date getFinalDeliveryDate();

  public Customer getCustomer();

  public Center getCenter();
}
