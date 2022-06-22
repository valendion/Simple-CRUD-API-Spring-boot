package com.latihan.crud.CRUD.repositories;

import com.latihan.crud.CRUD.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
