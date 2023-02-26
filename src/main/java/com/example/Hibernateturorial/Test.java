package com.example.Hibernateturorial;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Test {
//    private  static SessionFactory sessionFactory =null;
//
//    static {
//        try {
//            loadSessionFactory();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public static void  loadSessionFactory(){
//        Configuration configuration=new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        //configuration.addResource("Employee.hbm.xml");
//
//        // using annotated class
//        configuration.addAnnotatedClass(com.example.Hibernateturorial.Employee.class);
//
//        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
//
//    }
//    public static Session getSession() throws HibernateException {
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//        } catch (Exception e) {
//            System.err.println("Exception while opening a session");
//            e.printStackTrace();
//        }
//        return session;
//    }
//    public static void main(String[] args) {
//     //   HibernateDao.createEmp();// calling the create method in dao class
//        Session session=null;
//        Transaction transaction =null;
//        try{
//            session=getSession();
//            transaction =session.beginTransaction();
//
////            Employee user= new Employee("rajdhar","34");
//         //   session.save(user);
//
//            transaction.commit();
//        }
//        catch (Exception e){
//            if(transaction!=null)
//                transaction.rollback();
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//
//        }
//
//
//    }

    // all test method for dao create update and read delete

    public static void main(String[] args) {
        System.out.println("performing hibernate crud operations");
        System.out.println("creating employee records");
        HibernateDao.createEmp();

        System.out.println("Reading employee records");

        List<Employee> entries=HibernateDao.readEmp();
        if(entries!=null&entries.size()>0){
            for (Employee empObj:entries){
                System.out.println(empObj.toString());
            }
        }
        System.out.println("updating employee records");
        HibernateDao.updateEmp(5);
        System.out.println("updated records");

        List<Employee>updatedEntries=HibernateDao.readEmp();
        if(updatedEntries!=null & updatedEntries.size()>0){
            for (Employee empobj:updatedEntries){
                System.out.println(empobj.toString());
            }

            System.out.println("Deleting a Employee Record with id 2 ");
            HibernateDao.deleteRecord(2);
            List<Employee>entriesAfterDelete=HibernateDao.readEmp();
            if(entriesAfterDelete!=null & entriesAfterDelete.size()>0){
                for (Employee empobj:entriesAfterDelete){
                    System.out.println(empobj.toString());
                }
        }
            System.out.println("deleting all records");
            HibernateDao.deleteAll();

            HibernateDao.closeSessionFactory();

    }


}
