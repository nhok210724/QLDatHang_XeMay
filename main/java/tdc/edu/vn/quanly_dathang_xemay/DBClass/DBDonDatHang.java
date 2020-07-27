package tdc.edu.vn.quanly_dathang_xemay.DBClass;

import android.content.Context;

import tdc.edu.vn.quanly_dathang_xemay.dbhelp.DBHelper;

public class DBDonDatHang {
    //New Properties
    DBHelper dbHelper;
    //Cau Truy Van:

 public static final    String sql = "Create Table " + DBHelper.TABLE_DONDATHANG
            + "(" + DBHelper.COL_MADONDATHANG + " text PRIMARY KEY,"
            + DBHelper.COL_NGAYLAP + " Date "
            + ")";


    public DBDonDatHang(Context context) {

        dbHelper = new DBHelper(context);

    }
}
