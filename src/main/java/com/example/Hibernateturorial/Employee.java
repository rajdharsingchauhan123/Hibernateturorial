package com.example.Hibernateturorial;

import javax.persistence.Entity;
import java.io.Serializable;

//@Entity
public class Employee implements Serializable {
    private  Long id;
    private String name;
    private String age;

    public Employee() {
    }

    public Employee(Long id, String name, String age) {
        this.id = id;
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
