package com.example.quanlichitieu.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlichitieu.model.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Song.db";

    private static int DATABASE_VERSION = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static final String CREATE_TABLE_BAI_HAT= "create table BaiHat("+
            "id integer primary key autoincrement,"+
            "ten text not null, " +
            "caSiHat text references CaSi(ten), " +
            "album text, " +
            "theLoai text," +
            "yeuThich int)";

    static final String CREATE_TABLE_CA_SI="create table CaSi("+
            "id integer primary key autoincrement,"+
            "ten text not null, " +
            "moTa text)";

    static final String INSERT_BAI_HAT="insert into BaiHat(ten, caSiHat, album, theLoai, yeuThich) values" +
            "('Em cua ngay hom qua','Son Tung MTP', 'O giua cuoc doi', 'Pop', 1)," +
            "('Lan cuoi','Ngot', 'O giua cuoc doi', 'Pop', 1)," +
            "('Anh nha o dau the','B Ray', 'Cho 1 tinh yeu', 'Blues', 0)," +
            "('Co hen voi thanh xuan','Hoang Dung', 'Cay lang-gio ngung', 'Country', 0)," +
            "('Chuyen doi ta','Da LAB', 'Cho 1 tinh yeu', 'Pop', 1)" ;
    static final String INSERT_CA_SI="insert into CaSi(ten, moTa) values" +
            "('Son Tung MTP', 'Bai hat nhe nhang, hay')," +
            "('Ngot', 'Bai hat ve tinh yeu tan vo')," +
            "('B Ray', 'Bai hat ve tinh yeu doi lua, hen ho')," +
            "('DaLAB', 'Bai hat ve tinh yeu ')," +
            "('Hoang Dung', 'Nhac du duong, hay')";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CA_SI);
        db.execSQL(CREATE_TABLE_BAI_HAT);

        db.execSQL(INSERT_BAI_HAT);
        db.execSQL(INSERT_CA_SI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
    //get all order by date des


    public List<BaiHat> getAll() {
        List<BaiHat> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor rs = sqLiteDatabase.query("BaiHat",
                null, null, null,
                null, null, null);
        while ((rs != null) && (rs.moveToNext())) {
            int id= rs.getInt(0);
            String ten = rs.getString(1);
            String casi = rs.getString(2);
            String album = rs.getString(3);
            String theloai = rs.getString(4);
            int yt = rs.getInt(5);
            list.add(new BaiHat(id,ten,casi,album,theloai,yt));
        }
        return list;
    }

    //add

    public long addBaiHat(BaiHat i){
        ContentValues values = new ContentValues();
        values.put("ten", i.getTen());
        values.put("caSiHat", i.getCaSiHat());
        values.put("album", i.getAlbum());
        values.put("theLoai", i.getTheLoai());
        values.put("yeuThich", i.getYeuThich());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("BaiHat",null, values);
    }



    public int updateBaiHat(BaiHat i) {
        ContentValues values = new ContentValues();
        values.put("ten", i.getTen());
        values.put("album", i.getAlbum());
        values.put("caSiHat", i.getCaSiHat());
        values.put("theLoai", i.getTheLoai());
        values.put("yeuThich", i.getYeuThich());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause = "id = ?";
        String[] whereArgs = {Integer.toString(i.getId())};
        return sqLiteDatabase.update("BaiHat",
                values, whereClause, whereArgs);

    }
    public int deleteBaiHat(int id) {
        String whereClause = "id = ?";
        String[] whereArgs = {Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("BaiHat",
                whereClause, whereArgs);

    }
//    public List<BaiHat> getByten(String key){
//        List<BaiHat> list=new ArrayList<>();
//        String whereClause="ten like ?";
//        String[] whereArgs={"%"+key+"%"};
//        SQLiteDatabase st=getReadableDatabase();
//        Cursor rs=st.query( "BaiHats", null,whereClause, whereArgs,  null,
//                null,  null);
//        while(rs!=null && rs.moveToNext()){
//            int id=rs.getInt( 0);
//            String ten=rs.getString(  1);
//            String c=rs.getString(  2);
//            String p=rs.getString( 3);
//            String d=rs.getString( 4);
//            list.add(new BaiHat(id,ten,c,p,d));
//        }
//        return list;
//    }
//    public List<BaiHat> searchByten(String key){
//        List<BaiHat> list=new ArrayList<>();
//        String whereClause="ten like ?";
//        String[] whereArgs={"%"+key+"%"};
//        SQLiteDatabase st=getReadableDatabase();
//        Cursor rs=st.query(  "BaiHats", null,whereClause, whereArgs,  null,
//         null, null);
//        while(rs!=null && rs.moveToNext()){
//            int id=rs.getInt(0);
//            String ten=rs.getString(  1);
//            String c=rs.getString( 2);
//            String p=rs.getString( 3);
//            String d = rs.getString(4);
//            list.add(new BaiHat(id,ten,c,p,d));
//
//        }
//        return list;
//    }
//    public List<BaiHat> searchByAlbum(String album){
//        List<BaiHat> list=new ArrayList<>();
//        String whereClause="album like ?";
//        String[] whereArgs={album};
//        SQLiteDatabase st=getReadableDatabase();
//        Cursor rs=st.query(  "BaiHats",  null, whereClause,whereArgs, null,
//                 null,  null);
//        while(rs!=null && rs.moveToNext()){
//            int id=rs.getInt(0);
//            String ten=rs.getString(  1);
//            String c=rs.getString(  2);
//            String p=rs.getString( 3);
//            String date= rs.getString(  4);
//            list.add(new BaiHat(id,ten,c,p,date));
//        }
//        return list;
//    }
//    public List<BaiHat> searchByDateFromTO(String from,String to){
//        List<BaiHat> list=new ArrayList<>();
//        String whereClause="date BETWEEN ? AND ?";
//        String[] whereArgs={from.trim(),to.trim()};
//        SQLiteDatabase st=getReadableDatabase();
//        Cursor rs=st.query(  "BaiHats",  null, whereClause, whereArgs,  null,
//                null,  null);
//        while(rs!=null && rs.moveToNext()){
//            int id=rs.getInt(0);
//            String ten=rs.getString(  1);
//            String c=rs.getString(  2);
//            String p=rs.getString(  3);
//            String date= rs.getString(  4);
//            list.add(new BaiHat(id,ten,c,p,date));
//        }
//        return list;
//    }
}
