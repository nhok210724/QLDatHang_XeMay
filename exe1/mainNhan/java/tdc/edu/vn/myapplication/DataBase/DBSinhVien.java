package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.SinhVien;

public class DBSinhVien {
    DBHelper dbHelper;

    public DBSinhVien(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(SinhVien sinhVien)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masv",sinhVien.getMaSV());
        values.put("hoten",sinhVien.getTenSV());
        values.put("diachi",sinhVien.getDiaChi());
        db.insert("SinhVien",null,values);
    }

    public void Sua(SinhVien sinhVien)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masv",sinhVien.getMaSV());
        values.put("hoten",sinhVien.getTenSV());
        values.put("diachi",sinhVien.getDiaChi());
        db.update("SinhVien",values,"masv ='"+sinhVien.getMaSV() +"'",null);
    }


    public void Xoa(SinhVien sinhVien)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from SinhVien where masv= '"+sinhVien.getMaSV()+"'";
        db.execSQL(sql);

    }

    public ArrayList<SinhVien> LayDL()
    {
        ArrayList<SinhVien> data = new ArrayList<>();
        String sql="select * from SinhVien";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSV(cursor.getString(0));
                sinhVien.setTenSV(cursor.getString(1));
                sinhVien.setDiaChi(cursor.getString(2));
                data.add(sinhVien);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }


        return  data;
    }
}
