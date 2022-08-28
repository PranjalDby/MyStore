package com.pranj.mystore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "PHONE";
    public static final String AMOUNT = "AMOUNT";
    public static final String DATE = "DATE";
    public ArrayList<Model>list=new ArrayList<>();
    public DatabaseHandler(@Nullable Context context) {
        super(context, "Mydatabase.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String createtable= "CREATE TABLE  " + CUSTOMER_TABLE + " (" + NAME + " TEXT," + EMAIL + " TEXT," + PHONE + " TEXT," + AMOUNT + " TEXT," + DATE + " TEXT)";
        sqLiteDatabase.execSQL(createtable);
    }
    public ArrayList<Model>getall()
    {
        String getquery="SELECT * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(getquery,null);
        if(cursor.moveToFirst())
        {
            do {
                String name=cursor.getString(0);
                String email=cursor.getString(1);
                String phone=cursor.getString(2);
                String Amount=cursor.getString(3);
                String Date=cursor.getString(4);
                Model model=new Model(name,email,phone,Amount,Date);
                list.add(model);
            }while (cursor.moveToNext());
        }
        else
        {

        }
        cursor.close();
        db.close();
        return list;
    }
    public String onlyname(Model model)
    {
        String name="";
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT NAME FROM " + CUSTOMER_TABLE;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()) {
            do {
               name = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return name;
    }
    public  boolean addone(Model model)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,model.getName());
        cv.put(EMAIL,model.getEmail());
        cv.put(PHONE,model.getPhone());
        cv.put(AMOUNT,model.getAmount());
        cv.put(DATE,model.getDate());
        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if (insert==-1)
        {
            return false;
        }

        return true;
    }
    public boolean datadelete(Model model)
    {
        String getquery="DELETE * FROM " + CUSTOMER_TABLE;
        SQLiteDatabase db=this.getWritableDatabase();
        int delete = db.delete(CUSTOMER_TABLE, NAME + "= ?",new String[]{model.getName()});
        if (delete==-1)
        {
            return false;
        }
        return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
