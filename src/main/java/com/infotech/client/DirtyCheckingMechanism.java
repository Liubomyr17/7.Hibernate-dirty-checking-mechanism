package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;
import org.hibernate.Session;

public class DirtyCheckingMechanism {

    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Employee employee = session.get(Employee.class, 2);
            if(employee != null){
                session.beginTransaction();
                employee.setSalary(70000.00);
                employee.setEmployeeName("Martin Bingel2");
                session.update(employee);
                session.getTransaction().commit();
                //employee.setEmployeeName("Martin Bingel2");
            }else{
                System.out.println("Employee doesn't exist with provided Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}


