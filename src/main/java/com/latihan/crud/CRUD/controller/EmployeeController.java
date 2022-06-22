package com.latihan.crud.CRUD.controller;

import com.latihan.crud.CRUD.dtos.EmployeeDTO;
import com.latihan.crud.CRUD.models.Employee;
import com.latihan.crud.CRUD.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    ModelMapper modelMapper = new ModelMapper();

    private Employee convertEmployeeToEntity(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeDTO, Employee.class);
    }

    private EmployeeDTO convertEmployeeToDTO(Employee employee){
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    //API Insert
    @PostMapping("/employee/create")
    public Map<String, Object> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        Map<String, Object> mapResult = new HashMap<>();

        Employee employee = convertEmployeeToEntity(employeeDTO);
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());

        mapResult.put("message", "Create Success");
        mapResult.put("data", employeeRepository.save(employee));

        return mapResult;
    }

    //Api Read
    @GetMapping("/employee/getAll")
    public Map<String, Object> getAllEmployee(){
        Map<String, Object> mapResult = new HashMap<>();

        List<EmployeeDTO> listEmployee = new ArrayList<>();

        for (Employee employee: employeeRepository.findAll()){
            EmployeeDTO employeeDTO = convertEmployeeToDTO(employee);
            listEmployee.add(employeeDTO);
        }

        String message;
        if (listEmployee.isEmpty()){
            message = "Data is empty";
        }else {
            message = "Show all data";
        }

        mapResult.put("message", message);
        mapResult.put("data", listEmployee);
        mapResult.put("total", listEmployee.size());

        return mapResult;
    }

    //Api Update
    @PutMapping("/employee/update")
    public Map<String, Object> updateEmployee(
            @RequestParam(value = "employeeId") long emloyeeId,
            @RequestBody EmployeeDTO employeeDTO
    ){
        Map<String, Object> mapResult = new HashMap<>();

        Employee employee = employeeRepository.findById(emloyeeId).orElse(null);

        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());

        mapResult.put("message", "Update Success");
        mapResult.put("Data", employeeRepository.save(employee));

        return mapResult;
    }

    //Api Delete
    @DeleteMapping("/employee/delete/{employeeId}")
    public Map<String, Object> deleteEmployee(
            @PathVariable(value = "employeeId") long employeeId
    ){
        Map<String, Object> mapResult = new HashMap<>();

        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        employeeRepository.delete(employee);

        mapResult.put("message", "Delete Success");

        return mapResult;
    }

}
