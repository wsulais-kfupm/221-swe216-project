package edu.kfupm.ics321.model;

import java.util.*;
import java.util.Set;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Package {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @ManyToOne
  @JoinColumn(name = "customerId")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "centerId")
  private Center center;

  @Column(nullable = false)
  private float weight;

  @Embedded
  @Column(nullable = false)
  private Dimensions dimensions;

  @Column(nullable = false)
  private float insuranceAmount;
  // private Date finalDeliveryDate;

  @Column(nullable = false)
  private PackageType type;
  @Column(nullable = false)
  private PackageStatus status;

  @Column(nullable = false)
  private float fine;

  @Column(nullable = false)
  @CreatedDate
  private Date finalDeliveryDate;

  // @OneToOne(mappedBy = "pkg", cascade = CascadeType.ALL)
  // private PackageFine fine;

  public Package() {
    this(0.0f, new Dimensions(), 0.0f, new Date());
  }

  public Package(float weight, Dimensions dimensions, float insuranceAmount, Date finalDeliveryDate) {
    super();
    this.weight = weight;
    this.dimensions = dimensions;
    this.insuranceAmount = insuranceAmount;
    this.finalDeliveryDate = finalDeliveryDate;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public float getInsuranceAmount() {
    return insuranceAmount;
  }

  public void setInsuranceAmount(float insuranceAmount) {
    this.insuranceAmount = insuranceAmount;
  }

  public Dimensions getDims() {
      return dimensions;
  }

  public void setDims(Dimensions dimensions) {
      this.dimensions = dimensions;
  }

  public float getCost() {
      return Math.max(weight, this.dimensions.getVolumetricWeight()) + fine;
  }

  public PackageType getType() {
      return type;
  }

  public void setType(PackageType type) {
      this.type = type;
  }


  public PackageStatus getStatus() {
      return status;
  }

  public void setStatus(PackageStatus status) {
    if (this.status == PackageStatus.DELAYED && status != PackageStatus.DELAYED) {
      this.fine = 0.0f;
    }
    this.status = status;
  }

  public float getFine() {
      return fine;
  }

  public void setFine(float fine) {
      if (this.status == PackageStatus.DELAYED) {
          this.fine = Math.max(0.0f, fine);
      }
  }

  public Date getFinalDeliveryDate() {
      return finalDeliveryDate;
  }

  public void setFinalDeliveryDate(Date finalDeliveryDate) {
      this.finalDeliveryDate = finalDeliveryDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
      this.customer = customer;
  }

  public Center getCenter() {
    return center;
  }

  public void setCenter(Center center) {
      this.center = center;
  }

@Override
  public String toString() {
    return "Package [id=" + id + "]";
  }
}
