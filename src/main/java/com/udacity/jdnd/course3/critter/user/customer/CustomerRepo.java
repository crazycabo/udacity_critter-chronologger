package com.udacity.jdnd.course3.critter.user.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Customer JPA repository
 */
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
