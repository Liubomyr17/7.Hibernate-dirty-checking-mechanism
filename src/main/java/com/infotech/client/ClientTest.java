package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {

            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                createEmployee(session);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(session != null){
                    session.close();
                }
            }
        }

        private static void createEmployee(Session session) {
            session.beginTransaction();
            Integer id =(Integer)session.save(getEmployee());
            System.out.println("Employee is created  with Id::"+id);
            session.getTransaction().commit();
        }

        private static Employee getEmployee(){
            Employee employee= new Employee();
            employee.setEmployeeName("Martin Bingel");
            employee.setEmail("martin.cs2017@gmail.com");
            employee.setSalary(50000.00);
            employee.setDoj(new Date());
            return employee;
        }
    }