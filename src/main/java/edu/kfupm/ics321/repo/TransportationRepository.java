package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.Transportation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransportationRepository extends PagingAndSortingRepository<Transportation, Long> {
}
