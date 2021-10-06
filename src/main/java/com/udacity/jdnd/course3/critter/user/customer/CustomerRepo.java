package com.udacity.jdnd.course3.critter.user.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Customer JPA repository
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
