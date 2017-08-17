package com.TestApplication.Hibernate_Classes;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.TestApplication.DB_Entity_Classes.customerdetails;

import java.util.List;

/**
 * Created by kmkmadusanka on 8/16/2017.
 */
public class SelectAllRecords {

    public List getAllRecordData(String tableName ,Class operatorClass){


        //create object from configuration class
        Configuration cnf = new Configuration().configure().addAnnotatedClass(operatorClass);

        //assign values to service registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cnf.getProperties()).buildServiceRegistry();

        //create session from session factory
        SessionFactory scnFac = cnf.buildSessionFactory(reg);
        Session session = scnFac.openSession();

        //create transaction in order to do the ATAM properties
        Transaction tr = session.beginTransaction();

        //write SQL query and fetch data
        SQLQuery query = session.createSQLQuery("Select * from "+tableName);
        query.addEntity(operatorClass);
        List customers = query.list();

        //Enb the transaction
        tr.commit();

//        for(Object o : customers){
//            System.out.println(o);
//        }

        return  customers;
    }


}
