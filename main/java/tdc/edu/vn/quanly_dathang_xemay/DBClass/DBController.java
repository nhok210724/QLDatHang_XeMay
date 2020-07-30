package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBController {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:
    public static final String sql = "CREATE TABLE Tempp(img TEXT,MaXe TEXT,TenXe TEXT,SoLuong int , DonGia int)";

    public DBController(Context context) {

        dbHelper = new DBHelper(context);

    }

    public void Them(String img, String MaXe, String TenXe, int SoLuong, int DonGia) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("img", img);
        values.put("MaXe", MaXe);
        values.put("TenXe", TenXe);
        values.put("SoLuong", SoLuong);
        values.put("DonGia", DonGia);

        database.insert("Tempp", null, values);
    }

    public void Xoa(String maXe) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String sql = "Delete from Tempp where MaXe = '" + maXe + "'";
        database.execSQL(sql);
    }

    public ArrayList<ArrayList> getTempp() {
        ArrayList<ArrayList> data = new ArrayList<>();
        ArrayList<String> node = new ArrayList<>();
        String sql = "SELECT * FROM Tempp";
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String img = cursor.getString(0);
            String MaXe = cursor.getString(1);
            String TenXe = cursor.getString(2);
            String soLuongDH = cursor.getInt(3) + "";
            String donGia = cursor.getInt(4) + "";

            node.add(img);
            node.add(MaXe);
            node.add(TenXe);
            node.add(soLuongDH);
            node.add(donGia);

            data.add(node);
            cursor.moveToNext();
        }

        cursor.close();
        return data;
    }
}
