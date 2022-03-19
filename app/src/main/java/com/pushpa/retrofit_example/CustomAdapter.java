package com.pushpa.retrofit_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pushpa.retrofit_example.model.Contact;
import com.pushpa.retrofit_example.model.Example;

import java.util.ArrayList;
import java.util.List;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {

    private List<Contact> users;
    private Context context;
    public  CustomAdapter(Context context,List<Contact> userList)
    {
        this.context = context;
        this.users = userList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(users.get(position).getName().toString());
        holder.street.setText(users.get(position).getAddress());
        holder.email.setText(users.get(position).getEmail());
        holder.city.setText(users.get(position).getPhone().toString());
        holder.lang.setText(users.get(position).getGender());
        holder.lat.setText(users.get(position).getPhone().toString());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name, city,email,street,lat,lang,username,address;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            lat = itemView.findViewById(R.id.lat);
            lang = itemView.findViewById(R.id.lang);
            email = itemView.findViewById(R.id.email);
            street = itemView.findViewById(R.id.street);


        }
    }
}
