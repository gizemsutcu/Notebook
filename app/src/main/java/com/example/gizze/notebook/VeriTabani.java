package com.example.gizze.notebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VeriTabani extends SQLiteOpenHelper  {
    private static final String DATABASE_NAME = "notlarim";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLO_NOTLAR = "notlar";
    private static final String ROW_TITLE = "not_basligi";
    private static final String ROW_CONTENT = "not_icerigi";

    public VeriTabani(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLO_NOTLAR + "("
                + ROW_TITLE + " TEXT NOT NULL , "
                + ROW_CONTENT + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLO_NOTLAR);
        onCreate(db);
    }

    public void VeriEkle(String not_basligi, String not_icerigi){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(ROW_TITLE, not_basligi);
            cv.put(ROW_CONTENT, not_icerigi);
            db.insert(TABLO_NOTLAR, null,cv);
        }catch (Exception e){
        }
        db.close();
    }

    public List<String> VeriListele(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {ROW_TITLE,ROW_CONTENT};
            Cursor cursor = db.query(TABLO_NOTLAR, stunlar,null,null,null,null,null);
            while (cursor.moveToNext()){
                veriler.add(cursor.getString(0)
                        + " - "
                        + cursor.getString(1));
            }
        }catch (Exception e){
        }
        db.close();
        return veriler;
    }
}
