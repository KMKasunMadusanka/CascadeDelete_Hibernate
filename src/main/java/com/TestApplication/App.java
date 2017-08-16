package com.TestApplication;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by kmkmadusanka on 8/15/2017.
 */
public class App {

    public static void  main(String [] args){
       //creating object from customerdetails

        customerdetails cd = new customerdetails();

        cd.setCustomerId("101");
        cd.setCustomerName("Jhone");
        cd.setAddress("America");
        cd.setIncomeMethod("freelancer");


        Configuration cnf = new Configuration().configure().addAnnotatedClass(customerdetails.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cnf.getProperties()).buildServiceRegistry();

        SessionFactory scnFac = cnf.buildSessionFactory(reg);
        Session session = scnFac.openSession();

        
        Transaction tr = session.beginTransaction();
        
        session.save(cd);

        tr.commit();

    }


}
