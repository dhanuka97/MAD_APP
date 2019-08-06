package com.mad.mad_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Item> itemList = new ArrayList<>();

    public void getItemList(String type) {
        switch (type){
            case "covers":
                itemList.add(new Item("Cover1", "desc1", 500.00));
                itemList.add(new Item("Cover2", "desc2", 500.00));
                break;
            case "speakers":
                itemList.add(new Item("Speaker1", "desc1", 500.00));
                itemList.add(new Item("speaker2", "desc2", 500.00));
                break;
            default:
                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = this.getIntent();
        String category = i.getExtras().getString("category");
        // get items according to category
        getItemList(category);
        Log.d("category", category);

        ItemListAdapter adap = new ItemListAdapter(this,
                R.layout.list_item, itemList);
//
        ListView listView = (ListView) findViewById(R.id.myList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("item", Integer.toString(position));
                Item selectedItem = (Item)parent.getItemAtPosition(position);
                goToItemView(selectedItem);
            }
        });
        listView.setAdapter(adap);
    }

    public void goToItemView (@Nullable Item item) {
        Intent i = new Intent(this , ItemView.class);
        i.putExtra("itemName", item.getItemName());
        i.putExtra("itemDesc", item.getDescription());
        i.putExtra("itemPrice", item.getPrice());
        startActivity(i);
    }
}
