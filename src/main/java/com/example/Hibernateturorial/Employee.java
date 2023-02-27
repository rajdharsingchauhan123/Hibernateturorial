package com.example.Hibernateturorial;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "ename",length = 10)
    private String name;
    @Column(name = "age")
    private String age;

    public Employee() {
    }

    public Employee( String name, String age) {

        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
