package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian Smith on 10/4/21.
 * Description: Customer entity
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Customer extends User {
    @Column(name="phone_number")
    private String phoneNumber;

    @Column
    private String notes;

    @OneToMany(mappedBy = "customer", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Customer(String phoneNumber, String notes) {
        this.phoneNumber = phoneNumber;
        this.notes = notes;

        this.pets = new ArrayList<>();
    }
}
