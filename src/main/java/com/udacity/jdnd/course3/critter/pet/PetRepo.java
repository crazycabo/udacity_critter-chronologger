package com.udacity.jdnd.course3.critter.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Pet JPA repository
 */
@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {
}
