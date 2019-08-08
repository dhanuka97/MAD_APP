package com.mad.mad_app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<dItem> dItemList = new ArrayList<>();

    public void getItemList(String type) {
        switch (type){
            case "covers":
                dItemList.add(new dItem("For -Samsung S8+", "Available in Metal", 2300.00));
                dItemList.add(new dItem("For -Samsung S8", "Available in Silicone", 1300.00));
                dItemList.add(new dItem("For -Samsung S6+", "Available in Leather", 1050.00));
                dItemList.add(new dItem("For  -Apple IPhones 8+", "Available in Waterproof", 3500.00));
                dItemList.add(new dItem("For Apple IPhones 7", "Available in Anti-knock", 2800.00));
                dItemList.add(new dItem("For Apple IPhones 6S", "Available in Dirt-resistant", 990.00));
                break;
            case "speaker":
                dItemList.add(new dItem("wireless wooden", "Mini wireless portable", 5600.00));
                dItemList.add(new dItem("SoundCore Portable", "Dual driver Built in", 4500.00));
                dItemList.add(new dItem("Huawei Swan Portable", "Hand free Louder", 4500.00));
                dItemList.add(new dItem("SoundCore Portable", "Dual driver Built in", 4500.00));

                break;
            case "charger":
                dItemList.add(new dItem("Charger Samsung S8+", "Available in Metal", 2300.00));
                dItemList.add(new dItem("Charger Samsung S8", "Available in Silicone", 1300.00));
                dItemList.add(new dItem("Charger Samsung S6+", "Available in Leather", 1050.00));
                break;

            case "memory" :
                dItemList.add(new dItem("Smasung memory 16GB", "Evo +", 1500.00));
                dItemList.add(new dItem("Smasung memory 32GB", "Evo +1", 3500.00));
                dItemList.add(new dItem("Smasung memory 128GB", "Evo +3", 2500.00));
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

        // get items according to category
        String category = i.getExtras().getString("category");
        getItemList(category);


        Log.i("category", category);

        dItemListAdapter adap = new dItemListAdapter(this,
                R.layout.list_item, dItemList);
//
        ListView listView = (ListView) findViewById(R.id.myList);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("item", Integer.toString(position));
                dItem selectedDItem = (dItem)parent.getItemAtPosition(position);
                goToItemView(selectedDItem);






            }
        });
        listView.setAdapter(adap);
    }

    public void goToItemView (@Nullable dItem dItem) {
        Intent i = new Intent(this , ItemView.class);
        i.putExtra("itemName", dItem.getItemName());
        i.putExtra("itemDesc", dItem.getDescription());
        i.putExtra("itemPrice", dItem.getPrice());
        startActivity(i);
    }
}
