package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * Created by Brian Smith on 10/4/21.
 * Description: Pet entity
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private PetType type;

    @Nationalized
    private String name;

    private LocalDate birthDate;

    @Column
    private String notes;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    public Pet(PetType type, String name, LocalDate birthDate, String notes) {
        this.type = type;
        this.name = name;
        this.birthDate = birthDate;
        this.notes = notes;
    }
}
