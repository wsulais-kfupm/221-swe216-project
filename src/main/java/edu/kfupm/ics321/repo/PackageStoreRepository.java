package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.PackageStore;
import edu.kfupm.ics321.model.PackageStoreId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PackageStoreRepository extends PagingAndSortingRepository<PackageStore, PackageStoreId> {
}
