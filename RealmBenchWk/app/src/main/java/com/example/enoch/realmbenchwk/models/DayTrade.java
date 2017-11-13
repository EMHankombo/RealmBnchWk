package com.example.enoch.realmbenchwk.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class DayTrade extends RealmObject {
    //Realm doesnt accept list so use RealmList
    RealmList<Customer> customers;

    public DayTrade() {
    }

    public DayTrade(RealmList<Customer> customers) {
        this.customers = customers;
    }

    public RealmList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(RealmList<Customer> customers) {
        this.customers = customers;
    }
}
