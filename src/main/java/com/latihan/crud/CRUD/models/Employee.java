package com.latihan.crud.CRUD.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee", schema = "public")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_employee_id_seq")
    @SequenceGenerator(name = "generator_employee_id_seq", sequenceName = "employee_id_seq", schema = "public", allocationSize = 1)
    private long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_address")
    private String employeeAddress;

}
