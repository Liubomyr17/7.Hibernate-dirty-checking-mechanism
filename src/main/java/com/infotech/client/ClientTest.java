package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction ();

            session.persist (getEmployee1 ());

            Integer id = (Integer)session.save (getEmployee2 ());
            System.out.println ("Employee is created with id::" + id);

            session.saveOrUpdate (getEmployee3 ());

            session.getTransaction ().commit ();

        }catch(HibernateException e){
        e.printStackTrace();
        }
        }

        private static Employee getEmployee3() {
        Employee employee = new Employee ();
        employee.setEmployeeName ("Martin Bingel");
        employee.setEmail ("martin.email@gmail.com");
        employee.setSalary (8000.00);
        employee.setDoj (new Date ());
        return employee;
        }
    private static Employee getEmployee1() {
        Employee employee = new Employee ();
        employee.setEmployeeName ("Frank Bingel");
        employee.setEmail ("frank.email@gmail.com");
        employee.setSalary (3000.00);
        employee.setDoj (new Date ());
        return employee;
    }
    private static Employee getEmployee2() {
        Employee employee = new Employee ();
        employee.setEmployeeName ("Sean Bingel");
        employee.setEmail ("sean.email@gmail.com");
        employee.setSalary (6000.00);
        employee.setDoj (new Date ());
        return employee;
    }

        }