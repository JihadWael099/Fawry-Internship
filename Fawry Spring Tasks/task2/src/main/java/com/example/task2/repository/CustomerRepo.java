package com.example.task2.repository;


import com.example.task2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Integer>{


    List<Customer> findByName(String name);

    @Query("SELECT c FROM Customer c WHERE c.department = :departmentName")
    List<Customer> findByDepartmentName(@Param("departmentName") String departmentName);
    Page<Customer> findByNameContaining(String name, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
}
