package com.udacity.jdnd.course3.critter.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Employee JPA repository
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> getAllByDaysAvailableContaining(DayOfWeek dayOfWeek);
}
