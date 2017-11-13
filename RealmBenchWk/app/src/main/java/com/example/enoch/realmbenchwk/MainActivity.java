package com.example.enoch.realmbenchwk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.enoch.realmbenchwk.adapter.CustomerAdapter;
import com.example.enoch.realmbenchwk.models.Customer;
import com.example.enoch.realmbenchwk.models.DayTrade;
import com.example.enoch.realmbenchwk.models.OrderRealm;
import com.example.enoch.realmbenchwk.models.Shop;
import com.example.enoch.realmbenchwk.realmController.RealmController;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity {

    Realm realm;
    RealmController realmController;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        realmController = new RealmController(realm);

        demoData();
        initialiseRecyclerView();
    }


    public void demoData(){
        //empties the database at each run
        //realmController.deleteDatabase();

        //nested initialisation of dummy data
        //changed ordername from int to String in OrderRealm
        DayTrade dayTrade1 = new DayTrade(new RealmList<>(
                new Customer(new Shop("ShopName1","ShopType1"),"Bob Smith","12345678",new RealmList<>(
                        //randomize the UUID which needs to be unique
                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),125,"Order 1")
                ))));

        DayTrade dayTrade2 = new DayTrade(new RealmList<>(
                new Customer(new Shop("ShopName2","ShopType2"),"Sam Turner","465900123",new RealmList<>(
                        //randomize the UUID which needs to be unique
                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),10,"Order 2")
                ))));

        DayTrade dayTrade3 = new DayTrade(new RealmList<>(
                new Customer(new Shop("ShopName3","ShopType3"),"Ray Lewis","0789234905",new RealmList<>(
                        //randomize the UUID which needs to be unique
                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),17,"Order 3")
                ))));

        DayTrade dayTrade4 = new DayTrade(new RealmList<>(
                new Customer(new Shop("ShopName4","ShopType4"),"Josh Smith","623700521",new RealmList<>(
                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),6,"Order 4")
                ))));


        DayTrade dayTrade5 = new DayTrade(new RealmList<>(
                new Customer(new Shop("ShopName5","ShopType5"),"Peter Parker","678998212",new RealmList<>(
                        //randomize the UUID which needs to be unique
                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),200,"Order 5")
                ))));

        DayTrade dayTrade6 = new DayTrade(new RealmList<>(
                new Customer(new Shop("Shop Name1","Shop Type1"),"Bruce Wayne","56124553021",new RealmList<>(
                        //randomize the UUID which needs to be unique

                        new OrderRealm((int)(Math.random()*Integer.MAX_VALUE),35,"Order 6")
                ))));
        realmController.saveDayTrade(dayTrade1);
        realmController.saveDayTrade(dayTrade2);
        realmController.saveDayTrade(dayTrade3);
        realmController.saveDayTrade(dayTrade4);
        realmController.saveDayTrade(dayTrade5);
        realmController.saveDayTrade(dayTrade6);


    }

    public void initialiseRecyclerView(){
        //Data source from realm
        ArrayList<DayTrade> dayTradeArrayList = realmController.getDayTrades();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomerAdapter(dayTradeArrayList,R.layout.row,getApplicationContext()));


    }
}
