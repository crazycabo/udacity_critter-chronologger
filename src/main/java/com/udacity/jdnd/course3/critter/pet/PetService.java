package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.customer.Customer;
import com.udacity.jdnd.course3.critter.user.customer.CustomerRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Brian Smith on 10/7/21.
 * Description: Pet service
 */
@Service
@Transactional
public class PetService {
    CustomerRepo customerRepo;
    PetRepo petRepo;

    public List<Pet> findAllPets() {
        return petRepo.findAll();
    }

    public Pet findPetById(Long petId) {
        return petRepo.getOne(petId);
    }

    public List<Pet> findPetsByCustomerId(Long id) {
        Customer customer = customerRepo.getOne(id);
        return customer.getPets();
    }

    public Pet save(Pet pet, Long ownerId) {
        Customer customer = customerRepo.getOne(ownerId);
        pet.setCustomer(customer);

        customer.getPets().add(pet);

        customerRepo.save(customer);
        petRepo.save(pet);

        return pet;
    }
}
