package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.PackageStore;
import edu.kfupm.ics321.model.PackageStoreId;
import edu.kfupm.ics321.projection.PackageStoreEager;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PackageStoreEager.class)
public interface PackageStoreRepository extends PagingAndSortingRepository<PackageStore, PackageStoreId> {
}
