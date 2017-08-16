package com.TestApplication.DB_Entity_Classes;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kmkmadusanka on 8/15/2017.
 */

@Entity
public class customerdetails {

	@Id
    private String customerId;
    private  String customerName;
    private  String address;
    private  String incomeMethod;

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "customerdetails{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", incomeMethod='" + incomeMethod + '\'' +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIncomeMethod() {
        return incomeMethod;
    }

    public void setIncomeMethod(String incomeMethod) {
        this.incomeMethod = incomeMethod;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
