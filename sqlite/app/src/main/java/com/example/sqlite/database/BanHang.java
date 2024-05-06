package com.example.sqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlite.model.Category;
import com.example.sqlite.model.Item;

import java.util.ArrayList;
import java.util.List;

public class BanHang extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QLBanHang.db";
    private static int DATABASE_VERSION = 1;
    public BanHang(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tao bang
        String sql = "create table categories(" +
                "id integer primary key autoincrement,"+
                "name text)";
        db.execSQL(sql);

        sql = "create table items(" +
                "id integer primary key autoincrement,"+
                "name text,"+
                "cid integer,"+
                "price real,"+
                "dateUpdate text,"+
                "foreign key (cid) references categories(id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // tat cac cac lenh
    //cach1
    public void insertCate(Category c){
        String sql = "insert into categories(name) values (?)";
        String[] agrs = {c.getName()};
        SQLiteDatabase st = getWritableDatabase();
        st.execSQL(sql,agrs);
    }
    //cach2
    public void insertCate2(Category c){
        ContentValues v = new ContentValues();
        v.put("name",c.getName());
        SQLiteDatabase st = getWritableDatabase();
        st.insert("categories",null,v);
    }

    //insert item
    public void insertItem(Item i){
        ContentValues v = new ContentValues();
        v.put("name",i.getName());
        v.put("price",i.getPrice());
        v.put("cid", i.getCategory().getId());
        v.put("daateUpdate",i.getDateUpdate());

        SQLiteDatabase st = getWritableDatabase();
        st.insert("items",null,v);

    }

    //lay ra
    public List<Category> getCates(){
        List<Category> ls = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("categories",null, null, null, null, null,null);
        while(rs != null && rs.moveToNext()){
            ls.add(new Category(rs.getInt(0), rs.getString(1)));
        }
        return ls;
    }

    public List<Item> getItems(){
        List<Item> ls = new ArrayList<>();
        String sql = "select i.id, i.name, i.price, i.dateUpdate, c.id as cid, c.name from categories c inner join items i on(c.id=i.cid)";
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery(sql, null);
        while(rs != null && rs.moveToNext()){
            ls.add(new Item(rs.getInt(0), rs.getString(1), rs.getDouble(2), rs.getString(3), new Category(rs.getInt(4), rs.getString(5))));
        }
        return ls;
    }
    public List<Item> getItemsByCid(int cid){
        List<Item> ls = new ArrayList<>();
        String sql = "select i.id, i.name, i.price, i.dateUpdate, c.id as cid, c.name from categories c inner join items i on(c.id=i.cid) where t.cid = ?";
        String[] agrs = {Integer.toString(cid)};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery(sql, null);
        while(rs != null && rs.moveToNext()){
            ls.add(new Item(rs.getInt(0), rs.getString(1), rs.getDouble(2), rs.getString(3), new Category(rs.getInt(4), rs.getString(5))));
        }
        return ls;
    }
}
