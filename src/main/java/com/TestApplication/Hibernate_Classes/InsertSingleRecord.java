package com.TestApplication.Hibernate_Classes;

import com.TestApplication.DB_Entity_Classes.customerdetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by kmkmadusanka on 8/16/2017.
 */
public class InsertSingleRecord {

//save single object inside mysql database table
    public void saveData(Object object, Class operatorClass){

        //create object from configuration class
        Configuration cnf = new Configuration().configure().addAnnotatedClass(operatorClass);

        //assign values to service registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cnf.getProperties()).buildServiceRegistry();

        //create session from session factory
        SessionFactory scnFac = cnf.buildSessionFactory(reg);
        Session session = scnFac.openSession();

        //create transaction in order to do the ATAM properties
        Transaction tr = session.beginTransaction();

        //save the object in to database using ORM
        session.save(object);

        //Enb the transaction
        tr.commit();

    }




}
