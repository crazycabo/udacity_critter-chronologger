package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.PetRepo;
import com.udacity.jdnd.course3.critter.user.customer.Customer;
import com.udacity.jdnd.course3.critter.user.customer.CustomerRepo;
import com.udacity.jdnd.course3.critter.user.employee.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Brian Smith on 10/7/21.
 * Description: Schedule service
 */
@Service
@Transactional
public class ScheduleService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    PetRepo petRepo;

    @Autowired
    ScheduleRepo scheduleRepo;

    public List<Schedule> findAllSchedules() {
        return scheduleRepo.findAll();
    }

    public List<Schedule> findScheduleByCustomerId(Long id) {
        Customer owner = customerRepo.getOne(id);

        return scheduleRepo.getAllByPetsIn(owner.getPets());
    }

    public List<Schedule> findSchedulesByEmployeeId(Long id) {
        return scheduleRepo.getAllByEmployeesContains(employeeRepo.getOne(id));
    }

    public List<Schedule> findSchedulesByPetId(Long id) {
        return scheduleRepo.getAllByPetsContains(petRepo.getOne(id));
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }
}
