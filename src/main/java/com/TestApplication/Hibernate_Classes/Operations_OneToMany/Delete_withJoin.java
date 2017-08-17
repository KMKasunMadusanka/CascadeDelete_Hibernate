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
public class Delete_withJoin {

    public static void  main(String [] args){

        //===============Set Data to one to many relationship=============

        Student st =  new Student();
        University unv =  new University();

        st.setId(6);
        st.setName("kkkkkkk");
        st.setCGPA(2.0);
        st.setAddress("yyyyyyy");



        unv.setName("uuu");
        unv.setUniId(55);
        unv.setRating(77);
        unv.getStd().add(st);

        st.setUnv(unv);

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
        session.save(st);
        session.save(unv);


        //Enb the transaction
        session.getTransaction().commit();


    }


}
