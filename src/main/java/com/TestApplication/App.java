package com.TestApplication;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by kmkmadusanka on 8/15/2017.
 */
public class App {

    public static void  main(String [] args){
       //creating object from customerdetails

        customerdetails cd = new customerdetails();

        cd.setCustomerId("100");
        cd.setCustomerName("Kasun");
        cd.setAddress("Colombo");
        cd.setIncomeMethod("job");


        Configuration cnf = new Configuration().configure().addAnnotatedClass(customerdetails.class);

        SessionFactory scnFac = cnf.buildSessionFactory();
        Session session = scnFac.openSession();

        
        Transaction tr = session.beginTransaction();
        
        session.save(cd);

    }


}
