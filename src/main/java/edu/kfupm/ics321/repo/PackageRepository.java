package edu.kfupm.ics321.repo;


import edu.kfupm.ics321.model.Package;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PackageRepository extends PagingAndSortingRepository<Package, Long> {}
