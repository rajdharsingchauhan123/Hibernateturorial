package com.example.Hibernateturorial;

import javax.persistence.*;


@Entity
@Table(name = "employee_1")
public class Employee {

    public Employee() {

    }

    public Employee(String emp, Boss bossId) {
        super();
        this.emp = emp;
        this.boss = bossId;
    }

    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee")
    private String emp;

    @ManyToOne(targetEntity = Boss.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "boss_id", referencedColumnName = "bid")
    private Boss boss;

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

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", emp=" + emp + ", boss=" + boss + "]";
    }

}