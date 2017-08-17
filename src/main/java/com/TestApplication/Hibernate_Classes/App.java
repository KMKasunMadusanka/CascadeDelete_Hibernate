package com.TestApplication.Hibernate_Classes;

//import javax.transaction.Transaction;

import com.TestApplication.DB_Entity_Classes.Computer;
import com.TestApplication.DB_Entity_Classes.Student;
import com.TestApplication.DB_Entity_Classes.University;
import com.TestApplication.DB_Entity_Classes.customerdetails;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import sun.security.x509.AttributeNameEnumeration;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kmkmadusanka on 8/15/2017.
 */
public class App {

    public static void  main(String [] args){

        //crete object array
        Object objArray[]= new Object[2];

        //creating object from customerdetails
        customerdetails cd = new customerdetails();

        //Enter the hardcoded values to object
        cd.setCustomerId("106");
        cd.setCustomerName("xxx");
        cd.setAddress("xxxxxxxx");
        cd.setIncomeMethod("xxxxxxxxxxxxx");


        //creating object from customerdetails
        customerdetails ff = new customerdetails();

        //Enter the hardcoded values to object
        ff.setCustomerId("107");
        ff.setCustomerName("yyy");
        ff.setAddress("yyyyyyyy");
        ff.setIncomeMethod("yyyyyyyyyyyyyy");

        //=================insert single record ======================
//        InsertSingleRecord is =  new InsertSingleRecord();
//        is.saveData(cd,customerdetails.class);

        //================insert multiple records====================
//        objArray[0]=cd;
//        objArray[1]=ff;
//
//        InsertMultipleRecords im =  new InsertMultipleRecords();
//        im.saveMultipleRecords(objArray,customerdetails.class);

        //=================== fetch data from db================

//        SelectAllRecords s =  new SelectAllRecords();
//
//        for (Object data : s.getAllRecordData("customerdetails",customerdetails.class)){
//            System.out.println(data);
//        }

        //===============Set Data to one to many relationship=============

        Student st =  new Student();
        University unv =  new University();
        Computer cmp = new Computer();


        List S_lis = new ArrayList();

        st.setId(5);
        st.setName("hhhhh");
        st.setCGPA(3.0);
        st.setAddress("bbbb");

       // S_lis.add(st);

        unv.setName("xxxxx");
        unv.setUniId(110);
        unv.setRating(6);
        unv.getStd().add(st);
        //unv.setStd(S_lis);

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

//        SQLQuery quearyText = session.createSQLQuery("delete from University  where UniId=111");
//        quearyText.executeUpdate();




        //Enb the transaction
        session.getTransaction().commit();


    }


}
