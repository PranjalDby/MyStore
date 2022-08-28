package com.pranj.mystore;

import android.content.Context;
import android.os.Handler;
import android.view.Display;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.LogRecord;

public class Fragmenthome extends ViewModel {
    private ArrayList<Model>items=new ArrayList<>();
    Fragmenthome(ArrayList<Model>itms)
    {
        this.items=itms;
    }
    private MutableLiveData<ArrayList<Model>>model;
    public LiveData<ArrayList<Model>>getuser(){
        if(model==null)
        {
            model=new MutableLiveData<ArrayList<Model>>();
            loadusers();
        }
        return model;
    }
    private void loadusers()
    {
        Handler handler=new Handler();
        handler.postDelayed(()->{
            Long seed=System.nanoTime();
            Collections.shuffle(items, new Random(seed));
            model.setValue(items);
        },5000);
    }
}
