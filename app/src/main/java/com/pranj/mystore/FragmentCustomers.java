package com.pranj.mystore;

import static android.service.controls.ControlsProviderService.TAG;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.Settings;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillValue;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FragmentCustomers extends Fragment {

    TextView txtname;
    Model model;
    View v;
    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_customers, container, false);
        txtname=v.findViewById(R.id.txtview5);
        txtname.setText("Version : " + applinfo().toString());
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.S)
    public String applinfo()
    {
//        String ss="";
//        Application application=new Application();
//        try{
//
//        }
//        catch (Exception e)
//        {
//            Log.d("Error", "applinfo: ");
//        }
//       return ss;
        int vcode=BuildConfig.VERSION_CODE;
        String version= String.valueOf(vcode);
        return version;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}