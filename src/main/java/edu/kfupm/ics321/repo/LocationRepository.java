package edu.kfupm.ics321.repo;


import edu.kfupm.ics321.model.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {}
