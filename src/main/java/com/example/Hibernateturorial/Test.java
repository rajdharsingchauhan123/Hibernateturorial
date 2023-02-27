package com.example.Hibernateturorial;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {
//    public static void main(String[] args) {
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Employee user =new Employee("raj","15");
//        session.save(user);
//
//        session.getTransaction().commit();
//        session.close();
//    }

    private static SessionFactory sessionFactory = null;

    static {
        try {
            loadSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(com.example.Hibernateturorial.Employee.class);
        configuration.addAnnotatedClass(com.example.Hibernateturorial.Contact.class);
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        sessionFactory = configuration.buildSessionFactory(srvcReg);
    }

    public static Session getSession() throws HibernateException {

        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            System.err.println("Exception while opening a session ");
            e.printStackTrace();
        }

        return session;
    }

    public static void main(String[] args) {

        insertEmployeeWithContact();

//        deleteEmployeeWithContact();

    }

    public static void insertEmployeeWithContact() {

        Session session = null;
        Transaction txn = null;

        try {
            session = getSession();
            txn = session.beginTransaction();

            Employee emp = new Employee("Sundar", "5");

            Contact contact = new Contact("9898984848", "someemail@company.com", emp);

            session.save(contact);

            txn.commit();

        } catch (Exception e) {
            if (txn != null)
                txn.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

//    public static void deleteEmployeeWithContact() {
//
//        Session session = null;
//        Transaction txn = null;
//
//        try {
//            session = getSession();
//
//            txn = session.beginTransaction();
//
//            System.out.println("Deleting Employee");
//
//            Contact contact1 = (Contact) session.get(Contact.class, Long.parseLong("1"));
//
//            session.delete(contact1);
//
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null)
//                txn.rollback();
////            e.printStackTrace();
////        } finally {
//            session.close();
//        }
    }

//}

