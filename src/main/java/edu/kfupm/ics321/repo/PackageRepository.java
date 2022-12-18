package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.Package;
import edu.kfupm.ics321.model.PackageType;
import edu.kfupm.ics321.model.PackageStatus;
import edu.kfupm.ics321.projection.PackageCustomer;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
// import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PackageCustomer.class)
public interface PackageRepository extends PagingAndSortingRepository<Package, Long> {
    List<Package> findByType(@Param("type") PackageType type);

    List<Package> findByStatus(@Param("status") PackageStatus status);

    List<Package> findByFinalDeliveryDate(@Param("date") LocalDate finalDeliveryDate);

    @Query(nativeQuery = true, value="select * from Package p where p.FINAL_DELIVERY_DATE between ISNULL(:from, p.FINAL_DELIVERY_DATE) and ISNULL(:to, p.FINAL_DELIVERY_DATE) AND (p.TYPE = :#{#type?.ordinal()} OR :type IS NULL) AND (p.STATUS = :#{#status?.ordinal()} OR :status IS NULL) AND (p.DESTINATION_ADDRESS LIKE :#{\"%\" + #address + \"%\"} OR :address IS NULL)")
    Page<Package> findBetween(@Param("from") @DateTimeFormat(iso = ISO.DATE) LocalDate from,
                              @Param("to") @DateTimeFormat(iso = ISO.DATE) LocalDate to,
                              @Param("type") Optional<PackageType> type,
                              @Param("status") Optional<PackageStatus> status,
                              @Param("address") String address,
                              Pageable pageable
                              );

    // @Query(nativeQuery=true, value="select STATUS, COUNT(*) as COUNT from Package GROUP BY STATUS")
    // List<?> findCounts();
}
