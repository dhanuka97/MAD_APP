package com.mad.mad_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ShoppingCartPage extends AppCompatActivity {

    ArrayList<CartItem> cartItemList = new ArrayList<CartItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart_page);

        cartItemList = ShoppingCart.getCart();

        CartItemListAdapter adap = new CartItemListAdapter(this,
                R.layout.cart_item, ShoppingCart.getCart(), new Callable() {
            @Override
            public Object call() throws Exception {
                refreshPageAfterItemRemove();
                return null;
            }
        });
//
        ListView listView = (ListView) findViewById(R.id.myList);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("item", Integer.toString(position));
//                Item selectedItem = (Item)parent.getItemAtPosition(position);
//                goToItemView(selectedItem);
//            }
//        });
        listView.setAdapter(adap);

    }

    public void refreshPageAfterItemRemove () {
        this.recreate();
    }
}
