package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Brian Smith on 10/4/21.
 * Description: Schedule entity
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name="schedule_employee",
            joinColumns = @JoinColumn(name="schedule_id"),
            inverseJoinColumns = @JoinColumn(name="employee_id"))
    private List<Employee> employees;

    @ManyToMany
    @JoinTable(
            name="schedule_pet",
            joinColumns = @JoinColumn(name="schedule_id"),
            inverseJoinColumns = @JoinColumn(name="pet_id"))
    private List<Pet> pets;

    private LocalDate date;

    @ElementCollection
    @JoinTable(name="schedule_activities")
    private Set<EmployeeSkill> activities;
}
