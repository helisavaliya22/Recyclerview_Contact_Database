package com.example.recyclerview_contact_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerview_contact_database.Modal.Contacts;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     FloatingActionButton add;
     ArrayList<Contacts> contactslist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        add=findViewById(R.id.add);



        ShowData();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add_Contact.class);
                startActivity(intent);
            }
        });
        Recyclerview_Adapter adapter=new Recyclerview_Adapter(MainActivity.this,contactslist);
        recyclerView.setAdapter(adapter);

    }

    private void ShowData() {
        My_Database my_database=new My_Database(MainActivity.this);
        Cursor cursor=my_database.showdata();
        while (cursor.moveToNext())
        {
             int id=cursor.getInt(0);
             String name=cursor.getString(1);
             String surname=cursor.getString(2);
             String number=cursor.getString(3);
           Contacts contacts=new Contacts(id,name,surname,number);
           contactslist.add(contacts);
            Log.d("AAA", "ShowData: Create data"+contacts);

        }
    }


}