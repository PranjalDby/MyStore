package com.pranj.mystore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Model>items=new ArrayList<>();
    private Context context;
    public Adapter(Context context,ArrayList<Model>models)
    {
        this.items=models;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("ResourceType")
        View textView= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentlayout,parent,false);
        ViewHolder viewHolder=new ViewHolder(textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewt.setText(items.get(position).getName());
        holder.email.setText(items.get(position).getEmail());
        holder.phone.setText(items.get(position).getPhone());
        holder.amount.setText(items.get(position).getAmount());
        holder.date.setText(items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setname(ArrayList<Model>item)
    {
        this.items=item;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
       public TextView textViewt;
       public TextView email;
       public TextView phone;
       public  TextView amount;
       public TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewt = itemView.findViewById(R.id.textView1);
            this.email = itemView.findViewById(R.id.email);
            this.phone = itemView.findViewById(R.id.phone);
            this.amount = itemView.findViewById(R.id.amount);
            this.date =itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            int pos=this.getAdapterPosition();
            Model  model=items.get(pos);
            String name=model.getName();
            String email=model.getEmail();
            String phone=model.getPhone();
            Intent i=new Intent(context,ClickedActivity.class);
            i.putExtra("Name",name);
            i.putExtra("Email",email);
            i.putExtra("Phone",phone);
           context.startActivity(i);
        }
        public int adapterpos()
        {
            return this.getAdapterPosition();
        }
    }
}
