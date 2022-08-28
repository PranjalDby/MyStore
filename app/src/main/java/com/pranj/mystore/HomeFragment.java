package com.pranj.mystore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private Button button;
    private EditText editText,email,phone,amount, date;
    String name="",Phone="",Amount="",Date="",Email="";
    ArrayList<Model>arrayList=new ArrayList<>();
    private int Flag=-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.button);
        editText=view.findViewById(R.id.edittext);
        email=view.findViewById(R.id.editTextTextEmailAddress);
        phone=view.findViewById(R.id.editTextPhone);
        amount=view.findViewById(R.id.editTextAmount);
        date=view.findViewById(R.id.editTextDate);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE || i==EditorInfo.IME_ACTION_NEXT)
                {
                    name=editText.getText().toString();
                }
                return false;
            }
        }); email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE || i==EditorInfo.IME_ACTION_NEXT)
                {
                    Email=email.getText().toString();
                }
                return false;
            }
        }); phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE || i==EditorInfo.IME_ACTION_NEXT)
                {
                    if(phone.getText().toString().trim().length()>10 || phone.getText().toString().trim().length()<10)
                    {
                        phone.setError("Invalid Phone");
                        Flag=1;
                    }
                    else {
                        Phone = phone.getText().toString();
                    }
                }
                return false;
            }
        }); amount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE || i==EditorInfo.IME_ACTION_NEXT)
                {
                    Amount=amount.getText().toString();
                }
                return false;
            }
        }); date.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i== EditorInfo.IME_ACTION_DONE || i==EditorInfo.IME_ACTION_NEXT)
                {
                    Date=date.getText().toString();
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model model;
                try {
                    model=new Model(name,Email,Phone,Amount,Date);
                }
                catch (Exception e)
                {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    model=new Model("erro","null","0","null","null");
                }
                if(Flag==1)
                {
                    Toast.makeText(view.getContext(), "Error", Toast.LENGTH_SHORT).show();
                    Flag=-1;
                }
                else
                {
                    if (model.getName()==""||model.getPhone()=="") {
                        Toast.makeText(getContext(), "Empty list Can't be Saved", Toast.LENGTH_SHORT).show();
                    }
                    DatabaseHandler databaseHandler = new DatabaseHandler(getContext());
                    boolean addone = databaseHandler.addone(model);
                    if (addone) {
                        Toast.makeText(getContext(), "Saved Successfully!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}