package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    DBHelper DB;
    List<Information> informationList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        informationList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        DB = new DBHelper(this);
        Cursor res1 = DB.getdata();
        while(res1.moveToNext()){
            Information info  = new Information((String)res1.getString(0),(String)res1.getString(1),(String)res1.getString(2));
            informationList.add(info);
        }
        InformationAdaptor iv = new InformationAdaptor(MainActivity2.this,R.layout.information,informationList);
        listView.setAdapter(iv);

    }
}