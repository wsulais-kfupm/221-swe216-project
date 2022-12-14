package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.Package;
import edu.kfupm.ics321.model.PackageType;
import edu.kfupm.ics321.model.PackageStatus;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PackageRepository extends PagingAndSortingRepository<Package, Long> {
    List<Package> findByType(@Param("type") PackageType type);

    List<Package> findByStatus(@Param("status") PackageStatus status);

    List<Package> findByFinalDeliveryDate(@Param("date") Date finalDeliveryDate);
}
