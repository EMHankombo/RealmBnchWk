package com.example.enoch.realmbenchwk.realmController;

import com.example.enoch.realmbenchwk.models.DayTrade;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class RealmController {
    Realm realm;

    public RealmController(Realm realm) {
        this.realm = realm;
    }

    //save the data inside the daytrade model
    public void saveDayTrade(final DayTrade dayTrade) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(dayTrade);
            }
        });
    }

    public void deleteDatabase() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }


    //return All the daytrade data
    public ArrayList<DayTrade> getDayTrades() {
        ArrayList<DayTrade> dayTradeArrayList = new ArrayList<>();

        RealmResults<DayTrade> dayTradeRealmResults = realm.where(DayTrade.class).findAll();

        for(DayTrade dayTrade: dayTradeRealmResults) {
            dayTradeArrayList.add(dayTrade);
        }

        return dayTradeArrayList;
    }

}
