package com.example.enoch.realmbenchwk.models;

import io.realm.RealmObject;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class Shop extends RealmObject {

    String shopName;
    String ShopType;

    public Shop() {
    }


    public Shop(String shopName, String shopType) {
        this.shopName = shopName;
        ShopType = shopType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return ShopType;
    }

    public void setShopType(String shopType) {
        ShopType = shopType;
    }
}
