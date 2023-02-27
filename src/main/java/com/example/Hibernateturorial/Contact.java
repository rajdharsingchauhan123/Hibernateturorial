package com.example.Hibernateturorial;

import javax.persistence.*;

@Entity
@Table(name = "emp_contact")
public class Contact {
    public Contact(String phone, String email, Employee employee) {
        super();
        this.phone = phone;
        this.email = email;
        this.employee = employee;
    }
    public Contact(){}

    @Id
    @Column(name = "contactid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "eid")
    private  Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
