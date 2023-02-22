package com.example.Hibernateturorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee user =new Employee(42l,"raj","15");
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
}
