package com.udacity.jdnd.course3.critter.user.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by Brian Smith on 10/6/21.
 * Description: Employee JPA repository
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> getAllByDaysAvailableContaining(DayOfWeek dayOfWeek);
}
