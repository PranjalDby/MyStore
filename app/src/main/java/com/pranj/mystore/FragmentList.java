package com.pranj.mystore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public  class FragmentList extends Fragment {
    RecyclerView recyclerView;
    Button button;
    View view;
    ArrayList<Model>item=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView=view.findViewById(R.id.recycleview);
        final Activity activity=this.getActivity();
        DatabaseHandler db=new DatabaseHandler(getContext());

        try {
            String s=db.getDatabaseName();
        }
        catch (Exception e)
        {
            System.out.println("Problem in Fragment");
        }
        Adapter adapter=new Adapter(getContext(),item);
        item=db.getall();
        adapter.setname(item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}