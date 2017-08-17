package com.TestApplication.Hibernate_Classes.Operations_OneToMany;

import com.TestApplication.DB_Entity_Classes.Student;
import com.TestApplication.DB_Entity_Classes.University;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by kmkmadusanka on 8/17/2017.
 */
public class Update_withJoin {

    public static void  main(String [] args){


        //create object from configuration class
        Configuration cnf = new Configuration().configure().addAnnotatedClass(University.class).addAnnotatedClass(Student.class);

        //assign values to service registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cnf.getProperties()).buildServiceRegistry();

        //create session from session factory
        SessionFactory scnFac = cnf.buildSessionFactory(reg);
        Session session = scnFac.openSession();

        //create transaction in order to do the ATAM properties
        session.beginTransaction();

        try {
            //update the table
            SQLQuery quearyText = session.createSQLQuery("Update University set UniId=10  where UniId=100");
            quearyText.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }





        //Enb the transaction
        session.getTransaction().commit();


    }


}
