package com.example.Hibernateturorial;

import javax.persistence.*;


@Entity
@Table(name = "employee_1")
public class Employee {

    public Employee() {

    }

    public Employee(String emp) {
        this.emp = emp;
    }

    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee")
    private String emp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", emp=" + emp + "]";
    }
}