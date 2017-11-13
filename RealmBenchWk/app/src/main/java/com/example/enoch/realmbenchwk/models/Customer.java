package com.example.enoch.realmbenchwk.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class Customer extends RealmObject {

    //composition for Shop class
    Shop shop;
    String mName;
    String mNumber;
    //Realm doesnt accept list so use RealmList
    RealmList<OrderRealm> orderList;

    public Customer() {
    }

    public Customer(Shop shop, String mName, String mNumber, RealmList<OrderRealm> listOrder) {
        this.shop = shop;
        this.mName = mName;
        this.mNumber = mNumber;
        this.orderList = listOrder;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public RealmList<OrderRealm> getOrderList() {
        return orderList;
    }

    public void setListOrder(RealmList<OrderRealm> orderList) {
        this.orderList = orderList;
    }
}
