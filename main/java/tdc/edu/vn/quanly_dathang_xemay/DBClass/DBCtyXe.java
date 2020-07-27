package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;
import tdc.edu.vn.quanly_dathang_xemay.model.CtyXe;

public class DBCtyXe {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    static public final String sql = "CREATE TABLE " + DBHelper.TABLE_CTYXE
            + "(" + DBHelper.COL_MALOAI + " TEXT PRIMARY KEY, "
            + DBHelper.COL_TENLOAI + " TEXT , "
            + DBHelper.COL_XUATXU + " TEXT , "
            + DBHelper.COL_IMG_CTYXE + " TEXT)";


    public DBCtyXe(Context context) {

        dbHelper = new DBHelper(context);


    }

    public void Them(CtyXe ctyXe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MALOAI, ctyXe.getMaLoai());
        values.put(DBHelper.COL_TENLOAI, ctyXe.getTenLoai());
        values.put(DBHelper.COL_XUATXU, ctyXe.getXuatXu());
        values.put(DBHelper.COL_IMG_CTYXE, ctyXe.getImage());
        /*values.put("MaLoai", ctyXe.getMaLoai());
        values.put("TenLoai", ctyXe.getTenLoai());
        values.put("XuatXu", ctyXe.getXuatXu());
        values.put("image", ctyXe.getImage());*/
        database.insert("CtyXe", null, values);
    }

    public void Xoa(CtyXe ctyXe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "Delete from " + DBHelper.TABLE_CTYXE + " Where " + DBHelper.COL_MALOAI + " = '" + ctyXe.getMaLoai() + "'";
        database.execSQL(sql);
    }

    public void Sua(CtyXe ctyXe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MALOAI, ctyXe.getMaLoai());
        values.put(DBHelper.COL_TENLOAI, ctyXe.getTenLoai());
        values.put(DBHelper.COL_XUATXU, ctyXe.getXuatXu());
        values.put(DBHelper.COL_IMG_CTYXE, ctyXe.getImage());
        database.update(DBHelper.TABLE_CTYXE, values, DBHelper.COL_MALOAI + " = '" + ctyXe.getMaLoai() + "'", null);
    }

    public ArrayList<String> getMaloai() {
        ArrayList<String> maLoais = new ArrayList<>();

        String sql = "SELECT " + DBHelper.COL_MALOAI + " FROM " + DBHelper.TABLE_CTYXE;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String ma = cursor.getString(0);
            maLoais.add(ma);
            cursor.moveToNext();
        }

        cursor.close();
        return maLoais;
    }

    public ArrayList<CtyXe> get_ctyXes() {
        ArrayList<CtyXe> ctyXes = new ArrayList<>();
        String sql = "SELECT * FROM CtyXe";
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();
      /*  do {
            CtyXe ctyXe = new CtyXe();
            ctyXe.setMaLoai(cursor.getString(0));
            ctyXe.setTenLoai(cursor.getString(1));
            ctyXe.setXuatXu(cursor.getString(2));
            ctyXe.setImage(cursor.getString(3));

            ctyXes.add(ctyXe);
        } while (cursor.moveToNext());*/


        while (!cursor.isAfterLast()) {
            CtyXe ctyXe = new CtyXe();
            ctyXe.setMaLoai(cursor.getString(0));
            ctyXe.setTenLoai(cursor.getString(1));
            ctyXe.setXuatXu(cursor.getString(2));
            ctyXe.setImage(cursor.getString(3));

            ctyXes.add(ctyXe);
            cursor.moveToNext();
        }

        cursor.close();
        return ctyXes;
    }

}
