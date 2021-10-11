package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepo;
import com.udacity.jdnd.course3.critter.user.employee.Employee;
import com.udacity.jdnd.course3.critter.user.employee.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Updated by Brian Smith on 10/7/21.
 * Description: Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    PetRepo petRepo;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        List<Employee> employees = employeeRepo.findAllById(scheduleDTO.getEmployeeIds());
        List<Pet> pets = petRepo.findAllById(scheduleDTO.getPetIds());

        Schedule schedule = new Schedule(
                scheduleDTO.getDate(),
                employees,
                pets,
                scheduleDTO.getActivities());

        Schedule savedSchedule = scheduleService.save(schedule);

        return buildScheduleDTO(savedSchedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = scheduleService.findAllSchedules();

        return schedules.stream().map(this::buildScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<Schedule> schedules = scheduleService.findSchedulesByPetId(petId);

        return schedules.stream().map(this::buildScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<Schedule> schedules = scheduleService.findSchedulesByEmployeeId(employeeId);

        return schedules.stream().map(this::buildScheduleDTO).collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> schedules = scheduleService.findScheduleByCustomerId(customerId);

        return schedules.stream().map(this::buildScheduleDTO).collect(Collectors.toList());
    }

    private ScheduleDTO buildScheduleDTO(Schedule schedule) {
        return ScheduleDTO.builder()
                .id(schedule.getId())
                .employeeIds(schedule.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()))
                .petIds(schedule.getPets().stream().map(Pet::getId).collect(Collectors.toList()))
                .date(schedule.getDate())
                .activities(schedule.getActivities())
                .build();
    }
}
