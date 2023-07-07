package com.example.recyclerview_contact_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Contact extends AppCompatActivity {
    ImageView back,add;
    EditText name1,surname1,number1;
    My_Database my_database=new My_Database(Add_Contact.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        back=findViewById(R.id.back);
        add=findViewById(R.id.add);
        name1=findViewById(R.id.name1);
        surname1=findViewById(R.id.surname1);
        number1=findViewById(R.id.number1);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Add_Contact.this,MainActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String n1=name1.getText().toString();
             String n2=surname1.getText().toString();
             String n3=number1.getText().toString();
            my_database.addContacts(""+n1,""+n2,""+n3);
                Log.d("AAA", "onClick: Add Data"+n1);

             Intent intent=new Intent(Add_Contact.this,MainActivity.class);
             startActivity(intent);
            }
        });
    }
}