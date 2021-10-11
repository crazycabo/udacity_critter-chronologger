package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Pet JPA repository
 */
public interface PetRepo extends JpaRepository<Pet, Long> {
}
