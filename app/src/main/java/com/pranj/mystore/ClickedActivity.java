package com.pranj.mystore;

import static com.pranj.mystore.R.drawable.ic_baseline_check_circle_24;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ClickedActivity extends AppCompatActivity {
    public static int v=0;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String email=intent.getStringExtra("Email");
        String phone=intent.getStringExtra("Phone");
        TextView txx1=(TextView)findViewById(R.id.textView);
        txx1.setText(name);
        TextView txt2=(TextView) findViewById(R.id.textView2);
        txt2.setText(email);
        TextView phones=(TextView)findViewById(R.id.phonenumber);
        phones.setText(phone);
        Button button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            Model model;
            @Override
            public void onClick(View view) {
                model=new Model(name,"","","","");
                DatabaseHandler db=new DatabaseHandler(ClickedActivity.this);
                if (db.datadelete(model))
                {
                    Toast.makeText(ClickedActivity.this, "Succesfull Deleted", Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(ClickedActivity.this,MainActivity.class);
                    startActivity(intent1);
                }
            }
        });
    }
}
