package com.udacity.jdnd.course3.critter.user.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Brian Smith on 10/7/21.
 * Description: Employee service
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee findEmployeeById(Long id) {
        return employeeRepo.getOne(id);
    }

    public List<Employee> findEmployeesWithMatchingCriteria(Set<EmployeeSkill> skills, LocalDate date) {
        return employeeRepo
                .getAllByDaysAvailableContaining(date.getDayOfWeek()).stream()
                .filter(employee -> employee.getSkills().containsAll(skills))
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public void setEmployeeAvailabilityByEmployeeId(Set<DayOfWeek> daysAvailable, Long id) {
        Employee employee = employeeRepo.getOne(id);
        employee.setDaysAvailable(daysAvailable);

        employeeRepo.save(employee);
    }

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }
}
