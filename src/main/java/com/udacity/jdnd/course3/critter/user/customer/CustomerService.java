package com.udacity.jdnd.course3.critter.user.customer;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Brian Smith on 10/7/21.
 * Description: Customer service
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    PetRepo petRepo;

    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer findCustomerByPetId(Long petId) {
        Pet pet = petRepo.getOne(petId);

        return pet.getCustomer();
    }

    public Customer save(Customer customer, List<Long> petIds) {
        List<Pet> pets = petIds.stream().map(petId -> petRepo.getOne(petId)).collect(toList());

        if (pets.size() > 0) {
            customer.setPets(pets);
        }

        return customerRepo.save(customer);
    }
}
