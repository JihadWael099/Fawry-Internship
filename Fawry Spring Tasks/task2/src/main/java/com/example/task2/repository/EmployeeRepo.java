package com.example.task2.repository;

import com.example.task2.dto.EmployeeNameSalarClose;
import com.example.task2.dto.FullNameDto;
import com.example.task2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<EmployeeNameSalarClose> findByName(String name);
    @Query("SELECT e.name AS name, e.salary AS salary FROM Employee e")
    List<EmployeeNameSalarClose> findAllEmployeeNamesAndSalaries();

    @Query("SELECT new com.example.task2.dto.FullNameDto(e.name, e.lastName) FROM Employee e")
    List<FullNameDto> findEmployeeFullNames();

}
