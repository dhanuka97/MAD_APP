package com.mad.mad_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class dItemListAdapter extends ArrayAdapter<dItem> {
    private Context context;
    private int resource;


    public dItemListAdapter(Context context, int resource, List<dItem> objects) {
        super(context, resource, objects);
        this.resource =resource;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getItemName();
        String dec = getItem(position).getDescription();
        double price = getItem(position).getPrice();


        dItem dItem = new dItem(dec,name,price);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView tname = (TextView) convertView.findViewById(R.id.textView);
        TextView tdec = (TextView) convertView.findViewById(R.id.textView2);
        TextView tprice = (TextView) convertView.findViewById(R.id.textView3);
//
        tname.setText(name);
        tdec.setText(dec);
        tprice.setText(Double.toString(price));

        return convertView;
    }
}
