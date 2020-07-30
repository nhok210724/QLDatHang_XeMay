package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;
import tdc.edu.vn.quanly_dathang_xemay.model.DonDatHang;

public class DBDonDatHang {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    public static final String sql = "Create Table " + DBHelper.TABLE_DONDATHANG
            + "(" + DBHelper.COL_MADONDATHANG + " text PRIMARY KEY,"
            + DBHelper.COL_NGAYLAP + " Text "
            + ")";


    public DBDonDatHang(Context context) {

        dbHelper = new DBHelper(context);

    }

    public void Them(DonDatHang donDatHang) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MADONDATHANG, donDatHang.getMaDDH());

        values.put(DBHelper.COL_NGAYLAP, donDatHang.getNgayLap().toString());

        /*values.put("MaLoai", ctyXe.getMaLoai());
        values.put("TenLoai", ctyXe.getTenLoai());
        values.put("XuatXu", ctyXe.getXuatXu());
        values.put("image", ctyXe.getImage());*/
        database.insert(DBHelper.TABLE_DONDATHANG, null, values);
    }

    public void Xoa(DonDatHang donDatHang) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "Delete from " + DBHelper.TABLE_DONDATHANG + " Where " + DBHelper.COL_MADONDATHANG + " = '" + donDatHang.getMaDDH() + "'";
        database.execSQL(sql);
    }

    public void Sua(DonDatHang donDatHang) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MADONDATHANG, donDatHang.getMaDDH());
        values.put(DBHelper.COL_NGAYLAP, donDatHang.getNgayLap().toString());

        database.update(DBHelper.TABLE_DONDATHANG, values, DBHelper.COL_MADONDATHANG + " = '" + donDatHang.getMaDDH() + "'", null);
    }

    public ArrayList<String> get_MaDDH() {
        ArrayList<String> MaDDH = new ArrayList<>();
        String sql = "SELECT " + DBHelper.COL_MADONDATHANG + " FROM " + DBHelper.TABLE_DONDATHANG;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {

            String ma = cursor.getString(0);
            MaDDH.add(ma);
            cursor.moveToNext();
        }

        cursor.close();
        return MaDDH;
    }

    public ArrayList<DonDatHang> get_DonDatHang() {
        ArrayList<DonDatHang> donDatHangs = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_DONDATHANG;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            DonDatHang donDatHang = new DonDatHang(cursor.getString(0));
            donDatHang.setNgayLap(cursor.getString(1));


            donDatHangs.add(donDatHang);
            cursor.moveToNext();
        }

        cursor.close();
        return donDatHangs;
    }
}
