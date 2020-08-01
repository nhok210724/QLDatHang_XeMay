package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;
import tdc.edu.vn.quanly_dathang_xemay.model.ChiTietDonDatHang;

public class DBChiTietDonDatHang {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

    public static final String sql = "Create Table " + DBHelper.TABLE_CHITIETDONHANG
            + "( " + DBHelper.COL_MADONDATHANG + " text, "
            + DBHelper.COL_MAXE + " text, "
            + DBHelper.COL_SOLUONGDATHANG + " int, "
            + DBHelper.COL_DONGIA + " int, "
            + "CONSTRAINT fk_MaDonDatHang_ChiTiet" +
            "   FOREIGN KEY (" + DBHelper.COL_MADONDATHANG + ")"
            + "   REFERENCES " + DBHelper.TABLE_DONDATHANG + "(" + DBHelper.COL_MADONDATHANG + "),"
            + "CONSTRAINT fk_MaXe_ChiTiet" +
            "   FOREIGN KEY (" + DBHelper.COL_MAXE + ")"
            + "   REFERENCES " + DBHelper.TABLE_TENXE + "(" + DBHelper.COL_MAXE + ")" + ")";


    public DBChiTietDonDatHang(Context context) {

        dbHelper = new DBHelper(context);


    }

    public void Them(ChiTietDonDatHang chiTietDonDatHang) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MADONDATHANG, chiTietDonDatHang.getMaDDH());

        values.put(DBHelper.COL_MAXE, chiTietDonDatHang.getMaXe());
        values.put(DBHelper.COL_SOLUONGDATHANG, chiTietDonDatHang.getSoLuongDatHang());
        values.put(DBHelper.COL_DONGIA, chiTietDonDatHang.getDonGia());

        /*values.put("MaLoai", ctyXe.getMaLoai());
        values.put("TenLoai", ctyXe.getTenLoai());
        values.put("XuatXu", ctyXe.getXuatXu());
        values.put("image", ctyXe.getImage());*/
        database.insert(DBHelper.TABLE_CHITIETDONHANG, null, values);
    }

    public void Xoa(ChiTietDonDatHang chiTietDonDatHang) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "Delete from " + DBHelper.TABLE_CHITIETDONHANG + " Where " + DBHelper.COL_MADONDATHANG + " = '" + chiTietDonDatHang.getMaDDH() + "'";
        database.execSQL(sql);
    }

    public void Sua(ChiTietDonDatHang chiTietDonDatHang) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_MADONDATHANG, chiTietDonDatHang.getMaDDH());
        values.put(DBHelper.COL_MAXE, chiTietDonDatHang.getMaXe());
        values.put(DBHelper.COL_SOLUONGDATHANG, chiTietDonDatHang.getSoLuongDatHang());
        values.put(DBHelper.COL_DONGIA, chiTietDonDatHang.getDonGia());
        database.update(DBHelper.TABLE_CHITIETDONHANG, values, DBHelper.COL_MADONDATHANG + " = '" + chiTietDonDatHang.getMaDDH() + "'", null);
    }


    public ArrayList<ChiTietDonDatHang> get_ChiTietDonDatHang() {
        ArrayList<ChiTietDonDatHang> chiTietDonDatHangs = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABLE_CHITIETDONHANG;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(cursor.getString(0),
                    cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
            chiTietDonDatHangs.add(chiTietDonDatHang);
            cursor.moveToNext();
        }

        cursor.close();
        return chiTietDonDatHangs;
    }

}
