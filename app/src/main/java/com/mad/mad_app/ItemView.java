package com.mad.mad_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ItemView extends AppCompatActivity {

    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Intent i = this.getIntent();
        final String itemName = i.getExtras().getString("itemName");
        final String itemDesc = i.getExtras().getString("itemDesc");
        final double itemPrice = i.getExtras().getDouble("itemPrice");

        TextView name = (TextView) findViewById(R.id.textView7);
        final TextView price = (TextView) findViewById(R.id.textView9);
        TextView desc = (TextView) findViewById(R.id.textdescription);

        name.setText(itemName);
        desc.setText(itemDesc);
        price.setText(Double.toString(itemPrice));

        cart = (Button) findViewById(R.id.button);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dItem dItem = new dItem(itemName,itemDesc, itemPrice);
                addToCart(dItem);
            }
        });
    }

    public void addToCart(dItem dItem){
        dCartItem dCartItem = new dCartItem(dItem,1);
        ShoppingCart.addToCart(dCartItem);
        Toast t = Toast.makeText(this, "dItem added successfully!", Toast.LENGTH_LONG);
        t.show();
        goToCategoryPage();
    }

    public void goToCategoryPage() {
        Intent i = new Intent(this, CategoryPage.class);
        startActivity(i);
    }
}
