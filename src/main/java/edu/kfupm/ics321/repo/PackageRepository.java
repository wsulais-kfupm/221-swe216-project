package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.Package;
import edu.kfupm.ics321.model.PackageType;
import edu.kfupm.ics321.model.PackageStatus;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PackageRepository extends PagingAndSortingRepository<Package, Long> {
    List<Package> findByType(@Param("type") PackageType type);

    List<Package> findByStatus(@Param("status") PackageStatus status);

    List<Package> findByFinalDeliveryDate(@Param("date") LocalDate finalDeliveryDate);

    @Query(nativeQuery = true, value="select * from Package where FINAL_DELIVERY_DATE between ISNULL(:from, FINAL_DELIVERY_DATE) and ISNULL(:to, FINAL_DELIVERY_DATE) AND (TYPE = :#{#type?.ordinal()} OR :type IS NULL) AND (STATUS = :#{#status?.ordinal()} OR :status IS NULL)")
    List<Package> findBetween(@Param("from") @DateTimeFormat(iso = ISO.DATE) LocalDate from,
                              @Param("to") @DateTimeFormat(iso = ISO.DATE) LocalDate to,
                              @Param("type") Optional<PackageType> type,
                              @Param("status") Optional<PackageStatus> status);
}
