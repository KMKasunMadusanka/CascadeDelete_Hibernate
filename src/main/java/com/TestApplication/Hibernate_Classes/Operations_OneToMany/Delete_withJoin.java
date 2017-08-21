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
public class Delete_withJoin {

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
            //delete the object in to database using ORM
            SQLQuery quearyText1 = session.createSQLQuery("delete from student where unv_UniId=300");
            quearyText1.executeUpdate();
            SQLQuery quearyText2 = session.createSQLQuery("delete from university where UniId=300");
            quearyText2.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e);
        }


        //Enb the transaction
        session.getTransaction().commit();


    }


}
