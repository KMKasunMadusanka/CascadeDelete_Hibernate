package com.TestApplication.Hibernate_Classes.Operations_OneToMany;

import com.TestApplication.DB_Entity_Classes.Student;
import com.TestApplication.DB_Entity_Classes.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created by kmkmadusanka on 8/17/2017.
 */
public class Insert_withJoin {

    public static void  main(String [] args){

        //===============Set Data to one to many relationship=============

        Student st1 =  new Student();
        Student st2 =  new Student();
        Student st3 =  new Student();

        University unv1 =  new University();
        University unv2 =  new University();

        //Student 1
        st1.setId(1);
        st1.setName("AAAAAAAA");
        st1.setCGPA(1.0);
        st1.setAddress("A123");

        //Student 2
        st2.setId(2);
        st2.setName("BBBBBBBB");
        st2.setCGPA(2.0);
        st2.setAddress("B123");

        //Student 3
        st3.setId(6);
        st3.setName("CCCCCCCC");
        st3.setCGPA(3.0);
        st3.setAddress("C123");

        //Uni 1
        unv1.setName("SLIIT");
        unv1.setUniId(100);
        unv1.setRating(10);

        //Uni2
        unv2.setName("NIBM");
        unv2.setUniId(200);
        unv2.setRating(20);

        //add student to university
        unv1.getStd().add(st1);
        unv1.getStd().add(st2);
        unv2.getStd().add(st3);

        //add Students for university
        st1.setUnv(unv1);
        st2.setUnv(unv1);
        st3.setUnv(unv2);

        //create object from configuration class
        Configuration cnf = new Configuration().configure().addAnnotatedClass(University.class).addAnnotatedClass(Student.class);

        //assign values to service registry
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cnf.getProperties()).buildServiceRegistry();

        //create session from session factory
        SessionFactory scnFac = cnf.buildSessionFactory(reg);
        Session session = scnFac.openSession();

        //create transaction in order to do the ATAM properties
        session.beginTransaction();

        //save the object in to database using ORM
        session.save(st1);
        session.save(unv1);

        session.save(st2);
        session.save(unv2);

        session.save(st3);



        //Enb the transaction
        session.getTransaction().commit();


    }


}
