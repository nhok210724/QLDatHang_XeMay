package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;
import tdc.edu.vn.quanly_dathang_xemay.model.Xe;

public class DBTenXe {
    //New Properties
    DBHelper dbHelper;
    static public final String sql = "Create Table " + DBHelper.TABLE_TENXE
            + "(" + DBHelper.COL_MAXE + " text PRIMARY KEY,"
            + DBHelper.COL_TENXE + " text,"
            + DBHelper.COL_DUNGTICH + " Int,"
            + DBHelper.COL_SOLUONGXE + " int,"
            + DBHelper.COL_IMG_TENXE + " text, "
            + DBHelper.COL_MALOAI + " text, "
            + "CONSTRAINT fk_TenXe_MaLoai" +
            "   FOREIGN KEY (" + DBHelper.COL_MALOAI + ")" +
            "   REFERENCES " + DBHelper.TABLE_CTYXE + " (" + DBHelper.COL_MALOAI + ")" + ")";
    //Cau Truy Van:
    Cursor cursor;


    public DBTenXe(Context context) {

        dbHelper = new DBHelper(context);

    }

    public void Xoa(Xe xe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "Delete from " + DBHelper.TABLE_TENXE + " Where " + DBHelper.COL_MAXE + " = '" + xe.getMaLoai() + "'";
        database.execSQL(sql);
    }

    public void Sua(Xe xe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MAXE, xe.getMaXe());
        values.put(DBHelper.COL_TENXE, xe.getTenXe());
        values.put(DBHelper.COL_DUNGTICH, xe.getDungTich());
        values.put(DBHelper.COL_SOLUONGXE, xe.getSoLuong());
        values.put(DBHelper.COL_IMG_TENXE, xe.getImage());
        values.put(DBHelper.COL_MALOAI, xe.getMaLoai());
        database.update(DBHelper.TABLE_TENXE, values, DBHelper.COL_MAXE + " = '" + xe.getMaXe() + "'", null);
    }

    public void Them(Xe xe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MAXE, xe.getMaXe());
        values.put(DBHelper.COL_TENXE, xe.getTenXe());
        values.put(DBHelper.COL_DUNGTICH, xe.getDungTich());
        values.put(DBHelper.COL_SOLUONGXE, xe.getSoLuong());
        values.put(DBHelper.COL_IMG_TENXE, xe.getImage());
        values.put(DBHelper.COL_MALOAI, xe.getMaLoai());
        database.insert(DBHelper.TABLE_TENXE, null, values);
    }

    public ArrayList<String> getMaXe() {
        ArrayList<String> ma = new ArrayList<>();
        String sql = "SELECT " + DBHelper.COL_MAXE + " FROM " + DBHelper.TABLE_TENXE;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {
            cursor = database.rawQuery(sql, null);
        } catch (SQLiteException ex) {

        }

        if (cursor != null) {
            cursor.moveToFirst();


            while (!cursor.isAfterLast()) {
                ma.add(cursor.getString(0));
                cursor.moveToNext();
            }

        } else {
            Log.d("loi", "LOI~");
        }


        return ma;
    }

    public ArrayList<Xe> getDL() {
        ArrayList<Xe> xes = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_TENXE;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {
            cursor = database.rawQuery(sql, null);
        } catch (SQLiteException ex) {

        }

        if (cursor != null) {
            cursor.moveToFirst();


            while (!cursor.isAfterLast()) {
                Xe xe = new Xe();
//                xe.setMaXe(cursor.getString(cursor.getColumnIndex(DBHelper.COL_MAXE)));
//                xe.setTenXe(cursor.getString(cursor.getColumnIndex(DBHelper.COL_TENXE)));
//                xe.setDungTich(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_DUNGTICH)));
//                xe.setSoLuong(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_SOLUONGXE)));
//                xe.setImage(cursor.getString(cursor.getColumnIndex(DBHelper.COL_IMG_TENXE)));
//                xe.setMaLoai(cursor.getString(cursor.getColumnIndex(DBHelper.COL_MALOAI)));
                xe.setMaXe(cursor.getString(0));
                xe.setTenXe(cursor.getString(1));
                xe.setDungTich(cursor.getInt(2));
                xe.setSoLuong(cursor.getInt(3));
                xe.setImage(cursor.getString(4));
                xe.setMaLoai(cursor.getString(5));
                xes.add(xe);
                cursor.moveToNext();
            }

        } else {
            Log.d("loi", "LOI~");
        }


        return xes;

    }

}
