package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Schedule JPA repository
 */
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    List<Schedule> getAllByEmployeesContains(Employee employee);
    List<Schedule> getAllByPetsContains(Pet pet);
    List<Schedule> getAllByPetsIn(Collection<List<Pet>> pets);
}
