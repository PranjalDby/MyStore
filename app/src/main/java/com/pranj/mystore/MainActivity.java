package com.pranj.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
   private long p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBarView navigationBarView=(BottomNavigationView)findViewById(R.id.navview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_notifications:
                        replaceFragment(new FragmentCustomers());
                        break;
                    case R.id.navigation_dashboard:
                        replaceFragment(new FragmentList());
                        break;
                    default:
                        replaceFragment(new HomeFragment());
                        break;
                }
                return true;
            }
        });
//        Fragmenthome fragmenthome=new ViewModelProvider(this).get(Fragmenthome.class);
//        fragmenthome.getuser();
    }
    HomeFragment homeFragment=new HomeFragment();
    ListFragment listFragment=new ListFragment();
    FragmentCustomers fragmentCustomers=new FragmentCustomers();
    private void replaceFragment( Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment1,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        replaceFragment(new HomeFragment());
    }

    @Override
    public void onBackPressed() {
        if (p+2000>System.currentTimeMillis())
        {
            super.onBackPressed();
            finish();
        }else
        {
            Toast.makeText(MainActivity.this, "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        }
        p=System.currentTimeMillis();
    }
}