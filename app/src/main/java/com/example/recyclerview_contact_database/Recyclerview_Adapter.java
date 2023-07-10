package com.example.recyclerview_contact_database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull MainactivityHolder holder, int position) {
        holder.t1.setText(contactslist.get(position).getName());
        holder.t2.setText(contactslist.get(position).getSurname());
        holder.t3.setText(contactslist.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return contactslist.size();
    }

    public static class MainactivityHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        public MainactivityHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.item_name);
            t2=itemView.findViewById(R.id.item_surname);
            t3=itemView.findViewById(R.id.item_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
