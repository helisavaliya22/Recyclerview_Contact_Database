package com.example.recyclerview_contact_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_contact_database.Modal.Contacts;

import java.util.ArrayList;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.MainactivityHolder> {
    MainActivity mainActivity;
    ArrayList<Contacts> contactslist;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Contacts> contactslist) {
        this.mainActivity=mainActivity;
        this.contactslist=contactslist;
    }

    @NonNull
    @Override
    public MainactivityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_layout,parent,false);
        MainactivityHolder holder= new MainactivityHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainactivityHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(contactslist.get(position).getName());
        holder.t2.setText(contactslist.get(position).getSurname());
        holder.t3.setText(contactslist.get(position).getNumber());
        holder.contact_img.setImageURI(Uri.parse(contactslist.get(position).getImgUri()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(mainActivity,Add_Contact.class);
//                intent.putExtra("id",contactslist.get(holder.getAdapterPosition()).getId());
//                intent.putExtra("name",contactslist.get(position).getName());
//                intent.putExtra("surname",contactslist.get(position).getSurname());
//                intent.putExtra("number",contactslist.get(position).getNumber());
//                mainActivity.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                My_Database my_database=new My_Database(mainActivity);
//                my_database.deleteData(contactslist.get(position).getId());
//                contactslist.remove(position);
//                notifyDataSetChanged();
                return true;
            }
        });
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(mainActivity,holder.more);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.update)
                        {
                            Toast.makeText(mainActivity, "Updated" , Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(mainActivity,Add_Contact.class);
                            intent.putExtra("id",contactslist.get(holder.getAdapterPosition()).getId());
                            intent.putExtra("name",contactslist.get(position).getName());
                            intent.putExtra("surname",contactslist.get(position).getSurname());
                            intent.putExtra("number",contactslist.get(position).getNumber());
                            mainActivity.startActivity(intent);
                        }
                        if(item.getItemId()==R.id.delete)
                        {
                            My_Database my_database=new My_Database(mainActivity);
                            my_database.deleteData(contactslist.get(position).getId());
                            contactslist.remove(position);
                            notifyDataSetChanged();
                            Toast.makeText(mainActivity, "Delete" , Toast.LENGTH_LONG).show();
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }

    public static class MainactivityHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        ImageView contact_img;
        ImageButton more;
        public MainactivityHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.item_name);
            t2=itemView.findViewById(R.id.item_surname);
            t3=itemView.findViewById(R.id.item_number);
            more=itemView.findViewById(R.id.more);
            contact_img=itemView.findViewById(R.id.contact_img);
        }
    }
}
