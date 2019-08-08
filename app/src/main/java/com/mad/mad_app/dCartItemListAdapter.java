package com.mad.mad_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.Callable;

class dCartItemListAdapter extends ArrayAdapter<dCartItem> {
    private Context context;
    private int resource;
    private Callable deleteCallback;

    public dCartItemListAdapter(Context context, int resource, List<dCartItem> objects, Callable deleteCallback) {
        super(context, resource, objects);
        this.resource =resource;
        this.context = context;
        this.deleteCallback = deleteCallback;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        dItem dItem = getItem(position).getdItem();

        String name = dItem.getItemName();
        int quantity = getItem(position).getQuntity();
        double price = dItem.getPrice();
        double subTotal = price * quantity;

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView itemName = (TextView) convertView.findViewById(R.id.textView);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.textView3);
        TextView itemQuantity = (TextView) convertView.findViewById(R.id.textView4);
        TextView itemSubTotal = (TextView) convertView.findViewById(R.id.textView5);

        Button remove = (Button) convertView.findViewById(R.id.button2);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCartitem(getItem(position));
            }
        });

//
        itemName.setText(name);
        itemPrice.setText(Double.toString(price));
        itemQuantity.setText(Integer.toString(quantity));
        itemSubTotal.setText(Double.toString(subTotal));

        return convertView;
    }

    public void removeCartitem(dCartItem item) {
        ShoppingCart.removeFromCart(item);
        Toast t = Toast.makeText(this.context , "Successfully deleted!", Toast.LENGTH_LONG);
        t.show();

        try {
            this.deleteCallback.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
