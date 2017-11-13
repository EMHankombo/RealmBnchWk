package com.example.enoch.realmbenchwk.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class OrderRealm extends RealmObject {
    @PrimaryKey
    int UUID;

    int orderValue;
    String OrderName;

    public OrderRealm() {
    }

    public OrderRealm(int UUID, int orderValue, String orderName) {
        this.UUID = UUID;
        this.orderValue = orderValue;
        OrderName = orderName;
    }

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }
}
