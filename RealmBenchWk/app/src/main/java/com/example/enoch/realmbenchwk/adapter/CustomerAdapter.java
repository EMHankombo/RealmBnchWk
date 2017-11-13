package com.example.enoch.realmbenchwk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.enoch.realmbenchwk.R;
import com.example.enoch.realmbenchwk.models.DayTrade;

import java.util.ArrayList;

/**
 * Created by mainza1992 on 13/11/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyviewHolder> {

    ArrayList<DayTrade> dayTrades;
    int row;
    Context applicationContext;

    public CustomerAdapter(ArrayList<DayTrade> dayTrades, int row, Context applicationContext) {
        this.dayTrades = dayTrades;
        this.row = row;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(row,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {
        holder.customerName.setText(dayTrades.get(position).getCustomers().get(0).getmName());
        holder.customerNumber.setText(dayTrades.get(position).getCustomers().get(0).getmNumber());
        holder.shopName.setText(dayTrades.get(position).getCustomers().get(0).getShop().getShopName());
        holder.shopType.setText(dayTrades.get(position).getCustomers().get(0).getShop().getShopType());
        holder.orderId.setText("ID : " + Integer.toString(dayTrades.get(position).getCustomers().get(0).getOrderList().get(0).getUUID()));
        holder.orderNumber.setText(dayTrades.get(position).getCustomers().get(0).getOrderList().get(0).getOrderName());
        holder.orderValue.setText("£" +Integer.toString(dayTrades.get(position).getCustomers().get(0).getOrderList().get(0).getOrderValue()));





    }

    @Override
    public int getItemCount() {
        return dayTrades.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView customerName,customerNumber,shopName,shopType,orderId,orderNumber,orderValue;
        public MyviewHolder(View itemView) {
            super(itemView);

            customerName=(TextView)itemView.findViewById(R.id.customerName);
            customerNumber=(TextView)itemView.findViewById(R.id.customerNumber);
            shopName=(TextView) itemView.findViewById(R.id.shopName);
            shopType = (TextView)itemView.findViewById(R.id.shopType);
            orderId = (TextView)itemView.findViewById(R.id.orderId);
            orderNumber=(TextView)itemView.findViewById(R.id.orderNumber);
            orderValue = (TextView)itemView.findViewById(R.id.orderValue);
        }
    }
}
