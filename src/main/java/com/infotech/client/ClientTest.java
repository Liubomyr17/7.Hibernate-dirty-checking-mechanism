package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Employee employee = getEmployee();
            session.beginTransaction ();

            // session.persist (employee);
            Integer id = (Integer)session.save (employee);
            System.out.println ("Employee is created with id::" + id);


            session.getTransaction ().commit ();

        }catch(Exception e){
        e.printStackTrace();
        }
        }

        private static Employee getEmployee() {
        Employee employee = new Employee ();
        employee.setEmployeeName ("James Bond");
        employee.setEmail ("email@gmail.com");
        employee.setSalary (7000.00);
        employee.setDoj (new Date ());
        return employee;
        }

        }