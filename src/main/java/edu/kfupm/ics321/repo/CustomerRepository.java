package edu.kfupm.ics321.repo;

import edu.kfupm.ics321.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
