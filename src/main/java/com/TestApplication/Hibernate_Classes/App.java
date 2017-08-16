package com.TestApplication.Hibernate_Classes;

//import javax.transaction.Transaction;

import com.TestApplication.DB_Entity_Classes.customerdetails;


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

        SelectAllRecords s =  new SelectAllRecords();

        for (Object data : s.getAllRecordData("customerdetails",customerdetails.class)){
            System.out.println(data);
        }

    }


}
