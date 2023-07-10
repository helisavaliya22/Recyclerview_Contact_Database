package com.example.recyclerview_contact_database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Contact extends AppCompatActivity {
    ImageView back,add,update_img;
    EditText name1,surname1,number1;
    My_Database my_database=new My_Database(Add_Contact.this);

    int id;
    String name,surname,number;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        back=findViewById(R.id.back);
        add=findViewById(R.id.add);
        name1=findViewById(R.id.name1);
        surname1=findViewById(R.id.surname1);
        number1=findViewById(R.id.number1);
        update_img = findViewById(R.id.update_img);

        id=getIntent().getIntExtra("id",0);
        name=getIntent().getStringExtra("name");
        surname=getIntent().getStringExtra("surname");
        number=getIntent().getStringExtra("number");
        update_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent,100);
            }
        });
        if(getIntent().getExtras()!=null)
        {
            name1.setText(""+name);
            surname1.setText(""+surname);
            number1.setText(""+number);
        }

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


                if(getIntent().getExtras()!=null)
                {
                    String n1=name1.getText().toString();
                    String n2=surname1.getText().toString();
                    String n3=number1.getText().toString();
                    my_database.updateContact(id,n1,n2,n3);
                }
                else {
                    String n1=name1.getText().toString();
                    String n2=surname1.getText().toString();
                    String n3=number1.getText().toString();
                    my_database.addContacts(""+n1,""+n2,""+n3,imageUri);
                }
             Intent intent=new Intent(Add_Contact.this,MainActivity.class);
             startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == 100 && data != null) {
                imageUri = data.getData();
                Log.d("TTT", "onActivityResult: ImgUri="+imageUri);
                update_img.setImageURI(imageUri);
            }
        }


    }
}