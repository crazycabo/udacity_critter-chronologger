package com.udacity.jdnd.course3.critter.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import java.time.DayOfWeek;
import java.util.Set;

/**
 * Created by Brian Smith on 10/4/21.
 * Description: Employee entity
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee extends User {
    @ElementCollection
    @JoinTable(name="employee_skills")
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @JoinTable(name="employee_availability")
    private Set<DayOfWeek> daysAvailable;
}
