package com.spring.Repository;

/**
 * Created by Brian on 4/25/2017.
 */
import java.util.List;

import com.spring.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}